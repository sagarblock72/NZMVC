package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDTO;

public interface CustomerService {
	
	public List<CustomerDTO> listStudent();
	public CustomerDTO  getOneRecord(int cno);
	public String modifyRecord(CustomerDTO dto);
	public String removeRecord(int cno);
	public String insertNewSustomer(CustomerDTO dto);

}
