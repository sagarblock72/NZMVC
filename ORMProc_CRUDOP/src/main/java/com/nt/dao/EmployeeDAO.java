package com.nt.dao;

import java.util.List;

import com.nt.entity.EmployeeHLO;

public interface EmployeeDAO {
	public int insertEmp(EmployeeHLO hlo);
	public List<EmployeeHLO> getAllEmployees();
	public int updateEmpEmail(int eid,String newEmail);
	public int deleteEmpByLastName(String lname);
	public List<EmployeeHLO> delrecByLname(String lname1,String lname2,String lname3);

}
