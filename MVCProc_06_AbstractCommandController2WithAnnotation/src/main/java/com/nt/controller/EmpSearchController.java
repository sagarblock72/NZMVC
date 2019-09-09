package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.SearchCommand;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchresultDTO;
import com.nt.service.EmpSearchService;

@Controller
public class EmpSearchController {
	
	@Autowired
	private EmpSearchService service;

	public EmpSearchController() {
		System.out.println("EmpSearchController-0-param cons");
	}
	
	@RequestMapping("/search.htm")
	public String first() {
		return "search";
	}

	@RequestMapping("/searchemps.htm")
	public String handle(Map<String,Object> map,@ModelAttribute("serCmd") SearchCommand cmd) {
		EmpSearchDTO dto=new EmpSearchDTO();
		
		dto.setEmpno(cmd.getEmpno());
		dto.setEname(cmd.getEname());
		dto.setJob(cmd.getJob());
		dto.setSal(cmd.getSal());
		//use service class
		List<EmpSearchresultDTO> listrdto=service.process(dto);
		
		map.put("searchresult",listrdto);
		
		System.out.println(listrdto);
		return "listEmps";
	
	}
}
