package com.nt.initilizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;

@SpringBootApplication
@Import(RootAppConfig.class)
public class MvcBootCrudopmIniProcApplication {

	
	  public static void main(String[] args) {
	  SpringApplication.run(MvcBootCrudopmIniProcApplication.class, args); }
	 

}
