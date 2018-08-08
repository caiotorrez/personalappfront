package com.personalapp.bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.suport.Token;
import com.personalapp.repository.AlunoDao;
import com.personalapp.repository.LoginDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginBean implements Serializable {
	
	private String username;
	private String password;
	private final LoginDao loginDao;
	private final ExternalContext externalContext;
	
	@Inject
	public LoginBean(LoginDao loginDao, ExternalContext externalContext, AlunoDao alunoDao) {
		this.loginDao = loginDao;
		this.externalContext = externalContext;
		
	}
	
	public String login() throws UnsupportedEncodingException {
		Token token = loginDao.loginReturningToken(username, password);
		return token == null ? null : addTokenAndExpirationTimetoCookiesAndReturnIndex(token);
	}
	
	public String logout() {
		externalContext.addResponseCookie("token", null, null);
		externalContext.addResponseCookie("expirationTime", null, null);
		return "login.xhtml?faces-redirect=true";
	}
	
	private String addTokenAndExpirationTimetoCookiesAndReturnIndex(Token token) throws UnsupportedEncodingException {
		externalContext.addResponseCookie("token", URLEncoder.encode(token.getToken(), "UTF-8"), null);
		externalContext.addResponseCookie("expirationTime", token.getExpirationTime().toString(), null);
		if (username.contains("@")) {
			return "user_index.xhtml?faces-redirect=true";
		}
		return "index.xhtml?faces-redirect=true";
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
