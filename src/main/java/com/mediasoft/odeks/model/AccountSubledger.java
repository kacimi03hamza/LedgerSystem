package com.mediasoft.odeks.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity(name = "accountsubledger")
public class AccountSubledger implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String ledgerCode;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountSubLedger")
	@JsonBackReference
	private List<JournalDetail> journalDetail;
	
	
	public AccountSubledger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLedgerCode() {
		return ledgerCode;
	}
	public void setLedgerCode(String ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public List<JournalDetail> getJournalDetail() {
		return journalDetail;
	}
	public void setJournalDetail(List<JournalDetail> journalDetail) {
		this.journalDetail = journalDetail;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSubledger [id=");
		builder.append(id);
		builder.append(", ledgerCode=");
		builder.append(ledgerCode);
		builder.append(", journalDetail=");
		builder.append(journalDetail);
		builder.append("]");
		return builder.toString();
	}
	
	
}
