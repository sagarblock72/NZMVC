package com.nt.service;

import java.util.Calendar;

public class WishService {
	
	public String generateWish() {
		
		Calendar cl=Calendar.getInstance();
		int hour=cl.get(Calendar.HOUR_OF_DAY);
		String msg=null;
		if(hour<12)
			msg="Good morning";
		else if(hour<16)
			msg="Good Afternoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good night";
		return msg;
	}

}
