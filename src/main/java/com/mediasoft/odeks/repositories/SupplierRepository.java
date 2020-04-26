package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mediasoft.odeks.model.Supplier;
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
	 @Query("SELECT s from supplier s WHERE s.code LIKE %:code%")
	 public List<Supplier> serachByCode(@Param(value = "code") String code);
}
