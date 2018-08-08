package com.personalapp.custom;

import java.io.Serializable;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("serial")
public class CustomRestTemplate extends RestTemplate implements Serializable {
	
	public CustomRestTemplate() {
		this.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}

}
