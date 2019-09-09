package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerServiceImpl;

@Controller
public class NewCustomerRegcontroller {
	
	@Autowired
	private CustomerServiceImpl service;
	
	@RequestMapping(value="/newuser.htm",method=RequestMethod.GET)
	public String newUserForm(Map<String,Object> map,@ModelAttribute("ctCmd") CustomerCommand cmd) {
		map.put("cmd",cmd);
		return "register";
	}

	@RequestMapping(value="/newuser.htm",method=RequestMethod.POST)
	public String newReg(Map<String,Object> map,@ModelAttribute("ctCmd")CustomerCommand cmd) {
		System.out.println("onsubmit-ncr");
		CustomerDTO dto=null;
		String resMsg=null;
		
		//convert cmd to dto
		dto= new CustomerDTO();
		dto.setCno(cmd.getCno());
		dto.setCname(cmd.getCname());
		dto.setAddr(cmd.getAddr());
		dto.setSal(cmd.getSal());
		dto.setBillamt(cmd.getBillamt());
		dto.setMobno(cmd.getMobno());
		
		//use service
		resMsg=service.insertNewSustomer(dto);
		
		List<CustomerDTO> listdto=service.listStudent();
		
		map.put("list", listdto);
		map.put("resultmsg",resMsg);
		
		
		return "list_customer";
	}
	

}
