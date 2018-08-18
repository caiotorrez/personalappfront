package com.personalapp.bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

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
   

    @Inject
    public LoginBean(LoginDao loginDAO, ExternalContext externalContext) {
        this.loginDAO = loginDAO;
        this.externalContext = externalContext;
    }

    public String login() throws UnsupportedEncodingException {
        Token token = loginDAO.loginReturningToken(username, password);
        if (token == null) return null;
        addTokenAndExpirationTimeToCookies(token.getToken(), token.getExpirationTime().toString());
        return token.getAccessType().equals("professor") ? "/professor/index.xhtml?faces-redirect=true" : "/aluno/index.xhtml?faces-redirect=true";
    }

    public String logout() {
        removeTokenAndExpirationTimeFromCookies();
        return "login.xhtml?faces-redirect=true";
    }

    private void addTokenAndExpirationTimeToCookies(String token, String expirationTime) {
        externalContext.addResponseCookie("token", CustomURLEncoderDecoder.encodeUTF8(token), null);
        externalContext.addResponseCookie("expirationTime", expirationTime, null);
    }

    private void removeTokenAndExpirationTimeFromCookies() {
        addTokenAndExpirationTimeToCookies(null, null);
    }

    public String getUsername() {
        return username;
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
