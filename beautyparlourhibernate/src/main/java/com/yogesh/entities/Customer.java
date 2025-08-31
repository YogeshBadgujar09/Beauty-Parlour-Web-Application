package com.yogesh.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId ;
	
	@NotNull
	@Pattern(regexp ="^[A-Za-z ]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerName ;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{10}$" , message = "Enter valid mobile name [enter 10 Digits]")
	private String customerMobileNo ;
	
	@NotNull
	@Email(message = "enter valid email")
	private String customerEmail ;
	
	@NotNull
	@Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19|20)\\d{2}$", message = "Date must be in format dd-MM-yyyy"	)
	private Date customerDOB ;
	
	@NotNull
	@Pattern(regexp ="^[A-Za-z0-9 ]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerAddress ;
	
	@NotNull
	@Pattern(regexp ="^[A-Za-z0-9]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerCity ;
	
	@NotNull
	@Pattern(regexp ="^[A-Za-z0-9 ]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerState ;
	
	
	@Column(unique = true)
	@Pattern(regexp ="^[A-Za-z0-9-@#$%^*+/]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerUsername ;
	
	@NotNull
	@Pattern(regexp ="^[A-Za-z0-9-@#$%^*+/]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String customerPassword ;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNo="
				+ customerMobileNo + ", customerEmail=" + customerEmail + ", customerDOB=" + customerDOB
				+ ", customerAddress=" + customerAddress + ", customerCity=" + customerCity + ", customerState="
				+ customerState + ", customerUsername=" + customerUsername + ", customerPassword=" + customerPassword
				+ "]";
	}
	
}
