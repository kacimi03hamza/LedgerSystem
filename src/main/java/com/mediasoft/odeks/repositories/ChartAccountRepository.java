package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.AccountChart;

public interface ChartAccountRepository extends CrudRepository<AccountChart, Integer>{
	
	 @Query("SELECT a from accountchart a WHERE Ledgercode LIKE %:code%")
    public List<AccountChart> serachByCode(@Param(value = "code") String code);
	  
  
}
