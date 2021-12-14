package com.java.lotus.util;

import java.util.Date;

public class DateUtil {	
	
	public static Date convertToDate(String Date)
	{
		Date = Date.replace("/", "");
		
		System.out.println(Date);
		
		Date convertedDate = new Date(Long.parseLong(Date));
		
		return convertedDate;
	}
}