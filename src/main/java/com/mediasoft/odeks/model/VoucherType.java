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

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
@Entity(name = "vouchertype")
public class VoucherType implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 100)
	private String libelle;
	private String Numero;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	@JsonIgnore
	private List<JournalMaster> journalMaster;
	
	
	
	  	public VoucherType() {
		super();
		// TODO Auto-generated constructor stub
	}

		public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public List<JournalMaster> getJournalMaster() {
		return journalMaster;
	}

	public void setJournalMaster(List<JournalMaster> journalMaster) {
		this.journalMaster = journalMaster;
	}

	public VoucherType(Integer id, String libelle, String numero, List<JournalMaster> journalMaster) {
		super();
		this.id = id;
		this.libelle = libelle;
		Numero = numero;
		this.journalMaster = journalMaster;
	}

	

}
