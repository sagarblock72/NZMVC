package com.nt.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao {
	private JdbcTemplate template;  
	

	public void setjdbcTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	  
	public List<Employee> getAllEmployees(){  
	 return template.query("select * from employee",new ResultSetExtractor<List<Employee>>(){  
	    @Override  
	     public List<Employee> extractData(ResultSet rs) throws SQLException,  
	          Exception {  
	      
	        List<Employee> list=new ArrayList<Employee>();  
	        while(rs.next()){  
	        Employee e=new Employee();  
	        e.setId(rs.getInt(1));  
	        e.setName(rs.getString(2));  
	        e.setSalary(rs.getInt(3));  
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });  
	  }  

}
