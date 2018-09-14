package com.personalapp.repository;

import static com.personalapp.util.APIUtil.LOGIN_URL;
import static org.springframework.http.HttpMethod.POST;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomRestTemplate;
import com.personalapp.model.suport.Token;
import com.personalapp.util.JsonUtil;

@SuppressWarnings("serial")
public class LoginDao implements Serializable {

	private final CustomRestTemplate restTemplate;
	private final JsonUtil jsonUtil;
	private final ExternalContext externalContext;
	
	@Inject
	public LoginDao(CustomRestTemplate restTemplate, JsonUtil jsonUtil, ExternalContext externalContext) {
		this.restTemplate = restTemplate;
		this.jsonUtil = jsonUtil;
		this.externalContext = externalContext;
	}

	@ExceptionHandler
    public Token loginReturningToken(String username, String password) throws IOException {
        String loginJson = "{\"username\":" + addQuotes(username) + ",\"password\":" + addQuotes(password) + "}";
        	try {
        		ResponseEntity<Token> tokenExchange = restTemplate.exchange(LOGIN_URL, POST, new HttpEntity<>(loginJson, this.jsonUtil.createJsonHeader()), Token.class);
        		return tokenExchange.getBody();
        	} catch (Exception e) {
        		this.externalContext.redirect
            	(this.externalContext.getApplicationContextPath() + "/login.xhtml");
        		return null;
        	}
    }

    private String addQuotes(String value) {
        return new StringBuilder(300).append("\"").append(value).append("\"").toString();
    }
}

