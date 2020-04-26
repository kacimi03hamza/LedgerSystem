package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.CostCenterDetails;
import com.mediasoft.odeks.repositories.EmployeRepository;
import com.mediasoft.odeks.model.Employe;
@RestController
public class EmployeRestEndPoint {
	@Autowired
 private EmployeRepository employeRepository;
	
	@PostMapping("/employe/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employe> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		
		if(code==null) {
			return (List<Employe>) this.employeRepository.findAll();
		}else {
			return this.employeRepository.serachByCode(code);
		}
		
	}
}
