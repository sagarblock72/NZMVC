package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;

@SpringBootApplication
@Import({RootAppConfig.class})
public class MvcBootFirstAppWishAppApplication {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(MvcBootFirstAppWishAppApplication.class, args); }
	 */

}
