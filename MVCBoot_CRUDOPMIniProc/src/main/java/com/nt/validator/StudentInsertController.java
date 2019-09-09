package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.CustomerCommand;

public class StudentInsertController implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("validator -sopport");
		return clazz.isAssignableFrom(CustomerCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
    System.out.println("validator -validate");
		//type cast
		CustomerCommand cmd=(CustomerCommand)target;
		//perform validation
		if(cmd.getCno()<=0)
			errors.rejectValue("cno", "typemismatch.sno");
		
		if(cmd.getCname()==null ||cmd.getCname().length()<=0)
			errors.rejectValue("cname", "cname.required");
		
		if(cmd.getAddr()==null ||cmd.getAddr().equals(""))
			errors.rejectValue("addr", "addr.required");
		else if(cmd.getAddr().length()<=3)
			errors.rejectValue("addr", "addr.char");
		else if(cmd.getAddr().equals("dehli"))
			errors.rejectValue("addr","addr.city");
		
		if(cmd.getMobno()==null)
			errors.rejectValue("mobno", "mobno.required");
		
		if(cmd.getBillamt()==null)
			errors.rejectValue("billamt", "billamt.required");
		
	}
	

}
