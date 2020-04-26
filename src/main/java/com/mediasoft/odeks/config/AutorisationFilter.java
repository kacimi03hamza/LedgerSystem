package com.mediasoft.odeks.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mediasoft.odeks.services.userDetailService;

public class AutorisationFilter extends BasicAuthenticationFilter  {

	@Autowired
	private AuthenticationManager authentificationManager;
	@Autowired
	private userDetailService userdetailService;
	public AutorisationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doFilterInternal(HttpServletRequest arg0, HttpServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		 HttpServletRequest httprequest=(HttpServletRequest)arg0;
		String token= httprequest.getHeader("Authorization");
		if("123".equals(token)) {
			Authentication authentication = getAuthentication(httprequest);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        arg2.doFilter(arg0, arg1);
	        return;
		}else if("/users/login".equals(arg0.getRequestURI())) {
			arg2.doFilter(arg0, arg1);
		}
		else {
			arg1.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			arg1.setHeader("WWW-Authebticate", "Basic relam="+"domaine");
			arg1.setContentType(MediaType.APPLICATION_JSON_VALUE);
		    PrintWriter write=arg1.getWriter();
		    write.println("HTTP Status 401");
		}
		
		
	}

	private Authentication getAuthentication(HttpServletRequest httprequest) {
		Authentication authentification=  this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken("h1.kacimi@domain.com", "p@@ssworD123"));   
		return authentification;
	}

	public AuthenticationManager getAuthentificationManager() {
		return authentificationManager;
	}

	public void setAuthentificationManager(AuthenticationManager authentificationManager) {
		this.authentificationManager = authentificationManager;
	}

	public userDetailService getUserdetailService() {
		return userdetailService;
	}

	public void setUserdetailService(userDetailService userdetailService) {
		this.userdetailService = userdetailService;
	}
  
	

}
