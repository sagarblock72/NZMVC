package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class WishService {
	
	public String generete() {
		Calendar cal=null;
		int hour=0;
		
		cal=Calendar.getInstance();
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<=12)
			return "good morning";
		else if(hour<=16)
			return "good afternoon";
		else if(hour<=20)
			return "good evening";
		else
			return "good night";
				
	}

}
