package com.nt.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmpDTO;
import com.nt.service.ListEmpService;

public class ListEmpController extends AbstractController{
	
	private ListEmpService service;
	
	

	public ListEmpController(ListEmpService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<EmpDTO> listEmpDTO =service.getAllEmps();
		System.out.println(listEmpDTO);
		return new ModelAndView("list_emps","empList",listEmpDTO);
	}

}
