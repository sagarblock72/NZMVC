package com.nt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.UserCommand;
import com.nt.dto.UserDto;
import com.nt.service.LoginService;

@Controller
@SessionAttributes(value="userCmd",types=UserCommand.class)
public class LoginController {
	@Autowired
	private LoginService service;
	
	@ModelAttribute("userCmd")
	public UserCommand sessiontest() {
		return new UserCommand();
	}
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String authenticate(Model model){
		System.out.println("get authen()");
		UserCommand cmd=new UserCommand();
		model.addAttribute("userCmd", cmd);
		return "login";
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@Valid@ModelAttribute("userCmd")UserCommand cmd,BindingResult error) {
	System.out.println("post process form");
		UserDto dto=null;
		String result=null;
		//convert cmd to dto
		dto=new UserDto();
		BeanUtils.copyProperties(cmd, dto);
		result=service.process(dto);
		map.put("result", result);
		
		return "login";
	}

}
