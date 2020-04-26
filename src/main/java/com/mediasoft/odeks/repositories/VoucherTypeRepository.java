package com.mediasoft.odeks.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.VoucherType;
public interface VoucherTypeRepository extends CrudRepository<VoucherType, Integer> {
	 @Query("SELECT v from vouchertype v WHERE libelle LIKE %:libelle%")
	public VoucherType findOneByLibelle(@Param(value = "libelle") String libelle);

}
