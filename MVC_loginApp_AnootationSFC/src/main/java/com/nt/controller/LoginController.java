package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDto;
import com.nt.service.LoginService;
import com.nt.validator.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@Autowired
	private UserValidator validator;
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String authenticate(Model model){
		UserCommand cmd=new UserCommand();
		model.addAttribute("userCmd", cmd);
		return "login";
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("userCmd")UserCommand cmd,BindingResult error) {
	
		UserDto dto=null;
		String result=null;
		//convert cmd to dto
		dto=new UserDto();
		//use validator
				if(validator.supports(UserCommand.class))
					validator.validate(cmd, error);
				if(error.hasErrors()) 
					return "login";
				
		BeanUtils.copyProperties(cmd, dto);
		result=service.process(dto);
		map.put("result", result);
		map.put("domain",cmd);
		return "login";
	}
	
	@ModelAttribute("domains")
	public List<String> populateDomain(){
		List<String> countries=null;
		countries=new ArrayList();
		countries.add("india");
		countries.add("pak");
		countries.add("china");
		countries.add("dubai");
		return countries;
	}

}
