package com.nt.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.nt.controller")
public class WebAppConfig {

	public ViewResolver getViewResolver() {
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
		return ivr;
	}
}
