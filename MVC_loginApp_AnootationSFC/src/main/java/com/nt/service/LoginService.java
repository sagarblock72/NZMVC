package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBo;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDto;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	public String process(UserDto dto) {
		UserBo bo=null;
		int count=0;
		//convert dto to bo
		bo =new UserBo();
		BeanUtils.copyProperties(dto, bo);
		count =dao.validate(bo);
		if(count==0)
			return "invalid cerdiantial";
		else
			return "valid credential";
	}

}
