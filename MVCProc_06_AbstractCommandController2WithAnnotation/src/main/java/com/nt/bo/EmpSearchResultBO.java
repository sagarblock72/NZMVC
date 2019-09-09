package com.nt.bo;

import lombok.Data;


public class EmpSearchResultBO extends EmpSearchBO{
	
	private int deptno;
	private int mgrno;
	
	public EmpSearchResultBO() {
		
	}
	
	public EmpSearchResultBO(int empno, String ename, String job, float sal, int deptno, int mgrno) {
		super(empno, ename, job, sal);
		this.deptno = deptno;
		this.mgrno = mgrno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getMgrno() {
		return mgrno;
	}

	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
	
	
	

}
