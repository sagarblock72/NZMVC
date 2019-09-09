package com.nt.bo;

import lombok.Data;

@Data
public class EmpSearchBO {
	private int empno;
	private String ename;
	private String job;
	private float sal;
	
	public EmpSearchBO() {
		
	}
	public EmpSearchBO(int empno, String ename, String job, float sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}

}
