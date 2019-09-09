package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

public class ListAllController extends AbstractController {
	
	private CustomerService service;

	public ListAllController(CustomerService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//use service class
		
		List<CustomerDTO> ldto=service.listStudent();
		System.out.println(ldto);
		return new ModelAndView("list_customer","list",ldto);
	}

}
