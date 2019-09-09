package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

@Controller
public class ListAllController  {
	
	@Autowired
	private CustomerService service;

	@RequestMapping("/welcome.htm")
	public String showForm() {
		return "home";
	}
	
	@RequestMapping("/list.htm")
	public String showList(Map<String,Object> map) {
		
		//use service class
		List<CustomerDTO> ldto=service.listStudent();
		System.out.println(ldto);
		map.put("list", ldto);
		return "list_customer";
	}

}
