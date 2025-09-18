package com.yogesh.customer;

import java.util.Random;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.yogesh.entities.Customer;
import com.yogesh.util.singletondesignpattern.SingletonDesignPattern;

import jakarta.validation.ConstraintViolationException;

public class CustomerFunctionality {
		
	private Scanner scanner ;
	private CustomerAccount customerAccount;
	
	public void customerLogin() {
		
		customerAccount = new CustomerAccount();
		scanner = SingletonDesignPattern.buildScannerInstance();
		
		System.out.println("Enter Username");
		String username = scanner.next();
		
		System.out.println("Enter Password");
		String password = scanner.next();
		
		Customer cutomer = customerAccount.usernameExists(username);
		
		try {
			
			boolean flag = BCrypt.checkpw(password, cutomer.getCustomerPassword());
			if(flag) {
				System.out.println("Login Successfull");
			}else {
				System.out.println("Password Not Matched ... !!!");
			}
			
		}catch (NullPointerException e) {
			System.out.println("Username Not Found ... !!!");
		}	
	}
	
	public void forgotPassword() {
		
		customerAccount = new CustomerAccount();
		scanner = SingletonDesignPattern.buildScannerInstance();
		
		System.out.println("Enter mobile no");
		String mobileNo = scanner.next();
		
		Customer customer = customerAccount.customerExistsWithMobile(mobileNo);
		
		try {
			
			boolean flag ;
				
			 System.out.println("Confirm :" + customer.toString());
			
			 Random random = new Random();
		     int generateOTP = 100000 + random.nextInt(900000);
		     System.out.println("Your OTP is :" + generateOTP);
		     
		     System.out.println("Enter Your OTP :");
		     int otpConfirmation = scanner.nextInt();
		     
		     if(generateOTP == otpConfirmation) {
		    	 
		    	 System.out.println("Login Successfully ... !!!");
		    	 System.out.println("Reset Your Password");
		    	 String resetPassword = scanner.next();
		    	 
		    	 customer.setCustomerPassword(resetPassword);
		    	 
		    	
		    	if( flag =  SingletonDesignPattern.validationCheck(customer)) {
		    		System.out.println("Password Reset Successfully ... !!!");
		    	}		 
		    			 
		     }else {
		    	 System.out.println("OTP not matched ... !!!");
		     }
		     
			
		}catch (NullPointerException e) {
			System.out.println("Username Not Available with this mobile Number ... !!!");
		}catch (ConstraintViolationException e) {
			System.out.println("Please Enter Valid Password ... !!!");
		}
		
	}
	
	public static void main(String[] args) {
		CustomerFunctionality customerFunctionality = new CustomerFunctionality();
		customerFunctionality.customerLogin();
		customerFunctionality.forgotPassword();
	}
}
