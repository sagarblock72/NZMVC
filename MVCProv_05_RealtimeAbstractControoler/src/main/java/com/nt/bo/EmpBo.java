package com.nt.bo;
import lombok.Data;

@Data
public class EmpBo {

	
	private int eno;
	private String ename;
	private String job;
	private float salary;
	
	public EmpBo() {
		System.out.println("EmpBo.EmpBo()-0-param cons");
	}
	
	public EmpBo(int eno, String ename, String job, float salary) {
		this.eno = eno;
		this.ename = ename;
		this.job = job;
		this.salary = salary;
	}

}
