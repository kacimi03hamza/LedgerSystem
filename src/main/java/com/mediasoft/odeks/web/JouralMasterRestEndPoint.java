package com.mediasoft.odeks.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediasoft.odeks.model.AccountChart;
import com.mediasoft.odeks.model.AccountSubledger;
import com.mediasoft.odeks.model.AgreementInformation;
import com.mediasoft.odeks.model.Contractor;
import com.mediasoft.odeks.model.CostCenterDetails;
import com.mediasoft.odeks.model.DevelopmentPartnerInformation;
import com.mediasoft.odeks.model.Employe;
import com.mediasoft.odeks.model.JournalDetail;
import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.ProjectIdentifier;
import com.mediasoft.odeks.model.Supplier;
import com.mediasoft.odeks.model.User;
import com.mediasoft.odeks.model.VoucherType;
import com.mediasoft.odeks.repositories.JournalDetailsRepository;
import com.mediasoft.odeks.repositories.JournalMasterRepository;
import com.mediasoft.odeks.repositories.VoucherTypeRepository;
import com.mediasoft.odeks.services.JournalMasterService;
import com.mediasoft.odeks.repositories.ChartAccountRepository;
import com.mediasoft.odeks.repositories.AccountChartSubLedger;
import com.mediasoft.odeks.repositories.CostCenterDetailRepository;
import com.mediasoft.odeks.repositories.ProjectIdentifierRepository;
import com.mediasoft.odeks.repositories.PartnerRepository;
import com.mediasoft.odeks.repositories.AgrementRepository;
import com.mediasoft.odeks.repositories.EmployeRepository;
import com.mediasoft.odeks.repositories.SupplierRepository;
import com.mediasoft.odeks.repositories.ContractorRepository;
import com.mediasoft.odeks.repositories.JournalMasterRepository;
import com.mediasoft.odeks.repositories.UserRepository;
@RestController
public class JouralMasterRestEndPoint {

	@Autowired
	private VoucherTypeRepository voucherRepository;
	@Autowired
	private ChartAccountRepository chartAccountRepository;
	@Autowired
	private AccountChartSubLedger chartAccountSubLedger;
	@Autowired
	private CostCenterDetailRepository costCenterDetailRepository;
	@Autowired
	private ProjectIdentifierRepository projectIdentifierRepository;
	@Autowired
	private PartnerRepository partnerRepository;
	@Autowired
	private AgrementRepository agrementRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ContractorRepository contractorRepository;
	@Autowired
	private JournalMasterRepository journalMasterRepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private JournalMasterService journalMasterService;
	
	@PostMapping(value = "/JournalMaster/Save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public String saveMaster(@RequestParam(value = "voucherType") String voucherTypeS,@RequestBody(required = true)  JournalMaster journalMaster) throws JsonProcessingException {
		
		Date start=new Date();
		 VoucherType voucherType=this.voucherRepository.findOneByLibelle(voucherTypeS);
		 journalMaster.setType(voucherType);
		 for(int i=0;i<journalMaster.getJournalDetail().size();i++) {
		 AccountChart accountChart= this.chartAccountRepository.serachByCode(journalMaster.getJournalDetail().get(i).getAccountChart().getLedgercode()).get(0);
		 journalMaster.getJournalDetail().get(i).setAccountChart(accountChart);
		 AccountSubledger accountSubLeadger=this.chartAccountSubLedger.serachByCode(journalMaster.getJournalDetail().get(i).getAccountSubLedger().getLedgerCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setAccountSubLedger(accountSubLeadger);
		 CostCenterDetails costCenter=this.costCenterDetailRepository.serachByCode(journalMaster.getJournalDetail().get(i).getCostCenterDetail().getCostCenterCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setCostCenterDetail(costCenter);
		 ProjectIdentifier projectIdentifier=this.projectIdentifierRepository.getByCode(journalMaster.getJournalDetail().get(i).getProjectIdentifeir().getProjectCode()).get(0);
		
		 journalMaster.getJournalDetail().get(i).setProjectIdentifeir(projectIdentifier);
		 DevelopmentPartnerInformation partner=this.partnerRepository.serachByCode(journalMaster.getJournalDetail().get(i).getDevParternInfo().getDevPartnerCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setDevParternInfo(partner);
		 AgreementInformation agrementRepository=this.agrementRepository.serachByCode(journalMaster.getJournalDetail().get(i).getAgreementInfo().getAgreementCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setAgreementInfo(agrementRepository);
		 Employe employe=this.employeRepository.serachByCode(journalMaster.getJournalDetail().get(i).getEmploye().getCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setEmploye(employe);
		 Supplier supplier=this.supplierRepository.serachByCode(journalMaster.getJournalDetail().get(i).getSupplier().getCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setSupplier(supplier);
		 Contractor contractor=this.contractorRepository.serachByCode(journalMaster.getJournalDetail().get(i).getContractor().getCode()).get(0);
		 journalMaster.getJournalDetail().get(i).setContractor(contractor);
		 journalMaster.getJournalDetail().get(i).setJournalMaster(journalMaster);
		
		 }
		 Optional<User> user=this.userrepository.findById(2);
		 journalMaster.setUser(user.get());
		 Date entryDate=new Date();
		 SimpleDateFormat simpleDateF=new SimpleDateFormat("MM/YYYY");
		 String dateS=simpleDateF.format(entryDate);
		 System.out.println(dateS);
		 System.out.println("TEAM"+"/"+dateS);
		 JournalMaster retour=this.journalMasterRepository.save(journalMaster);
		 String ids=retour.getId().toString();
		 if(ids.length()<4) {
			 int loopBorn=4-ids.length();
			 for(int i=0;i<loopBorn;i++) {
				 ids="0"+ids;
			 }
		 }
		 
		 journalMaster.setTemporaryNumber("TEAM"+"/"+dateS+"/"+ids);
		 this.journalMasterRepository.save(journalMaster);
		 Date end=new Date();
		 System.out.println(end);
		 ObjectMapper mapper = new ObjectMapper();
		String sortie= mapper.writeValueAsString(journalMaster.getTemporaryNumber());
		return sortie;
	}
	@PostMapping(value = "/JournalMaster/selectforUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<JournalMaster>> selectForUser(@RequestBody(required = true) User user) {
		List<JournalMaster> sortie = null;
		
		  sortie=(List<JournalMaster>) this.journalMasterRepository.findAll();
		  return new ResponseEntity<List<JournalMaster>>(sortie, HttpStatus.OK);
		  
	}	
	@PostMapping(value = "/JournalMaster/findOne",consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<JournalMaster> findOneById(@RequestParam(required = true,name = "id") Integer id) {
		  Optional<JournalMaster> sortie = null;
		  sortie=this.journalMasterRepository.findById(id);
		  return new ResponseEntity<JournalMaster>(sortie.get(), HttpStatus.OK);
		  
	}	
	@PostMapping(value = "/JournalMaster/edit",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean editMaster(@RequestParam(value = "voucherType") String voucherTypeS,@RequestBody(required = true)  JournalMaster journalMaster) throws JsonProcessingException {
		System.out.println(journalMaster.getTemporaryNumber()+"here");
		return this.journalMasterService.EditJournalMaster(journalMaster, voucherTypeS);
	}
	public JournalMasterService getJournalMasterService() {
		return journalMasterService;
	}
	public void setJournalMasterService(JournalMasterService journalMasterService) {
		this.journalMasterService = journalMasterService;
	}
	
}
