package com.personalapp.custom;

import java.io.Serializable;

import org.springframework.core.ParameterizedTypeReference;

@SuppressWarnings("serial")
public class CustomTypeReference<T> extends ParameterizedTypeReference<T> implements Serializable {
	
	public ParameterizedTypeReference<T> typeReference() {
		return new CustomTypeReference<T>() { };
	}
}
