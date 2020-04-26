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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
@Entity(name = "agreementinformation")
public class AgreementInformation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String agreementCode;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agreementInfo")
	@JsonBackReference
	private List<JournalDetail> journalDetail;
	
	
	public AgreementInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAgreementCode() {
		return agreementCode;
	}
	public void setAgreementCode(String agreementCode) {
		this.agreementCode = agreementCode;
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
		builder.append("AgreementInformation [id=");
		builder.append(id);
		builder.append(", agreementCode=");
		builder.append(agreementCode);
		builder.append(", journalDetail=");
		builder.append(journalDetail);
		builder.append("]");
		return builder.toString();
	}
	
	
}
