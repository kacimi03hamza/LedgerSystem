package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.CostCenterDetails;
import com.mediasoft.odeks.repositories.CostCenterDetailRepository;

@RestController
public class CostDetailRestEndPoint {
	@Autowired
	public CostCenterDetailRepository costCenterDetailRepository;
	@PostMapping("/costCenter/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<CostCenterDetails> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		
		if(code==null) {
			return (List<CostCenterDetails>) this.costCenterDetailRepository.findAll();
		}else {
			return this.costCenterDetailRepository.serachByCode(code);
		}
		
	}
}
