package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	
	private int eid;
	private String fname;
	private String lname;
	private String email;
	

}
