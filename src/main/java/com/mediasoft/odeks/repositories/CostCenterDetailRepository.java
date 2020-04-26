package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mediasoft.odeks.model.CostCenterDetails;
public interface CostCenterDetailRepository extends CrudRepository<CostCenterDetails, Integer> {
	 @Query("SELECT c from costcenterdetails c WHERE c.costCenterCode LIKE %:code%")
	 public List<CostCenterDetails> serachByCode(@Param(value = "code") String code);
}
