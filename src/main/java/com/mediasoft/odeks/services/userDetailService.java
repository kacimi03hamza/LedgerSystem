package com.mediasoft.odeks.services;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.User;
import com.mediasoft.odeks.model.UserPrincipal;
import com.mediasoft.odeks.repositories.UserRepository;
import org.springframework.util.StringUtils;



@Service
public class userDetailService  implements AuthenticationProvider{
	@Autowired
private UserRepository userRepository;
	@Autowired
private PasswordEncryp passwordEncoder;
@Autowired
private HttpServletRequest request;
private String identifiant;
private  String password;
	
	public User findByLoginAndPassword(String identifiant) {
		Optional<User> user= this.userRepository.findOneByIdentifiant(identifiant);
        if(!user.isPresent()) {
        	throw new UsernameNotFoundException(identifiant);
        }else {
        	return user.get();
        }
	}

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
	this.identifiant=arg0.getName();
	User user= this.findByLoginAndPassword(this.identifiant);
	boolean check=false;
	boolean result = false;
	if(user!=null && null!=arg0.getCredentials() && !StringUtils.isEmpty(arg0.getCredentials())) {
		System.out.println(user.getPassword());
		System.out.println(arg0.getCredentials());
		result= this.passwordEncoder.matches(arg0.getCredentials().toString(),user.getPassword());
		System.out.println(result+ " ici ");
		if(user!=null) {
			check=true;
		}
		
	}
	if(check && result) {
		UserPrincipal principal=new UserPrincipal(user);
		return new UsernamePasswordAuthenticationToken(principal.getUsername(),"p@@ssworD123",principal.getAuthorities());
			
	}else {
		throw new  BadCredentialsException("Bad Credentials");
		}
	}
	
	
	public void setAuthentication(String identifiant,String password) {
		this.setIdentifiant(identifiant);
		this.setPassword(password);
	}
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public PasswordEncryp getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncryp passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
