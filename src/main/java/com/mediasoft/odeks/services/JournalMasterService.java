package com.mediasoft.odeks.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
import com.mediasoft.odeks.repositories.ChartAccountRepository;
import com.mediasoft.odeks.repositories.ContractorRepository;
import com.mediasoft.odeks.repositories.CostCenterDetailRepository;
import com.mediasoft.odeks.repositories.EmployeRepository;
import com.mediasoft.odeks.repositories.JournalMasterRepository;
import com.mediasoft.odeks.repositories.ProjectIdentifierRepository;
import com.mediasoft.odeks.repositories.SupplierRepository;
import com.mediasoft.odeks.repositories.UserRepository;
import com.mediasoft.odeks.repositories.VoucherTypeRepository;
import com.mediasoft.odeks.repositories.AccountChartSubLedger;
import com.mediasoft.odeks.repositories.AgrementRepository;
import com.mediasoft.odeks.repositories.PartnerRepository;
@Service
@Transactional
public class JournalMasterService {
	@Autowired
    private VoucherTypeRepository voucherRepository;
	@Autowired
	private ChartAccountRepository chartAccountRepository;
	@Autowired
	private AccountChartSubLedger chartAccountSubLedger;
	@Autowired
	private CostCenterDetailRepository  costCenterDetailRepository;
	@Autowired
	private ProjectIdentifierRepository    projectIdentifierRepository;
	@Autowired
	private PartnerRepository partnerRepository;
	@Autowired
	private AgrementRepository   agrementRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ContractorRepository contractorRepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private JournalMasterRepository journalMasterRepository;
	@PreAuthorize("hasPermission(#journalMaster, 'edit')")
	public boolean EditJournalMaster(JournalMaster journalMaster,String voucherTypeS) {
		 Date start=new Date();
		 List<JournalDetail> details=new ArrayList<JournalDetail>();
		 VoucherType voucherType=this.voucherRepository.findOneByLibelle(voucherTypeS);
		 journalMaster.setType(voucherType);
		 for(int i=0;i<journalMaster.getJournalDetail().size();i++) {
			 JournalDetail detail=new JournalDetail();
		 AccountChart accountChart= this.chartAccountRepository.serachByCode(journalMaster.getJournalDetail().get(i).getAccountChart().getLedgercode()).get(0);
		 detail.setAccountChart(accountChart);
		 AccountSubledger accountSubLeadger=this.chartAccountSubLedger.serachByCode(journalMaster.getJournalDetail().get(i).getAccountSubLedger().getLedgerCode()).get(0);
		 detail.setAccountSubLedger(accountSubLeadger);
		 CostCenterDetails costCenter=this.costCenterDetailRepository.serachByCode(journalMaster.getJournalDetail().get(i).getCostCenterDetail().getCostCenterCode()).get(0);
		 detail.setCostCenterDetail(costCenter);
		 ProjectIdentifier projectIdentifier=this.projectIdentifierRepository.getByCode(journalMaster.getJournalDetail().get(i).getProjectIdentifeir().getProjectCode()).get(0);
		 detail.setProjectIdentifeir(projectIdentifier);
		 DevelopmentPartnerInformation partner=this.partnerRepository.serachByCode(journalMaster.getJournalDetail().get(i).getDevParternInfo().getDevPartnerCode()).get(0);
		 detail.setDevParternInfo(partner);
		 AgreementInformation agrementRepository=this.agrementRepository.serachByCode(journalMaster.getJournalDetail().get(i).getAgreementInfo().getAgreementCode()).get(0);
		 detail.setAgreementInfo(agrementRepository);
		 Employe employe=this.employeRepository.serachByCode(journalMaster.getJournalDetail().get(i).getEmploye().getCode()).get(0);
		 detail.setEmploye(employe);
		 Supplier supplier=this.supplierRepository.serachByCode(journalMaster.getJournalDetail().get(i).getSupplier().getCode()).get(0);
		 detail.setSupplier(supplier);
		 Contractor contractor=this.contractorRepository.serachByCode(journalMaster.getJournalDetail().get(i).getContractor().getCode()).get(0);
		 detail.setContractor(contractor);
		 detail.setJournalMaster(journalMaster);
		 detail.setCreditAmount(journalMaster.getJournalDetail().get(i).getCreditAmount());
		 detail.setDebitAmount(journalMaster.getJournalDetail().get(i).getDebitAmount());
		 details.add(detail);
		 }
		 System.out.println(journalMaster.getTemporaryNumber());
		 String identifiant=SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		 System.out.println(identifiant);
		 Optional<User> user=this.userrepository.findOneByName(identifiant);
		 journalMaster.setUser(user.get());
		 journalMaster.setJournalDetail(null);
		 journalMaster.setJournalDetail(details);
		 this.journalMasterRepository.save(journalMaster);
		 return true;
	}
}
