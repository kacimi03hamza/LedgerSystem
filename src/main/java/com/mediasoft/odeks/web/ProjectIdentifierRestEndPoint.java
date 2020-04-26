package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.ProjectIdentifier;
import com.mediasoft.odeks.repositories.ProjectIdentifierRepository;
@RestController
public class ProjectIdentifierRestEndPoint {
	@Autowired
	public ProjectIdentifierRepository ProjectIdentifierRepository;
	@PostMapping("/project/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProjectIdentifier> serachProjectIdentifier(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return (List<ProjectIdentifier>) this.ProjectIdentifierRepository.findAll();
		}else {
			return this.ProjectIdentifierRepository.serachByCode(code);
		}
		
	}
}
