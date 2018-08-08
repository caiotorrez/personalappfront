package com.personalapp.util;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import static java.util.Arrays.asList;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class TokenUtil implements Serializable {
	
	public String getTokenFromCookies(HttpServletRequest request) {
		if (request.getCookies() == null) return "";
		List<Cookie> cookieList = asList(request.getCookies());
		return cookieList.stream()
				.filter(cookie -> cookie.getName().equals("token"))
				.map(Cookie::getValue)
				.findFirst().orElse("");
	}
	
	
	public boolean isExpirationTimeFromCookieValid(HttpServletRequest request) {
		if (request.getCookies() == null) return false;
		List<Cookie> cookieList = asList(request.getCookies());
		String expirationTime = cookieList.stream()
				.filter(cookie -> cookie.getName().equals("expirationTime"))
				.map(Cookie::getValue)
				.findFirst().orElse("");
		return validateIfTimeNowIsBeforeTokenExpires(expirationTime);
	}
	
	private boolean validateIfTimeNowIsBeforeTokenExpires(String expirationTime) {
		if (expirationTime.isEmpty()) return false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
				.withZone(ZoneId.of("UTC"));
		LocalDateTime tokenExpirationTime = LocalDateTime.parse(expirationTime, formatter);
		return LocalDateTime.now(ZoneId.of("UTC")).isBefore(tokenExpirationTime);
	}

}
