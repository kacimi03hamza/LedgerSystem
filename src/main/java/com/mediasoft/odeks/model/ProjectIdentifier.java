package com.mediasoft.odeks.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Entity(name = "projectidentifier")
public class ProjectIdentifier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String projectCode;
	@OneToMany(mappedBy ="projectIdentifeir")
	private List<JournalDetail> details;
	@JsonBackReference
	private JournalDetail journalDetail;
	
	
	
	public ProjectIdentifier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public JournalDetail getJournalDetail() {
		return journalDetail;
	}
	public void setJournalDetail(JournalDetail journalDetail) {
		this.journalDetail = journalDetail;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectIdentifier [id=");
		builder.append(id);
		builder.append(", projectCode=");
		builder.append(projectCode);
		builder.append(", journalDetail=");
		builder.append(journalDetail);
		builder.append("]");
		return builder.toString();
	}
	
}
