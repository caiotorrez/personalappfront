package com.personalapp.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.personalapp.util.TokenUtil;

@SuppressWarnings("serial")
@WebFilter(urlPatterns = {"/aluno/*", "/professor/*"}, description = "Session checker filter")
public class LoginFilter implements Filter, Serializable {
	
	@Inject
	private TokenUtil tokenUtil;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		    wrapper.setBufferSize(10000000);
		    String loginURL = request.getContextPath() + "/login.xhtml";

		    boolean loggedIn = tokenUtil != null && this.isTokenValid(request);
		    boolean loginRequest = request.getRequestURI().startsWith(loginURL);
		    boolean resourceRequest = request.getRequestURI().contains(ResourceHandler.RESOURCE_IDENTIFIER);

		    if (loggedIn || loginRequest || resourceRequest) {
		        if (!resourceRequest) { // Prevent restricted pages from being cached.
		        	wrapper.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		        	wrapper.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        	wrapper.setDateHeader("Expires", 0); // Proxies.
		        }
		        try {
		        	chain.doFilter(request, wrapper);
		        } catch (Exception e) {
		        	wrapper.sendRedirect(loginURL);
		        }
		    } else {
		    	wrapper.sendRedirect(loginURL);
		    }
		}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	private boolean isTokenValid(HttpServletRequest request) {
		return tokenUtil.isExpirationTimeFromCookieValid(request) && !tokenUtil.getTokenFromCookies(request).isEmpty();
	}
}
