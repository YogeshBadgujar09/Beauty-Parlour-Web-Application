package com.yogesh.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateFormate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String date = new String("30/09/2004");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = simpleDateFormat.format(date);
		
		System.out.println("dateString :" + dateString);

	}

}
