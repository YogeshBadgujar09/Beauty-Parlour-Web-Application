package com.yogesh.beautyparlourhibernate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yogesh.customer.CustomerAccount;
import com.yogesh.entities.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		CustomerAccount customerAccount = new CustomerAccount();
    		customerAccount.viewCustomerAccount();	
    		
    }
}
