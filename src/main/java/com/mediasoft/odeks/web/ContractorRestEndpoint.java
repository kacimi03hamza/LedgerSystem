package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.Contractor;
import com.mediasoft.odeks.repositories.ContractorRepository;
@RestController
public class ContractorRestEndpoint {
	@Autowired
	public ContractorRepository contractorRepository;
	@PostMapping("/contractor/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Contractor> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		
		if(code==null) {
			return (List<Contractor>) this.contractorRepository.findAll();
		}else {
			return this.contractorRepository.serachByCode(code);
		}
		
	}
}
