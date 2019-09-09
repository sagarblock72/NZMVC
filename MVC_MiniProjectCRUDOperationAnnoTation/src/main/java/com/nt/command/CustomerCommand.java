package com.nt.command;

import lombok.Data;

@Data
public class CustomerCommand {
	
	private int cno;
	private String cname;
	private String addr;
	private Float sal;
	private Long mobno;
	private Integer billamt;

}
