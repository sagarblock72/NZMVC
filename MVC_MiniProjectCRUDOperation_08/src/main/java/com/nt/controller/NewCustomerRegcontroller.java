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

public class NewCustomerRegcontroller extends SimpleFormController{
	
	private CustomerServiceImpl service;

	public NewCustomerRegcontroller(CustomerServiceImpl service) {
		this.service = service;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("onsubmit-ncr");
		CustomerDTO dto=null;
		ModelAndView mav=null;
		String resMsg=null;
		//type cast to cmd
		CustomerCommand cmd=(CustomerCommand)command;
		
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
		
		mav=new ModelAndView();
		mav.addObject("list", listdto);
		mav.addObject("resultmsg",resMsg);
		mav.setViewName("list_customer");
		
		
		return mav;
	}
	

}
