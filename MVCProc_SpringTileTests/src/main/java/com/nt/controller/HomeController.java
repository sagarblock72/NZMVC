package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/welcome.htm")
	public String showHomePage() {
		return "page1";
	}
	
	@RequestMapping("/sports.htm")
	public String showPage1() {
		return "page2";
	}
	
	@RequestMapping("/poli.htm")
	public String showPage2() {
		return "page3";
	}
	
	@RequestMapping("/enter.htm")
	public String showPage3() {
		return "page4";
	}

}
