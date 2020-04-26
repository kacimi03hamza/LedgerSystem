package com.mediasoft.odeks.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity(name = "users")
public class User implements Serializable{
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column()
	private String code;
	@Column()
	private String identifiant;
	@Column
	private String name;
	@Column
	private String password;
	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private List<JournalMaster> journalMasters;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
     joinColumns = @JoinColumn(name = "user_id"),
     inverseJoinColumns = @JoinColumn(name = "role_id")
 )
	@JsonIgnore
	private List<Role> roles; 
	
	public User() {
		super();
		this.roles=new ArrayList<Role>();
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
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public List<JournalMaster> getJournalMasters() {
		return journalMasters;
	}
	public void setJournalMasters(List<JournalMaster> journalMasters) {
		this.journalMasters = journalMasters;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", identifiant=");
		builder.append(identifiant);
		builder.append(", journalMasters=");
		builder.append(journalMasters);
		builder.append("]");
		return builder.toString();
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		return this.id*31;
	}
	@Override
	public boolean equals(Object obj) {
		User anotherUser=(User)obj;
		return this.name.equals(anotherUser.getIdentifiant());
	}
		
	

}
