package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.Contractor;
import com.mediasoft.odeks.model.CostCenterDetails;

public interface ContractorRepository extends CrudRepository<Contractor, Integer> {
	@Query("SELECT c from contractor c WHERE c.code LIKE %:code%")
	public List<Contractor> serachByCode(@Param(value = "code") String code);
}
