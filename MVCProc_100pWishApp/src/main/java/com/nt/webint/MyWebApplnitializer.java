package com.nt.webint;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.cfgs.RootAppConfig;
import com.nt.cfgs.WebAppConfig;

public class MyWebApplnitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {

		AnnotationConfigWebApplicationContext rootctx=null,childctx=null;
		
		//create root application context container
		rootctx= new AnnotationConfigWebApplicationContext();
		rootctx.register(RootAppConfig.class);
		
		
		//create web application context container(child container)
		childctx= new AnnotationConfigWebApplicationContext();
		childctx.register(WebAppConfig.class);
		
		//create contextloaderlistener
		ContextLoaderListener listener=null;
		listener=new ContextLoaderListener(rootctx);
		ctx.addListener(listener);
		
		
		//create dispatcher servlet
		DispatcherServlet servlet=new DispatcherServlet(childctx);
		
		ServletRegistration.Dynamic register=ctx.addServlet("ds", servlet);
		register.addMapping("*.htm");
		register.setLoadOnStartup(2);
	}

}
