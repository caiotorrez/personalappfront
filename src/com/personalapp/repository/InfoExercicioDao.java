package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import java.io.Serializable;

import javax.inject.Inject;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.model.treino.InfoExercicio;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class InfoExercicioDao implements Serializable {
	
	private final String INFO_URL = APIUtil.BASE_URL + "/professor/alunos/treino/infoexercicio";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/treino/infoexercicio/{id}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	
	@Inject
	public InfoExercicioDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
	}
	
    @ExceptionHandler
    public InfoExercicio findOne(Long id) {
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), InfoExercicio.class, id).getBody();
    }
    
	public InfoExercicio save(InfoExercicio infoExercicio) {
		return this.restTemplate.exchange(INFO_URL, POST, this.jsonUtil.tokenizedHttpEntityHeader(infoExercicio), InfoExercicio.class).getBody();			
		}

}