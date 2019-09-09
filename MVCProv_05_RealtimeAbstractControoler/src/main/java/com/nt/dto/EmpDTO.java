package com.nt.dto;



import java.io.Serializable;


public class EmpDTO  implements Serializable{
	
	private int eno;
	private String ename;
	private String job;
	private float salary;
	
	public EmpDTO(int eno, String ename, String job, float salary) {
		this.eno = eno;
		this.ename = ename;
		this.job = job;
		this.salary = salary;
	}

}
