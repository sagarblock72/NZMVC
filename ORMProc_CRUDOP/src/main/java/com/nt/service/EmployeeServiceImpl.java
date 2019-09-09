package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeHLO;

@Service("empService")
public class EmployeeServiceImpl  implements EmployeeService{
	@Autowired(required=true)
	private EmployeeDAO dao;

	@Override
	public String regEmployee(EmployeeDTO dto) {
		int idval=0;
		EmployeeHLO hlo=null;
		//convert dto to hlo
		hlo=new EmployeeHLO();
		BeanUtils.copyProperties(dto, hlo);
		//use dao
		idval=dao.insertEmp(hlo);
		System.out.println(idval);
		return idval==0 ?"employee not registers":"employee register";
	}

	@Override
	public List<EmployeeDTO> fetchAllEmp() {
		List<EmployeeDTO> dto=new ArrayList();
		List<EmployeeHLO> hlo=null;
		//use dao
		hlo=dao.getAllEmployees();
		hlo.forEach(hlo1->{
			EmployeeDTO dto1=new EmployeeDTO();
			BeanUtils.copyProperties(hlo1, dto1);
			dto.add(dto1);
		});
		
		return dto;
	}

	@Override
	public String updateEmail(int eid, String newEmail) {
		int result=0;
		//use dao
		result=dao.updateEmpEmail(eid, newEmail);
		
		return result==0? "email not updated":"email updated";
	}

	@Override
	public String deleteRecord(String lname) {
		int cnt=0;
		cnt=dao.deleteEmpByLastName(lname);
		return cnt!=0?"record is deleted":"record is not deleted";
	}

	@Override
	public List<EmployeeDTO> getAllBYLname(String lname1, String lname2, String lname3) {
		List<EmployeeDTO> dto=new ArrayList<EmployeeDTO>();
		List<EmployeeHLO> hlo=null;
		hlo=dao.delrecByLname(lname1, lname2, lname3);
		hlo.forEach(hlo1->{
			EmployeeDTO dto1=new EmployeeDTO();
			BeanUtils.copyProperties(hlo1, dto1);
			dto.add(dto1);
			
		});
		return dto;
	}

}
