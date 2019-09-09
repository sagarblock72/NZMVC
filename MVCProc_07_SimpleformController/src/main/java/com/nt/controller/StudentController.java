package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentController extends SimpleFormController{
	
	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}
	public StudentController() {
		System.out.println("contro-0-param cons");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentDTO dto=null;
		//type cast cmd obj
		StudentCommand cmd=(StudentCommand)command;
		
		//convert cmd to dto
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		
		String finalresult=service.register(dto);
		
		return new ModelAndView(this.getSuccessView(),"resMsg",finalresult);
	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("dblpost");
	}

	
}
