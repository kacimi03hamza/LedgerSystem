package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mediasoft.odeks.model.Employe;
public interface EmployeRepository extends CrudRepository<Employe, Integer> {
	 @Query("SELECT e from employe e WHERE e.code LIKE %:code%")
	 public List<Employe> serachByCode(@Param(value = "code") String code);
}
