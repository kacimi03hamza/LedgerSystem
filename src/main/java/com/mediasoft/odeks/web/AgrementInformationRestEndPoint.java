package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.AgreementInformation;
import com.mediasoft.odeks.repositories.AgrementRepository;

@RestController
public class AgrementInformationRestEndPoint {
	@Autowired
	public AgrementRepository agrementRepository;
	@PostMapping("/agrement/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<AgreementInformation> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return (List<AgreementInformation>) this.agrementRepository.findAll();
		}else {
			return this.agrementRepository.serachByCode(code);
		}
		
	}
}
