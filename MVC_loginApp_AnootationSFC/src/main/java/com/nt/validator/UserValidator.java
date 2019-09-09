package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

@Component("validate")
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		//type cast
		UserCommand cmd=(UserCommand)target;
		if(cmd.getUser().length()==0||cmd.getUser().equals("")||cmd.getUser()==null)
			errors.rejectValue("user", "user.requered");
		
		if(cmd.getPwd().length()==0||cmd.getPwd()==null)
			errors.rejectValue("pwd", "pwd.requered");
		
	}

}
