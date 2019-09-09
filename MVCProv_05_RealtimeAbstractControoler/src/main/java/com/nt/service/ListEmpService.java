package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmpBo;
import com.nt.dao.ListEmpDAO;
import com.nt.dto.EmpDTO;


public class ListEmpService {
	
	private ListEmpDAO dao;
	
	public ListEmpService() {}
	
public ListEmpService(ListEmpDAO dao) {
	this.dao=dao;
}
	
	
	public List<EmpDTO> getAllEmps(){
		
		List<EmpBo> listempbo=dao.retriveEmps();
		//copy list of bo ojb to list dto
		
		List<EmpDTO> empdto=new ArrayList<EmpDTO>();
		for(EmpBo bo:listempbo) {
		EmpDTO empdt=new EmpDTO(bo.getEno(), bo.getEname(), bo.getJob(), bo.getSalary());
		empdto.add(empdt);
		}
		return empdto;
	}//method 

}//class
