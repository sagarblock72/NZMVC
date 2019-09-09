package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerServiceImpl;

@Controller
public class ListOnecontroller{

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value="/update.htm", method=RequestMethod.GET)
	public String updateCustomer(HttpServletRequest request,Map<String,Object> map)  {
		System.out.println("loc-formBackingObject()");
		int cno=0;
		//read cno
		cno=Integer.parseInt(request.getParameter("id"));
		
		//use service 
		CustomerDTO dto=service.getOneRecord(cno);
		//copy to cmd obj
		CustomerCommand cmd=new CustomerCommand();
		cmd.setCno(dto.getCno());
		cmd.setCname(dto.getCname());
		cmd.setAddr(dto.getAddr());
		cmd.setSal(dto.getSal());
		cmd.setMobno(dto.getMobno());
		cmd.setBillamt(dto.getBillamt());
		map.put("ctCmd", cmd);
		return "update_record";
	}
	
	@RequestMapping(value="/update.htm",method=RequestMethod.POST)
	public String updateRecord(Map<String,Object> map,@ModelAttribute CustomerCommand cmd) {
		
		System.out.println("update record");
		CustomerDTO dto=null;
		String resMsg=null;
		//convert cmd to dto
		
		dto=new CustomerDTO();
		dto.setCno(cmd.getCno());
		dto.setCname(cmd.getCname());
		dto.setAddr(cmd.getAddr());
		dto.setMobno(cmd.getMobno());
		dto.setSal(cmd.getSal());
		dto.setBillamt(cmd.getBillamt());
		resMsg=service.modifyRecord(dto);
		List<CustomerDTO> listdto=service.listStudent();
		map.put("list",listdto);
		map.put("resultmsg",resMsg);
		return "list_customer";
		
	}
}
