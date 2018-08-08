package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import java.io.Serializable;

import javax.inject.Inject;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.model.MedidasCorporais;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class MedidasDao implements Serializable {
	
	
	private final String INFO_URL = APIUtil.BASE_URL + "/professor/alunos/medidas";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/medidas/{email}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	
	@Inject
	public MedidasDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
	}
	
	public MedidasCorporais save(MedidasCorporais medidasCorporais) {
		if (medidasCorporais.getMetodoDeAvaliacao() != null && !medidasCorporais.getMetodoDeAvaliacao().trim().equals("")) {
			return this.restTemplate.exchange(INFO_URL, POST, this.jsonUtil.tokenizedHttpEntityHeader(medidasCorporais), MedidasCorporais.class).getBody();			
		} else {
			return null;
		}
	}
	
	@ExceptionHandler
    public MedidasCorporais findOne(String email) {
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), MedidasCorporais.class, email).getBody();
    }

}
