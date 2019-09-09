package com.nt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishService;

@Controller
public class WishController {
	
	@RequestMapping("/welcome.htm")
	public String handle() {
		return "home";
	}
	
	@Resource
	private WishService service;

	/*@RequestMapping("/wish.htm")
	public ModelAndView process() {
		//use service class
		String msg=service.generateMsg();
		return new ModelAndView("result","msg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Model model) {
		//use service
		String msg=service.generateMsg();
		model.addAttribute("msg",msg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map) {
		
		String msg=service.generateMsg();
		map.put("msg", msg);
		return "result";
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public void process(Map<String,Object> map) {
		
		String msg=service.generateMsg();
		map.put("msg", msg);
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object> process() {
		Map<String,Object> map=null;
		String msg=service.generateMsg();
		map=new HashMap();
		map.put("msg",msg);
		return map;
		
	}*/
	
	@RequestMapping("/wish.htm")
	public Model process() {
		Model model=null;
		String msg=service.generateMsg();
		model=new BindingAwareConcurrentModel();
		model.addAttribute("msg",msg);
		return model;
		
	}
}
