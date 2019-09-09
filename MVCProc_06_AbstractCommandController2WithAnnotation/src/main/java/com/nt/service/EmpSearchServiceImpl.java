package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;
import com.nt.dao.EmpSearchDAOImpl;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchresultDTO;

@Service
public class EmpSearchServiceImpl implements EmpSearchService {
	
	@Resource
	private EmpSearchDAOImpl dao;


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
		System.out.println(rdto);
		
		return rdto;
	}

}
