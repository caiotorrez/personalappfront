package com.personalapp.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.custom.CustomURLEncoderDecoder;
import com.personalapp.model.suport.Token;
import com.personalapp.repository.LoginDao;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;
    private final LoginDao loginDAO;
    private final ExternalContext externalContext;
    private String session;

    @Inject
    public LoginBean(LoginDao loginDAO, ExternalContext externalContext) {
        this.loginDAO = loginDAO;
        this.externalContext = externalContext;
    }
    
    public void validateSeassion() throws IOException {
    	if (this.session != null) this.externalContext.redirect
    	(this.externalContext.getApplicationContextPath() + "/" + this.session + "/index.xhtml");
    }

    public String login() throws IOException {
    	Token token = this.loginDAO.loginReturningToken(this.username, this.password);
        if (token == null) {
        	return null;
        }
        this.session = token.getAccessType();
        addTokenAndExpirationTimeToCookies(token.getToken(), token.getExpirationTime().toString());
        return token.getAccessType().equals("professor") ? "/professor/index.xhtml?faces-redirect=true" : "/aluno/index.xhtml?faces-redirect=true";
    }

    private void addTokenAndExpirationTimeToCookies(String token, String expirationTime) {
    	this.externalContext.addResponseCookie("token", CustomURLEncoderDecoder.encodeUTF8(token), null);
    	this.externalContext.addResponseCookie("expirationTime", expirationTime, null);
    }
    
    public String logout() throws IOException {
    	this.session = null;
        removeTokenAndExpirationTimeFromCookies();
        this.externalContext.responseReset();
        this.externalContext.invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    private void removeTokenAndExpirationTimeFromCookies() {
        addTokenAndExpirationTimeToCookies(null, null);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
