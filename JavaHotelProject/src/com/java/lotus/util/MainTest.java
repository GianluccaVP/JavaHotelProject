package com.java.lotus.util;

import java.util.Date;


public class MainTest {
	
	public static void main(String[] args) 
	{
		String Date = "15/12/2021";
		
		Date convertedDate = DateUtil.convertToDate(Date);
		
		System.out.println(convertedDate);
	}

}
