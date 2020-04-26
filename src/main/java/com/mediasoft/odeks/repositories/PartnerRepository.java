package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.DevelopmentPartnerInformation;
public interface PartnerRepository extends CrudRepository<DevelopmentPartnerInformation, Integer> {
	 @Query("SELECT p from developmentpartnerinformation p WHERE p.devPartnerCode LIKE %:code%")
	 public List<DevelopmentPartnerInformation> serachByCode(@Param(value = "code") String code);
}
