package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.DevelopmentPartnerInformation;
import com.mediasoft.odeks.repositories.PartnerRepository;

@RestController
public class PartnerRestEndPoint {
	@Autowired
	public PartnerRepository partnerRepository;
	@PostMapping("/partner/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<DevelopmentPartnerInformation> serachProjectIdentifier(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return (List<DevelopmentPartnerInformation>) this.partnerRepository.findAll();
		}else {
			return this.partnerRepository.serachByCode(code);
		}
		
	}
}
