package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.bean.Employee;
import com.nt.bean.EmployeeDao;

public class Test {


public static void main(String[] args) {  
    ApplicationContext ctx=new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml") ; 
    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
    List<Employee> list=dao.getAllEmployees();  
          
    for(Employee e:list)  
        System.out.println(e);  
    
    
    }  
}
