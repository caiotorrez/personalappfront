package com.personalapp.repository;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import java.io.Serializable;

import javax.inject.Inject;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.model.Imagem;
import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.util.APIUtil;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class ImagemDao implements Serializable {
	
	private final String UPLOAD_URL = APIUtil.BASE_URL + "/professor/imagem/upload";
	private final String GET_URL = APIUtil.BASE_URL + "/professor/imagem/{id}";
	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	
	@Inject
	public ImagemDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
	}
	
    public Imagem findOne(Long id) {
    	if (id < 0) {
    		return null;
    	}
        return this.restTemplate.exchange(GET_URL, GET, this.jsonUtil.tokenizedHttpEntityHeader(), Imagem.class, id).getBody();
    }
    
    
	public Imagem save(Imagem imagem) {
		return this.restTemplate.exchange(UPLOAD_URL, POST, this.jsonUtil.tokenizedHttpEntityHeader(imagem), Imagem.class).getBody();
	}
}
