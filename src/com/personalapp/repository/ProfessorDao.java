package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.model.Aluno;
import com.personalapp.model.Professor;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class ProfessorDao implements Serializable {
	
	private final String BASE_URL = "http://localhost:8085/v1/professor";
	private final JsonUtil jsonUtil;
	private final CustomRestTemplate restTemplate;
	
	@Inject
	public ProfessorDao(JsonUtil jsonUtil, CustomRestTemplate restTemplate) {
		this.jsonUtil = jsonUtil;
		this.restTemplate = restTemplate;
	}

	public Professor getProfessorById(Long id) {
		ResponseEntity<Professor> professorEntity = new RestTemplate().exchange(BASE_URL + "{id}", HttpMethod.GET, new HttpEntity<>(jsonUtil.createTokenizedHeader()), Professor.class);
		return professorEntity.getBody();
	}
	
    public Professor findProfessorByUsername(String username) {
		UriComponents url = UriComponentsBuilder.fromUriString(BASE_URL).queryParam("username", username).build();
		return this.restTemplate.exchange(url.toUriString(), GET, this.jsonUtil.tokenizedHttpEntityHeader(), Professor.class).getBody();

    }
	
	
							
}
