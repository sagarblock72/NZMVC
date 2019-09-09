package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerServiceImpl;

@Controller
public class Deleterecordcontroller{
	
	@Autowired
	private CustomerServiceImpl service;


	@RequestMapping("/delete.htm")
	public String deleteCustomer(HttpServletRequest request,Map<String,Object> map) {
		int cno=0;
		String resMsg=null;
		//get form data
		cno=Integer.parseInt(request.getParameter("cno"));
		resMsg =service.removeRecord(cno);
		
		List<CustomerDTO> listdto=service.listStudent();
		
		map.put("resultmsg",resMsg);
		map.put("list",listdto);
		
		return "list_customer";
	}

}
