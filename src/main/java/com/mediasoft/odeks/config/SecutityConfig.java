package com.mediasoft.odeks.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.request.RequestContextListener;


import com.mediasoft.odeks.services.userDetailService;
@Configuration
public class SecutityConfig extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter {
    @Autowired
	private userDetailService userDetailservice;
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf()
		.disable().
		authorizeRequests()
		.antMatchers("/JournalMaster/edit*")
		.hasAnyAuthority("USER")
		.and()
		
		 .authorizeRequests()
		.anyRequest().permitAll()
		.and()
	   .addFilterBefore(new AutorisationFilter(authenticationManagerBean()), AutorisationFilter.class)
	   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(userDetailservice);
		
	}
	public userDetailService getUserDetailservice() {
		return userDetailservice;
	}
	public void setUserDetailservice(userDetailService userDetailservice) {
		this.userDetailservice = userDetailservice;
	}
	
	@Bean(name = "authentificationManager")
	   @Override
	   public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	   }
	@Bean 
	public RequestContextListener requestContextListener(){
	    return new RequestContextListener();
	} 
   

}