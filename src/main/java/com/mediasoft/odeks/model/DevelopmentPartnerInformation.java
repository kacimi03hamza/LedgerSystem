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
@Entity(name = "developmentpartnerinformation")
public class DevelopmentPartnerInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String devPartnerCode;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "devParternInfo")
	@JsonBackReference
	private List<JournalDetail> journalDetail;
	
	
	public DevelopmentPartnerInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevPartnerCode() {
		return devPartnerCode;
	}
	public void setDevPartnerCode(String devPartnerCode) {
		this.devPartnerCode = devPartnerCode;
	}
	public List<JournalDetail> getJournalDetail() {
		return journalDetail;
	}
	public void setJournalDetail(List<JournalDetail> journalDetail) {
		this.journalDetail = journalDetail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DevelopmentPartnerInformation(Integer id, String devPartnerCode, List<JournalDetail> journalDetail) {
		super();
		this.id = id;
		this.devPartnerCode = devPartnerCode;
		this.journalDetail = journalDetail;
	}
	
	
}
