package com.mediasoft.odeks.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import CustomDesrializer.JournalMasterDeserializer;

@Entity(name = "journalmaster")
@JsonDeserialize(using = JournalMasterDeserializer.class)
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,  property = "id")
public class JournalMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Integer id;
	@Column(length = 30, unique = true)
	@JsonProperty("journalNumber")
	private String journalNumber;
	@Column(length = 30)
	@JsonProperty("temporaryNumber")
	private String temporaryNumber;
	@Column(nullable = false)
	@JsonProperty(value="journalDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date journalDate=new Date();
	@JsonProperty(value = "financialYear")
	@Column(length = 9, nullable = false)
	private String financialYear;
	@Column(length = 4, nullable = true)
	@JsonProperty("journalSource")
	private String journalSource;
	@Column(length = 1000)
	@JsonProperty("narration")
	private String narration;
	@JsonProperty("entryDateTime")
	@Column(nullable = false)
	private String entryDateTime=new Date().toString();
	@Column(length = 30)
	@Check(constraints = "journalStatus='NOT_SUBMIT' or journalStatus='SUBMIT' or journalStatus='CHECKED' or journalStatus='APPROVED'")
	@JsonProperty("journalStatus")
	private String journalStatus;
	@Column()
	@JsonProperty("submitDateTime")
	private Date submitDateTime;
	@Column(length = 1)
	@JsonProperty("isApproved")
	private String isApproved;
	@Column()
	@JsonProperty("approvedDate")
	private Date approvedDate;
	@Column(length = 30)
	private String approvedby;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonProperty("voucherType")
	@JsonIgnore
	private VoucherType type;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "journalMaster",fetch = FetchType.EAGER,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference
	private List<JournalDetail> journalDetail;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	@JsonManagedReference
	private User user;

	public JournalMaster() {
		super();
		this.journalDetail=new ArrayList<JournalDetail>();
		
		// TODO Auto-generated constructor stub
	}

	public JournalMaster(Integer id, String journalNumber, String temporaryNumber, Date journalDate,
			String financialYear, String journalSource, String narration, String entryDateTime, String journalStatus,
			Date submitDateTime, String isApproved, Date approvedDate, String approvedby, VoucherType type,
			List<JournalDetail> journalDetail, User user) {
		super();
		this.id = id;
		this.journalNumber = journalNumber;
		this.temporaryNumber = temporaryNumber;
		this.journalDate = journalDate;
		this.financialYear = financialYear;
		this.journalSource = journalSource;
		this.narration = narration;
		this.entryDateTime = entryDateTime;
		this.journalStatus = journalStatus;
		this.submitDateTime = submitDateTime;
		this.isApproved = isApproved;
		this.approvedDate = approvedDate;
		this.approvedby = approvedby;
		this.type = type;
		this.journalDetail = journalDetail;
		this.user = user;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJournalNumber() {
		return journalNumber;
	}

	public void setJournalNumber(String journalNumber) {
		this.journalNumber = journalNumber;
	}

	public String getTemporaryNumber() {
		return temporaryNumber;
	}

	public void setTemporaryNumber(String temporaryNumber) {
		this.temporaryNumber = temporaryNumber;
	}

	public Date getJournalDate() {
		return journalDate;
	}

	public void setJournalDate(Date journalDate) {
		this.journalDate = journalDate;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getJournalSource() {
		return this.journalSource;
	}

	public void setJournalSource(String journalSource) {
		this.journalSource = journalSource;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(String entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public String getJournalStatus() {
		return journalStatus;
	}

	public void setJournalStatus(String journalStatus) {
		this.journalStatus = journalStatus;
	}

	public Date getSubmitDateTime() {
		return submitDateTime;
	}

	public void setSubmitDateTime(Date submitDateTime) {
		this.submitDateTime = submitDateTime;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public VoucherType getType() {
		return type;
	}

	public void setType(VoucherType type) {
		this.type = type;
	}

	

	public List<JournalDetail> getJournalDetail() {
		return journalDetail;
	}

	public void setJournalDetail(List<JournalDetail> journalDetail) {
		this.journalDetail = journalDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JournalMaster [id=");
		builder.append(id);
		builder.append(", journalNumber=");
		builder.append(journalNumber);
		builder.append(", temporaryNumber=");
		builder.append(temporaryNumber);
		builder.append(", journalDate=");
		builder.append(journalDate);
		builder.append(", financialYear=");
		builder.append(financialYear);
		builder.append(", journalSource=");
		builder.append(journalSource);
		builder.append(", narration=");
		builder.append(narration);
		builder.append(", entryDateTime=");
		builder.append(entryDateTime);
		builder.append(", journalStatus=");
		builder.append(journalStatus);
		builder.append(", submitDateTime=");
		builder.append(submitDateTime);
		builder.append(", isApproved=");
		builder.append(isApproved);
		builder.append(", approvedDate=");
		builder.append(approvedDate);
		builder.append(", approvedby=");
		builder.append(approvedby);
		builder.append(", type=");
		builder.append(type);
		builder.append(", journalDetail=");
		for(int i=0;i<this.journalDetail.size();i++) {
			builder.append("[");
		builder.append(journalDetail.get(i).toString());
		builder.append("]");
		}
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
    
	

}
