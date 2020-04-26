package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.Supplier;
import com.mediasoft.odeks.repositories.SupplierRepository;

@RestController
public class SupplierEndPoint {
	@Autowired
	public SupplierRepository supplierrRepository;
	@PostMapping("/supplier/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Supplier> serachProjectIdentifier(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return (List<Supplier>) this.supplierrRepository.findAll();
		}else {
			return this.supplierrRepository.serachByCode(code);
		}
		
	}
}
