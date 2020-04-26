package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.odeks.model.AccountChart;
import com.mediasoft.odeks.model.AccountSubledger;
import com.mediasoft.odeks.repositories.AccountChartSubLedger;

@RestController
public class AccountSubLedgerRestEndPoint {
	@Autowired
	public AccountChartSubLedger chartAccountSubLedgerRepository;
	@PostMapping("/chartAccountSubLedger/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<AccountSubledger> serachChartAccount(@RequestParam(value = "code",required = false) String code) {
		if(code==null) {
			return this.chartAccountSubLedgerRepository.findAll();
		}else {
			return this.chartAccountSubLedgerRepository.serachByCode(code);
		}
	
	}
}
