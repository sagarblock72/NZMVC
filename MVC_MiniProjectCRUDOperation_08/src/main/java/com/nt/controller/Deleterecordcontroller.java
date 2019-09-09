package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerServiceImpl;

public class Deleterecordcontroller extends AbstractController{
	
	private CustomerServiceImpl service;

	public Deleterecordcontroller(CustomerServiceImpl service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=null;
		int cno=0;
		String resMsg=null;
		//get form data
		cno=Integer.parseInt(request.getParameter("cno"));
		resMsg =service.removeRecord(cno);
		
		List<CustomerDTO> listdto=service.listStudent();
		
		mav=new ModelAndView();
		mav.addObject("resultmsg",resMsg);
		mav.addObject("list",listdto);
		mav.setViewName("list_customer");
		
		return mav;
	}

}
