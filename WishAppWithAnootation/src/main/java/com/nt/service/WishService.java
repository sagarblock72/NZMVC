package com.nt.service;

import java.util.Calendar;

import javax.inject.Named;

@Named("wc")
public class WishService {
	
	public String generateMsg() {
		Calendar cl=null;
		cl=Calendar.getInstance();
		int hour=cl.get(Calendar.HOUR_OF_DAY);
		if(hour<=12)
			return "Good morning";
		else if(hour<=16)
			return "good After noon";
		else if(hour<=20)
			return "Good morning";
		else
			return "Good night";
	}

}
