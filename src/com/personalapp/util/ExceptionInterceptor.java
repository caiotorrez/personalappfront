package com.personalapp.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.stream.Collectors;

import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.omnifaces.util.Messages;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.personalapp.config.ExceptionHandler;
import com.personalapp.custom.CustomObjectMapper;
import com.personalapp.model.suport.ErrorDetail;
import com.personalapp.model.suport.Errors;

@SuppressWarnings("serial")
@Interceptor
@ExceptionHandler
public class ExceptionInterceptor implements Serializable {
	
	 private final ExternalContext externalContext;

	@Inject
	public ExceptionInterceptor(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws JsonParseException, JsonMappingException, IOException {
		Object result = null;
		try {
			result = context.proceed();
		} catch (Exception e) {
			if (e instanceof HttpClientErrorException) {
				HttpStatusCodeException httpExcetion = (HttpStatusCodeException) e;
				Messages.addGlobalError(this.defineErroMessage((HttpStatusCodeException) e));
				redirectDeniedPage(httpExcetion.getRawStatusCode());
			} else {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private void redirectDeniedPage(int statusCode) throws IOException {
		if (statusCode == 403 || statusCode == 401) {
			externalContext.redirect("denied.xhtml");
		}
	}
	
	private String  defineErroMessage(HttpStatusCodeException codeExcept) throws JsonParseException, JsonMappingException, IOException {
		ErrorDetail errorDetail = new CustomObjectMapper().readValue(codeExcept.getResponseBodyAsString(), ErrorDetail.class);
		return errorDetail.getErrorsList() == null ? errorDetail.getMessage() : errorDetail.getErrorsList()
				.stream().map(Errors::getDefaultMessage).collect(Collectors.joining(","));
	}
}
