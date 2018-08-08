package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.custom.CustomTypeReference;
import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class TreinoDao implements Serializable {

	private final String TREINO_URL = APIUtil.BASE_URL + "/professor/alunos/treino";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/treino/{id}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	private final CustomTypeReference<List<FichaDeTreino>> listTreinos;
	
	@Inject
	public TreinoDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil, CustomTypeReference<List<FichaDeTreino>> listTreinoTypeReference) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
		this.listTreinos = listTreinoTypeReference;
	}
	
	@ExceptionHandler
	public List<FichaDeTreino> list(String titulo) {
		UriComponents url = UriComponentsBuilder.fromUriString(TREINO_URL).queryParam("titulo", titulo).build();
		ResponseEntity<List<FichaDeTreino>> exchange = this.restTemplate.exchange(url.toUriString(), GET, this.jsonUtil.tokenizedHttpEntityHeader(), listTreinos.typeReference());
		return exchange.getBody();
	}
	
    @ExceptionHandler
    public FichaDeTreino findOne(Long id) {
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), FichaDeTreino.class, id).getBody();
    }

	public FichaDeTreino save(FichaDeTreino fichaDeTreino) {
		return this.restTemplate.exchange(TREINO_URL + "/new", POST, this.jsonUtil.tokenizedHttpEntityHeader(fichaDeTreino), FichaDeTreino.class).getBody();
	}
}
