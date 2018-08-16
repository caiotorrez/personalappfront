package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.custom.CustomTypeReference;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class ExercicioDao implements Serializable {
	
	private final String TREINO_URL = APIUtil.BASE_URL + "/professor/alunos/treino/exercicio";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/treino/exercicio/{titulo}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	private final CustomTypeReference<List<Exercicio>> listExercicios;
	
	@Inject
	public ExercicioDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil, CustomTypeReference<List<Exercicio>> listTreinoTypeReference) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
		this.listExercicios = listTreinoTypeReference;
	}
	
	@ExceptionHandler
	public List<Exercicio> list(String titulo) {
		UriComponents url = UriComponentsBuilder.fromUriString(TREINO_URL).queryParam("titulo", titulo).build();
		ResponseEntity<List<Exercicio>> exchange = this.restTemplate.exchange(url.toUriString(), GET, this.jsonUtil.tokenizedHttpEntityHeader(), listExercicios.typeReference());
		return exchange.getBody();
	}
	
    @ExceptionHandler
    public Exercicio findOne(String titulo) {
    	if (titulo == null || titulo.trim().equals("")) {
    		return null;
    	}
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), Exercicio.class, titulo).getBody();
    }
    
    public Exercicio update(Exercicio exercicio) {
    	return this.restTemplate.exchange(TREINO_URL, PUT, this.jsonUtil.tokenizedHttpEntityHeader(exercicio), Exercicio.class).getBody();
    }

	public Exercicio save(Exercicio exercicio) {
		return this.restTemplate.exchange(TREINO_URL + "/new", POST, this.jsonUtil.tokenizedHttpEntityHeader(exercicio), Exercicio.class).getBody();
	}
}
