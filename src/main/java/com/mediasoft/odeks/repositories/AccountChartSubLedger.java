package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.AccountSubledger;

public interface AccountChartSubLedger extends CrudRepository<AccountSubledger, Integer> {
	 @Query("SELECT a from accountsubledger a WHERE Ledgercode LIKE %:code%")
	    public List<AccountSubledger> serachByCode(@Param(value = "code") String code);
		
}
