package com.ptps.microservices.paymentSettlementService.resource;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(description="All details about the Tax Payment Order")
public class TaxPaymentOrder {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "loan_number")
	private long loanNumber;

	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "agency")
	private String agency;
	
	@Column(name = "amount_to_be_paid")
	private Double amountToBePaid;
	
	@Column(name = "total_amount_paid")
	private Double totalAmountPaid;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "submitted_date")
	private Date submittedDate;
	
	@Column(name = "decision")
	private boolean decision;
	
	
	public TaxPaymentOrder() {
	}

	public TaxPaymentOrder(Long id, long loanNumber, String customerName, String agency, Double amountToBePaid,
			Double totalAmountPaid, Date dueDate, Date submittedDate, boolean decision,
			String exchangeEnvironmentInfo) {
		super();
		this.id = id;
		this.loanNumber = loanNumber;
		this.customerName = customerName;
		this.agency = agency;
		this.amountToBePaid = amountToBePaid;
		this.totalAmountPaid = totalAmountPaid;
		this.dueDate = dueDate;
		this.submittedDate = submittedDate;
		this.decision = decision;
		
	}
	
	

	public TaxPaymentOrder(long loanNumber, String customerName, String agency, Double amountToBePaid, Date dueDate) {
		super();
		this.loanNumber = loanNumber;
		this.customerName = customerName;
		this.agency = agency;
		this.amountToBePaid = amountToBePaid;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(long loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(Double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	public Double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	@Override
	public String toString() {
		return "TaxPaymentOrder [id=" + id + ", loanNumber=" + loanNumber + ", customerName=" + customerName
				+ ", agency=" + agency + ", amountToBePaid=" + amountToBePaid + ", TotalAmountPaid=" + totalAmountPaid
				+ ", dueDate=" + dueDate + ", submittedDate=" + submittedDate + ", decision=" + decision + "]";
	}

	

	
	
}
