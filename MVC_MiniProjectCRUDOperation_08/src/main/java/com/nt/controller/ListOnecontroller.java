package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerServiceImpl;

public class ListOnecontroller extends SimpleFormController{

	private CustomerServiceImpl service;

	public ListOnecontroller(CustomerServiceImpl service) {
		this.service = service;
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest request) 
			throws Exception {
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
		
		return cmd;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		System.out.println("onsubmit-loc");
		CustomerDTO dto=null;
		String resMsg=null;
		ModelAndView mav=null;
		//convert cmd to dto
		
		CustomerCommand cmd=(CustomerCommand)command;
		dto=new CustomerDTO();
		dto.setCno(cmd.getCno());
		dto.setCname(cmd.getCname());
		dto.setAddr(cmd.getAddr());
		dto.setMobno(cmd.getMobno());
		dto.setSal(cmd.getSal());
		dto.setBillamt(cmd.getBillamt());
		resMsg=service.modifyRecord(dto);
		List<CustomerDTO> listdto=service.listStudent();
		mav=new ModelAndView();
		mav.addObject("list",listdto);
		mav.addObject("resultmsg",resMsg);
		mav.setViewName("list_customer");
		return mav;
		
	}
}
