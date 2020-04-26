package com.mediasoft.odeks.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;


public class AuthentificationEndPoint extends BasicAuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader("WWW-Authebticate", "Basic relam="+this.getRealmName());
	    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    PrintWriter write=response.getWriter();
	    write.println("HTTP Status 401"+authException.getMessage());
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("domain");
		super.afterPropertiesSet();
	}
	
  
}
