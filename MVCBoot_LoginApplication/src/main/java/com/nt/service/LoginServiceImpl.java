package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.LoginBo;
import com.nt.dao.LoginDAO;
import com.nt.dto.LoginDTO;


@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO dao;

	@Override
	public String authencate(LoginDTO dto) {
		int count=0;
		LoginBo bo=null;
		//convert dto to bo
		bo=new LoginBo();
		BeanUtils.copyProperties(dto, bo);
		 count=dao.validate(bo);
		 System.out.println(count);
		return (count==1)? "valid crediantial":"invalid credential";
	}

	
}
