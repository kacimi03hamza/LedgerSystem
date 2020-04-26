package com.mediasoft.odeks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity(name = "employe")
public class Employe {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String code;

	@OneToMany(mappedBy = "employe")
	@JsonBackReference
	private List<JournalDetail> journalDetails;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<JournalDetail> getJournalDetails() {
		return journalDetails;
	}

	public void setJournalDetails(List<JournalDetail> journalDetails) {
		this.journalDetails = journalDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employe [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", journalDetails=");
		builder.append(journalDetails);
		builder.append("]");
		return builder.toString();
	}

}
