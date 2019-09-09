package com.nt.command;

import lombok.Data;

@Data
public class StudentCommand {
	
	private int sno=101;
	private String sname;
	private String loc="hyd";
	
	public StudentCommand() {
		System.out.println("StudentCommand-0 param cons");
	}
}
