package com.nt.command;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserCommand {
	@Length(min=4,max=10,message="username should have minimum 4 and max 10 char")
	@NotEmpty(message="username can not be blank")
	private String user;
	@NotEmpty(message="pwd must contain something")
	private String pwd;

	public  UserCommand () {
		System.out.println(" UserCommand -o param cons");
	}
}
