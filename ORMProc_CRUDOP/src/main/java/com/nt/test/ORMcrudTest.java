package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class ORMcrudTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		
		//create ioc container
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get bean
		service=ctx.getBean("empService",EmployeeService.class);
		dto=new EmployeeDTO();
		//dto.setEid(105);
		//dto.setFname("anug");
		//dto.setLname("manu");
		//dto.setEmail("anug@mail");
		
		//invoke method
		//System.out.println(service.regEmployee(dto));
		System.out.println(service.fetchAllEmp());
		//System.out.println(service.updateEmail(101, "sag123@gmail"));
		//System.out.println(service.deleteRecord("manu"));
		System.out.println(service.getAllBYLname("lamne", "dada", "kake"));
	}

}
