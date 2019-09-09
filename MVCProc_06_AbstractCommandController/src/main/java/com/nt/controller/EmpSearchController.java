package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.SearchCommand;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchresultDTO;
import com.nt.service.EmpSearchService;


public class EmpSearchController extends AbstractCommandController {
	
	
	
	private EmpSearchService service;

	public void setService(EmpSearchService service) {
		this.service = service;
	}
	
	public EmpSearchController() {
		System.out.println("EmpSearchController-0-param cons");
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object cmd,
			BindException errors) throws Exception {
		System.out.println("handle method");
		//get command obj
		SearchCommand command=(SearchCommand)cmd;
		//convert cmd to bo
		EmpSearchDTO dto=new EmpSearchDTO();
		
		dto.setEmpno(command.getEmpno());
		dto.setEname(command.getEname());
		dto.setJob(command.getJob());
		dto.setSal(command.getSal());
		//use service class
		
		List<EmpSearchresultDTO> listrdto=service.process(dto);
		
		//mav.addObject("listEmps");
		//mav.addObject("searchresult", listrdto);
		
		System.out.println(listrdto);
		return new ModelAndView("listEmps","searchresult",listrdto);
	
	
	}


}
