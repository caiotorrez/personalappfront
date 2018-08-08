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
import com.personalapp.model.Aluno;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class AlunoDao implements Serializable {
	
	private final String ALUNOS_URL = APIUtil.BASE_URL + "/professor/alunos";
	private final String FIND_ONE_URL = APIUtil.BASE_URL + "/professor/alunos/{email}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	private final CustomTypeReference<List<Aluno>> listAluno;
	
	@Inject
	public AlunoDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil, CustomTypeReference<List<Aluno>> listAlunoTypeReference) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
		this.listAluno = listAlunoTypeReference;
	}
	
	@ExceptionHandler
	public List<Aluno> list(String nome) {
		UriComponents url = UriComponentsBuilder.fromUriString(ALUNOS_URL).queryParam("nome", nome).build();
		ResponseEntity<List<Aluno>> exchange = this.restTemplate.exchange(url.toUriString(), GET, this.jsonUtil.tokenizedHttpEntityHeader(), listAluno.typeReference());
		return exchange.getBody();
	}
	
    @ExceptionHandler
    public Aluno findOne(String email) {
        return this.restTemplate.exchange(FIND_ONE_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), Aluno.class, email).getBody();
    }
    
    public Aluno update(Aluno aluno) {
    	return this.restTemplate.exchange(ALUNOS_URL, PUT, this.jsonUtil.tokenizedHttpEntityHeader(aluno), Aluno.class).getBody();
    }

	public Aluno save(Aluno aluno) {
		return this.restTemplate.exchange(ALUNOS_URL, POST, this.jsonUtil.tokenizedHttpEntityHeader(aluno), Aluno.class).getBody();
	}
}
