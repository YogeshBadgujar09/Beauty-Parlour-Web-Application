package com.yogesh.customer;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import com.yogesh.entities.Customer;
import com.yogesh.util.singletondesignpattern.SingletonDesignPattern;

import jakarta.validation.ConstraintViolationException;

public class CustomerAccount {
	
	private Scanner scanner;
	private CustomerInformationOptimize customerInformationOptimize ;
	private Customer customer;
	private Session session ;
	private Transaction transaction;
	
	/**
	 * newCustomerAccount method is define for create new customer account in this web-application.
	 * In this method use buildScannerInstance() for create Scanner object, which follow Singleton Design Pattern.
	 * Also use buildSessionFactoryInstance() which return Session object and its also follow Singleton Design Pattern.
	 * SingletonDesignPattern.validationCheck(customer) is used for Customer Information Validation.  
	 */
	
	public void newCustomerAccount() {
		

		customer = new Customer();
		customerInformationOptimize = new CustomerInformationOptimize();
		scanner = SingletonDesignPattern.buildScannerInstance();
		
		try {
			
			Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession();
			Transaction transaction = session.beginTransaction();
			
			System.out.println("++++++++++++ Create New Customer ++++++++++++++ \n\n");
			    		
			customer = customerInformationOptimize.insertCustomerInformation(customer);
			
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
			String password = scanner.next();
			String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			customer.setCustomerPassword(encryptedPassword); 	
			
			customer.setCustomerCreateDate(LocalDate.now());
			
			SingletonDesignPattern.validationCheck(customer);
			
			session.persist(customer);
			transaction.commit();
			
			session.close();
			
		}catch (ConstraintViolationException e) {
				System.out.println("Please enter valid Data ");
		}
	}
	
	
	/**
	 * This method is define for show the customers details if username is available.
	 * In this method SingletonDesignPattern.buildScannerInstance() is used 
	 * which flow Singleton Design Project approach 
	 */
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
	
	/**
	 * usenameExists method is define to search a particular customer. 
	 * it take username for search customer and return Customer object if customer available.
	 * It is provide code optimization for different CRUD operation r
	 */
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
	
	
	public Customer customerExistsWithMobile(String customerMobileNo) {

		Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession();
		
		String urlString = "FROM Customer c WHERE c.customerMobileNo = : customerMobileNo " ;
		
		Customer customer = session.createQuery(urlString, Customer.class).setParameter("customerMobileNo", customerMobileNo).uniqueResult();
		
		try {
			if(customer.getCustomerMobileNo().equals(customerMobileNo)) { 			
				return customer;
			}
		}catch (Exception e) {}
		
		return null;
	}
	
	/**
	 * updateCustomerAccount method is Create to update the Information of Customer 
	 * username and Password will not change 
	 */
	
	public void updateCustomerAccount() {
		
		Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession(); 
		Transaction transaction = session.beginTransaction();
		
		Scanner scanner = SingletonDesignPattern.buildScannerInstance();
		customerInformationOptimize = new CustomerInformationOptimize();
		
		System.out.println("Enter Username :");
		String username = scanner.next(); 
	
		Customer customer = usernameExists(username);
		
		if(customer != null) { 
			
			System.out.println("+++++++++++++++ CONFIRM PROFILE ++++++++++++++++++++\n\n" + customer.toString());
				
			System.out.println("*********************** UPDATE PROFILE ************************");
			
			try {
				
				scanner.nextLine();
				customerInformationOptimize.insertCustomerInformation(customer);
				SingletonDesignPattern.validationCheck(customer);
				session.update(customer);
				transaction.commit();
				session.close();

			}catch(ConstraintViolationException e) {
				System.out.println("Enter Valid Data ... !!!");
			}
			
			
			
		}else {
			System.out.println("Account With this username not found .... !!!");
		}	
	
	}
	
	public void deleteCustomer() {
		
		Scanner scanner = SingletonDesignPattern.buildScannerInstance();
		Session session = SingletonDesignPattern.buildSessionFactoryInstance().openSession(); 
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter Username :");
		String username = scanner.next(); 
	
		Customer customer = usernameExists(username);
		
		if(customer != null) { 
			
			System.out.println("+++++++++++++++ CONFIRM PROFILE ++++++++++++++++++++\n\n" + customer.toString());
			
			session.delete(customer);
			transaction.commit();
			
			session.close();
			
		}else {
			System.out.println("Account With this username not found .... !!!");
		}	
		
	}
	
	
	public static void main(String[] args) {
		new CustomerAccount().updateCustomerAccount();
	}
}
