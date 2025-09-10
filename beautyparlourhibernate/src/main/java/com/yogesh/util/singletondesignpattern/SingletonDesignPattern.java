package com.yogesh.util.singletondesignpattern;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonDesignPattern {

	private static SessionFactory sessionFactory ; 
	private static Scanner scanner;
	
	public static SessionFactory buildSessionFactoryInstance() {
		
		if(sessionFactory == null){
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();	
		}
		
		return sessionFactory;
	}
		
	
	public static Scanner buildScannerInstance() {
		
		if(scanner == null){
				scanner = new Scanner(System.in);
		}
		
		return scanner;
	}
}
