package com.mediasoft.odeks.web;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.User;
import com.mediasoft.odeks.repositories.UserRepository;
import com.sun.media.jfxmedia.Media;

@RestController
public class UserRestEndPoint {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager  authentificationManager;
	
	@RequestMapping(method = RequestMethod.POST,path = "/users/connectedUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User addNewMasterJournal(@RequestBody(required = true) JournalMaster journalMaster) {
		Optional<User> user = null;
		try {
			user=this.userRepository.findById(1);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return user.get();
	}
	@SuppressWarnings("null")
	@RequestMapping(method = RequestMethod.POST,path = "/users/login",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> Login(@RequestParam(value = "identifiant") String identifiant,@RequestParam(value="password") String password) throws Exception {
		Authentication auth=null;
		auth=   this.authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(identifiant, password));
		if(auth!=null) {
			User user=new User();
			user.setName(auth.getPrincipal().toString());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(new User(), HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
