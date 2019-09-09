package com.nt.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentInsertValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		//type casting
		StudentCommand cmd=(StudentCommand)target;
		
		//form validation
		
		if(cmd.getSno()<=0)
			errors.rejectValue("sno", "sno.invalid");
		else if(cmd.getSno()==0)
			errors.rejectValue("sno", "typemismatch.sno");
		
		if(cmd.getSname()==null||cmd.getSname().equals(""))
			errors.rejectValue("sname", "sname.required");
		
		if(cmd.getLoc()==null)
			errors.rejectValue("loc", "sloc.required");
		else if(cmd.getLoc().length()<=5)
			errors.rejectValue("loc", "sloc.char");
		else if(cmd.getLoc().equals("dehli"))
			errors.rejectValue("loc", "sloc.city");
	  
		
			
			
			
	}

}
