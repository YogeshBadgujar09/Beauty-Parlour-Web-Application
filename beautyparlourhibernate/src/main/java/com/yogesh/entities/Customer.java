package com.yogesh.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp ="^[A-Za-z ]+$" , message = "Enter valid name [enter alphabetic value]")
	private String customerName ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp = "^[0-9]{10}$" , message = "Enter valid mobile name [enter 10 Digits]")
	private String customerMobileNo ;
	
	@NotNull
	@Column(nullable = false)
	@Email(message = "enter valid email")
	private String customerEmail ;
	
	@NotNull(message = "enter date please") 
	@Past(message = "Date of birth must be in the past")
	@Column(nullable = false)
	private LocalDate customerDOB ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp ="^[A-Za-z0-9 ,./-]+$" , message = "Enter valid address [enter valid address use only alpha-numeric]")
	private String customerAddress ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp ="^[A-Za-z ]+$" , message = "Enter valid city [enter alphabetic value]")
	private String customerCity ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp ="^[A-Za-z ]+$" , message = "Enter valid state [enter alphabetic value]")
	private String customerState ;
	
	@NotNull
	@Column(unique = true, nullable = false)
	@Pattern(regexp ="^[A-Za-z0-9-@#$%^*+/]+$" , message = "[USERNAME] Enter valid asset name [enter ALFA-NUMERIC VALUE and Use only these symbols -@#$%^*+/ ]")
	private String customerUsername ;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp ="^[A-Za-z0-9-@#$%^*+/]+$" , message = "[PASSWORD] Enter valid asset name [enter ALFA-NUMERIC VALUE and Use only these symbols -@#$%^*+/ ]")
	private String customerPassword ;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate customerCreateDate;
	
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
	
	public LocalDate getCustomerDOB() {
		return customerDOB;
	}
	
	public void setCustomerDOB(LocalDate customerDOB) {
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
	
	public LocalDate getCustomerCreateDate() {
		return customerCreateDate;
	}
	public void setCustomerCreateDate(LocalDate customerCreateDate) {
		this.customerCreateDate = customerCreateDate;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNo="
				+ customerMobileNo + ", customerEmail=" + customerEmail + ", customerDOB=" + customerDOB
				+ ", customerAddress=" + customerAddress + ", customerCity=" + customerCity + ", customerState="
				+ customerState + ", customerUsername=" + customerUsername + ", customerPassword=" + customerPassword
				+ ", customerCreateDate=" + customerCreateDate + "]";
	}	
}
