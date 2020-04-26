package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mediasoft.odeks.model.AgreementInformation;
public interface AgrementRepository extends CrudRepository<AgreementInformation, Integer> {
	 @Query("SELECT a from agreementinformation a WHERE agreementCode LIKE %:code%")
	    public List<AgreementInformation> serachByCode(@Param(value = "code") String code);
}
