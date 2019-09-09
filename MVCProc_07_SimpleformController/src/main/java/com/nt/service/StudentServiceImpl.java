package com.nt.service;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;
import com.sun.deploy.uitoolkit.impl.fx.Utils;

public class StudentServiceImpl implements StudentService{
	private StudentDAO dao;
	

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public StudentServiceImpl() {
		System.out.println("service-0-param-cons");
	}
	@Override
	public String register(StudentDTO dto) {
		StudentBO bo=null;
		//convert dto to bo
         bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		
		//use dao
		int result=dao.insert(bo);
		
		//process the result
		
		if(result==0)
			return "Student registration is failed ";
		else
		return "registration is success";
	}
	
	

}
