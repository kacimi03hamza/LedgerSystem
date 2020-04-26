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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity(name = "accountchart")
public class AccountChart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	@JsonProperty(value = "Ledgercode",required = true)
	private String Ledgercode;
	@OneToMany( mappedBy = "accountChart")
	@JsonBackReference
	private List<JournalDetail> journalDetail;
	
	
	public AccountChart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLedgercode() {
		return Ledgercode;
	}
	public void setLedgercode(String ledgercode) {
		Ledgercode = ledgercode;
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
		builder.append("AccountChart [id=");
		builder.append(id);
		builder.append(", Ledgercode=");
		builder.append(Ledgercode);
		builder.append(", journalDetail=");
		builder.append(journalDetail);
		builder.append("]");
		return builder.toString();
	}
	

}
