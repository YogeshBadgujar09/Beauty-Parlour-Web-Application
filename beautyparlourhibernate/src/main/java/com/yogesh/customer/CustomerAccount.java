package com.yogesh.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.yogesh.entities.Customer;

public class CustomerAccount {
	
	public void newCustomerAccount() {
		
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Configuration configure = new Configuration();
		configure.configure();
		
		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();
	
		Transaction transaction = session.beginTransaction();
		
		System.out.println(" Fill The Information \n\n");
		    		
		System.out.println("Enter Full Name :");
		customer.setCustomerName(scanner.nextLine());
		
		System.out.println("Enter Mobile No. :");
		customer.setCustomerMobileNo(scanner.next());
		
		System.out.println("Enter Email Id :");
		customer.setCustomerEmail(scanner.next());
		
		
		try {
			System.out.println("Enter DOB :");
			customer.setCustomerDOB(simpleDateFormat.parse(scanner.next()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scanner.nextLine();
		System.out.println("Enter Address :");
		customer.setCustomerAddress(scanner.nextLine());
		
		System.out.println("Enter City :");
		customer.setCustomerCity(scanner.next());
		
		scanner.nextLine();
		System.out.println("Enter State :");
		customer.setCustomerState(scanner.nextLine());
		
		System.out.println("Enter Username :");
		customer.setCustomerUsername(scanner.next());
		
		System.out.println("Enter Password :");
		customer.setCustomerPassword(scanner.next());
		  		
		
		session.persist(customer);
		transaction.commit();
		
		session.close();
		System.out.println(" \n\n ********** Print Infromation ********** \n\n" + customer.toString() );
		
	}
		
	
	public void viewCustomerAccount()
	{
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		
		Configuration configure = new Configuration();
		configure.configure();
		
		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();
	
		System.out.println("Enter Username :");
		String username = scanner.next(); 
		
		String urlString = "FROM Customer c WHERE c.customerUsername = : username" ;
		
		customer = session.createQuery(urlString, Customer.class).setParameter("username", username).uniqueResult();
		
		System.out.println("Customer Info :" + customer.toString());
	}

}
