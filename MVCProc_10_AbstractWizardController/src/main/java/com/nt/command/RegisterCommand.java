package com.nt.command;

import lombok.Data;

@Data
public class RegisterCommand {
	//login credential
	
	private String username;
	private String password;
	
	//contact details
	private String email;
	private long mobno;
	
	//adress details
	
	private String city;
	private int pincode;

}
