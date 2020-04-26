package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mediasoft.odeks.model.AccountChart;
import com.mediasoft.odeks.repositories.ChartAccountRepository;
@RestController
public class AccountChartRestEndPoint {

	@Autowired
	public ChartAccountRepository chartAccountRepository;
	@PostMapping("/chartAccount/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<AccountChart> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return (List<AccountChart>) this.chartAccountRepository.findAll();
		}else {
			return this.chartAccountRepository.serachByCode(code);
		}
		
	}
}
