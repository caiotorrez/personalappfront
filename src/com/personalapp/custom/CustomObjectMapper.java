package com.personalapp.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SuppressWarnings("serial")
public class CustomObjectMapper extends ObjectMapper {
	
	public CustomObjectMapper() {
		this.registerModule(new JavaTimeModule());
	}

}
