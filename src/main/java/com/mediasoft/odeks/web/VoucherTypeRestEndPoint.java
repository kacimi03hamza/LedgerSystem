package com.mediasoft.odeks.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediasoft.odeks.repositories.VoucherTypeRepository;
import com.mediasoft.odeks.model.VoucherType;
@RestController
public class VoucherTypeRestEndPoint {

	@Autowired
	private VoucherTypeRepository voucherTypeRepository;
	@PostMapping("/VoucherType/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<VoucherType> findAllVoucher(){
		return (List<VoucherType>) this.voucherTypeRepository.findAll();
	}
}
