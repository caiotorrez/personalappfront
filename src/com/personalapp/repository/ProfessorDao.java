package com.personalapp.repository;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.personalapp.model.Professor;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class ProfessorDao implements Serializable {
	
	private final String BASE_URL = "http://localhost:8085/v1/professor/{id}";
	private final JsonUtil jsonUtil;
	
	@Inject
	public ProfessorDao(JsonUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}

	public Professor getProfessorById(Long id) {
		ResponseEntity<Professor> professorEntity = new RestTemplate().exchange(BASE_URL, HttpMethod.GET, new HttpEntity<>(jsonUtil.createTokenizedHeader()), Professor.class);
		return professorEntity.getBody();
	}
							
}
