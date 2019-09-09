package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;
import com.nt.dao.EmpSearchDAOImpl;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchresultDTO;


public class EmpSearchServiceImpl implements EmpSearchService {
	
	private EmpSearchDAOImpl dao;

	public void setDao(EmpSearchDAOImpl dao) {
		System.out.println("EmpSearchServiceImpl-0-param cons");
		this.dao = dao;
	}

	@Override
	public List<EmpSearchresultDTO> process(EmpSearchDTO dto) {
		System.out.println("service -process");
		//convert dto to bo obj
		EmpSearchBO bo=new EmpSearchBO();
		bo.setEmpno(dto.getEmpno());
		bo.setEname(dto.getEname());
		bo.setJob(dto.getJob());
		bo.setSal(dto.getSal());
		
		//use dao
		List<EmpSearchResultBO> rbo=dao.search(bo);
		
		//convert rbo to rdto
		List<EmpSearchresultDTO> rdto=new ArrayList<EmpSearchresultDTO>();
		
		//BeanUtils.copyProperties(rbo, rdto);
		
		  for(EmpSearchResultBO rb:rbo) { 
			  EmpSearchresultDTO rrto=new EmpSearchresultDTO();
			  rrto.setEmpno(rb.getEmpno());
		  rrto.setEname(rb.getEname()); 
		  rrto.setJob(rb.getJob());
		  rrto.setSal(rb.getSal());
		  rrto.setDeptno(rb.getDeptno());
		  rrto.setMgrno(rb.getMgrno()); 
		  rdto.add(rrto); }
		 
		//System.out.println(rbo);
		//System.out.println(rdto);
		
		return rdto;
	}

}
