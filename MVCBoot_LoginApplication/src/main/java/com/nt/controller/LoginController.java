package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@GetMapping("/login")
	public String showForm(@ModelAttribute("userCmd")UserCommand cmd) {
		cmd.setUser("sagar");
		return "login";
	}
	
	@PostMapping("/login")
	public String showResultform(@ModelAttribute("userCmd")UserCommand cmd,Map<String,Object> map) {
		String result=null;
		LoginDTO dto=null;
		//copy cmd to dto
		dto=new LoginDTO();
		BeanUtils.copyProperties(cmd, dto);
		result=service.authencate(dto);
		map.put("rMsg", result);
		return "login";
	}

}
