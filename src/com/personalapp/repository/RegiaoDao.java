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
import com.personalapp.model.treino.RegiaoMuscular;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class RegiaoDao implements Serializable {
	
	private final String TREINO_URL = APIUtil.BASE_URL + "/professor/alunos/treino/regiao";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/treino/regiao/{id}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	private final CustomTypeReference<List<RegiaoMuscular>> listRegioes;
	
	@Inject
	public RegiaoDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil,
			CustomTypeReference<List<RegiaoMuscular>> listRegioes) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
		this.listRegioes = listRegioes;
	}
	
	@ExceptionHandler
	public List<RegiaoMuscular> list(String titulo) {
		UriComponents url = UriComponentsBuilder.fromUriString(TREINO_URL).queryParam("titulo", titulo).build();
		ResponseEntity<List<RegiaoMuscular>> exchange = this.restTemplate.exchange(url.toUriString(), GET, this.jsonUtil.tokenizedHttpEntityHeader(), listRegioes.typeReference());
		return exchange.getBody();
	}
	
	@ExceptionHandler
    public RegiaoMuscular findOne(Long id) {
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), RegiaoMuscular.class, id).getBody();
    }
    
    public RegiaoMuscular update(RegiaoMuscular regiao) {
    	return this.restTemplate.exchange(TREINO_URL, PUT, this.jsonUtil.tokenizedHttpEntityHeader(regiao), RegiaoMuscular.class).getBody();
    }

	public RegiaoMuscular save(RegiaoMuscular regiao) {
		if (regiao.getExcecicio1() != null) {
			return this.restTemplate.exchange(TREINO_URL + "/new", POST, this.jsonUtil.tokenizedHttpEntityHeader(regiao), RegiaoMuscular.class).getBody();
		} else {
			return null;
		}
	}
}
