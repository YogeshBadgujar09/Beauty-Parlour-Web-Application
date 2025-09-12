package com.yogesh.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.entities.Customer;
import com.yogesh.util.singletondesignpattern.SingletonDesignPattern;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CustomerAccount {
	
	public void newCustomerAccount() {
		
		Customer customer = new Customer();
		Scanner scanner = SingletonDesignPattern.buildScannerInstance();
		DateTimeFormatter formatter;

		try {
			
			Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession();
			Transaction transaction = session.beginTransaction();
			
			System.out.println(" Fill The Information \n\n");
			    		
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
			customer.setCustomerCity(scanner.next());
			
			scanner.nextLine();
			System.out.println("Enter State :");
			customer.setCustomerState(scanner.nextLine());
			
			boolean flag = false;
			do {
				
				System.out.println("Enter Username :");
				String username = scanner.next();
		
				Customer customerObject = usernameExists(username);
			
				if(customerObject != null) {
					System.out.println("Username Already Available .... Please try another Name");
				}else {
					customer.setCustomerUsername(username);
					flag = true;
				}
				
			}while(!flag);
			
			
			System.out.println("Enter Password :");
			customer.setCustomerPassword(scanner.next()); 	
		
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
			Iterator<ConstraintViolation<Customer>> iterator = violations.iterator();
			
			while (iterator.hasNext()) {
				ConstraintViolation<Customer> obj = iterator.next();
				System.out.println("Error:" + obj.getPropertyPath() + " - " + obj.getMessage());
			}
			
			session.persist(customer);
			transaction.commit();
			
			session.close();
			
		}catch (ConstraintViolationException e) {
				System.out.println("Please enter valid Data ");
		}

	}
	
	public void viewCustomerAccount()
	{
		Scanner scanner = SingletonDesignPattern.buildScannerInstance();

		System.out.println("Enter Username :");
		String username = scanner.next(); 
	
		Customer customer = usernameExists(username);
		
		if(customer != null) { 
			System.out.println("Customer Info :" + customer.toString()); 
		}else {
			System.out.println("Account With this username not found .... !!!");
		}
		
	}
	
	
	public Customer usernameExists(String username) {

		Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession();
		
		String urlString = "FROM Customer c WHERE c.customerUsername = : username" ;
		
		Customer customer = session.createQuery(urlString, Customer.class).setParameter("username", username).uniqueResult();
		
		try {
			if(customer.getCustomerUsername().equals(username)) { 			
				return customer;
			}
		}catch (Exception e) {}
		
		return null;
	}
	
	public void updateCustomerAccount() {
		Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession(); 
	}
	
	public static void main(String[] args) {
		new CustomerAccount().newCustomerAccount();
	}
}
