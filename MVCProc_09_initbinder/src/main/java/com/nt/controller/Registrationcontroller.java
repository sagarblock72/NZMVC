package com.nt.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.RegisCommand;

public class Registrationcontroller extends SimpleFormController{
	
	@Override
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		System.out.println("initBinder");
		SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("onsubmit");
		RegisCommand cmd=(RegisCommand)command;
		return new ModelAndView("register","rgCmd",cmd);
				
	}
	

}
