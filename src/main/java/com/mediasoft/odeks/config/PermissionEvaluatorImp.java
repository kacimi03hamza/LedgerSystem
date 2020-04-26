package com.mediasoft.odeks.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.User;
import com.mediasoft.odeks.model.UserPrincipal;
import com.mediasoft.odeks.repositories.UserRepository;
@Component
public class PermissionEvaluatorImp implements PermissionEvaluator  {
	@Autowired
 private UserRepository userRepository;
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		    if (targetDomainObject == null) // if no domain object is provided,
	            return true;                // let's pass, allowing the service method
	                                        // to throw a more sensible error message
	        if (targetDomainObject instanceof JournalMaster ) {
	            if (permission.equals("edit")) {
	                JournalMaster journalMaster = (JournalMaster) targetDomainObject;
	               Integer id=this.userRepository.findOneByName(auth.getPrincipal().toString()).get().getId();
	               JournalMaster fromDb=this.userRepository.findJournalByIdForUser(journalMaster.getId(), id);
	                if(fromDb!=null) {
	                	return true;
	                }
	                
	            } 
	        }
	        return false;
	}

	@Override
	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		throw new UnsupportedOperationException(
                "hasPermission() by ID is not supported");
	}

}
