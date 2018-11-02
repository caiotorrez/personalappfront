package com.personalapp.util;

import static com.personalapp.custom.CustomURLEncoderDecoder.decodeUTF8;

import java.io.Serializable;
import java.util.Map;

import javax.faces.annotation.RequestCookieMap;
import javax.inject.Inject;
import javax.servlet.http.Cookie;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SuppressWarnings("serial")
public class JsonUtil implements Serializable {

	@Inject
	@RequestCookieMap
	private Map<String, Object> cookieMap;
	
	public HttpHeaders createJsonHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return header;
    }
    
	public HttpHeaders createTokenizedHeader() {
        HttpHeaders header = createJsonHeader();
        Cookie tokenCookie = (Cookie) this.cookieMap.get("_sh_");
        header.add("Authorization", "Bearer " + decodeUTF8(tokenCookie.getValue()));
        return header;
    }
	
	public HttpEntity tokenizedHttpEntityHeader() {
		return new HttpEntity(createTokenizedHeader());
	}

	public <E> HttpEntity<E> tokenizedHttpEntityHeader(E entity) {
		return new HttpEntity<>(entity, createTokenizedHeader());
	}
}
