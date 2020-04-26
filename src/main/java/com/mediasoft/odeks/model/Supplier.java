package com.mediasoft.odeks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.mediasoft.odeks.model.JournalDetail;
@Entity(name="supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column
private String code;
@JsonBackReference
@OneToMany(mappedBy ="supplier")
private List<JournalDetail> details;

public Supplier() {
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
public List<JournalDetail> getDetails() {
	return details;
}
public void setDetails(List<JournalDetail> details) {
	this.details = details;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Supplier [id=");
	builder.append(id);
	builder.append(", code=");
	builder.append(code);
	builder.append(", details=");
	builder.append(details);
	builder.append("]");
	return builder.toString();
}


}
