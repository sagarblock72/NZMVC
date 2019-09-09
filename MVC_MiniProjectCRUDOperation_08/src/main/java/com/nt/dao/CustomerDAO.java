package com.nt.dao;

import java.util.List;

import com.nt.bo.CustomerBO;


public interface CustomerDAO {
	
	public List<CustomerBO> getAll();
	public CustomerBO updatebySno(int cno);
	public int insertBycno(CustomerBO bo);
	public int deleteBycno(int cno);
	public int insertNewRecord(CustomerBO bo);

}
