package com.yogesh.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.yogesh.entities.Customer;
import com.yogesh.util.singletondesignpattern.SingletonDesignPattern;

public class CustomerInformationOptimize {
	
	private Scanner scanner;
	private DateTimeFormatter formatter;
	
	public Customer insertCustomerInformation(Customer customer) {
		
		scanner = SingletonDesignPattern.buildScannerInstance();
		
		System.out.println("Enter Full Name :");
		customer.setCustomerName(scanner.nextLine());
		
		System.out.println("Enter Mobile No. :");
		customer.setCustomerMobileNo(scanner.next());		
		
		System.out.println("Enter Email Id :");
		customer.setCustomerEmail(scanner.next());
		
		System.out.println("Enter DOB :");
		String dateString = scanner.next();
		
		try {
			formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate localDate =  LocalDate.parse(dateString, formatter);
			customer.setCustomerDOB(localDate);
		}catch (DateTimeParseException e) {
			// TODO: handle exception
		}
		
		scanner.nextLine();
		System.out.println("Enter Address :");
		customer.setCustomerAddress(scanner.nextLine());
		
		System.out.println("Enter City :");
		customer.setCustomerCity(scanner.nextLine());

		System.out.println("Enter State :");
		customer.setCustomerState(scanner.nextLine());
		
		return customer;
	}
	
	
}
