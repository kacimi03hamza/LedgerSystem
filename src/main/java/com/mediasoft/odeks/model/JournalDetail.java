package com.mediasoft.odeks.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.mediasoft.odeks.model.Supplier;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class JournalDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_chart_id")
	@JsonManagedReference
	private AccountChart accountChart;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Double debitAmount;
	@Column
	private Double creditAmount;
	@Column
	private Date bankClearDate;
	@Column(length = 400)
	private String reference;
	@Column(length = 30)
	private String chequeNumber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_id")
	@JsonManagedReference
	private JournalMaster journalMaster;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_subledger_id")
	@JsonManagedReference
	private AccountSubledger accountSubLedger;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "costCenter_id")
	@JsonManagedReference
	private CostCenterDetails costCenterDetail;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	@JsonManagedReference
	private ProjectIdentifier projectIdentifeir;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "partner_id")
	@JsonManagedReference
	private DevelopmentPartnerInformation devParternInfo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agrement_id")
	@JsonManagedReference
	private AgreementInformation agreementInfo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employe_id")
	@JsonManagedReference
	private Employe employe;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id")
	@JsonManagedReference
	private Supplier supplier;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contractor_id")
	@JsonManagedReference
	private Contractor contractor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Date getBankClearDate() {
		return bankClearDate;
	}
	public void setBankClearDate(Date bankClearDate) {
		this.bankClearDate = bankClearDate;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public JournalMaster getJournalMaster() {
		return journalMaster;
	}
	public void setJournalMaster(JournalMaster journalMaster) {
		this.journalMaster = journalMaster;
	}
	public AccountChart getAccountChart() {
		return accountChart;
	}
	public void setAccountChart(AccountChart accountChart) {
		this.accountChart = accountChart;
	}
	public AccountSubledger getAccountSubLedger() {
		return accountSubLedger;
	}
	public void setAccountSubLedger(AccountSubledger accountSubLedger) {
		this.accountSubLedger = accountSubLedger;
	}
	public CostCenterDetails getCostCenterDetail() {
		return costCenterDetail;
	}
	public void setCostCenterDetail(CostCenterDetails costCenterDetail) {
		this.costCenterDetail = costCenterDetail;
	}
	public ProjectIdentifier getProjectIdentifeir() {
		return projectIdentifeir;
	}
	public void setProjectIdentifeir(ProjectIdentifier projectIdentifeir) {
		this.projectIdentifeir = projectIdentifeir;
	}
	public DevelopmentPartnerInformation getDevParternInfo() {
		return devParternInfo;
	}
	public void setDevParternInfo(DevelopmentPartnerInformation devParternInfo) {
		this.devParternInfo = devParternInfo;
	}
	public AgreementInformation getAgreementInfo() {
		return agreementInfo;
	}
	public void setAgreementInfo(AgreementInformation agreementInfo) {
		this.agreementInfo = agreementInfo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JournalDetail [id=");
		builder.append(id);
		builder.append(", debitAmount=");
		builder.append(debitAmount);
		builder.append(", creditAmount=");
		builder.append(creditAmount);
		builder.append(", bankClearDate=");
		builder.append(bankClearDate);
		builder.append(", reference=");
		builder.append(reference);
		builder.append(", chequeNumber=");
		builder.append(chequeNumber);
		builder.append(", journalMaster=");
		builder.append(journalMaster);
		builder.append(", accountChart=");
		builder.append(accountChart);
		builder.append(", accountSubLedger=");
		builder.append(accountSubLedger);
		builder.append(", costCenterDetail=");
		builder.append(costCenterDetail);
		builder.append(", projectIdentifeir=");
		builder.append(projectIdentifeir);
		builder.append(", devParternInfo=");
		builder.append(devParternInfo);
		builder.append(", agreementInfo=");
		builder.append(agreementInfo);
		builder.append(", employe=");
		builder.append(employe);
		builder.append(", supplier=");
		builder.append(supplier);
		builder.append(", contractor=");
		builder.append(contractor);
		builder.append("]");
		return builder.toString();
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Contractor getContractor() {
		return contractor;
	}
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
	
	
	
}
