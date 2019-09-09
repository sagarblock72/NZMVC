package com.nt.command;

import lombok.Data;

@Data
public class SearchCommand {
	private int empno;
	private String ename;
	private String job;
	private float sal;
	
	public SearchCommand() {
		System.out.println("SearchCommand.SearchCommand()-0 param cons");
	}
	

}
