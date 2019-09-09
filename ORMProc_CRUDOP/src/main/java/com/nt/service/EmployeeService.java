package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeHLO;

public interface EmployeeService {
	public String regEmployee(EmployeeDTO dto);
	public List<EmployeeDTO> fetchAllEmp();
	public String updateEmail(int eid,String newEmail);
	public String deleteRecord(String lname);
	public List<EmployeeDTO> getAllBYLname(String lname1,String lname2,String lname3);

}
