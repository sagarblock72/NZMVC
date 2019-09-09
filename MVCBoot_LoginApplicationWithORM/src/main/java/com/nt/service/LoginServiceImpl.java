package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserHLO;
import com.nt.dao.LoginDAO;
import com.nt.dto.LoginDTO;


@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO dao;

	@Override
	public String authencate(LoginDTO dto) {
		int count=0;
		UserHLO hlo=null;
		//convert dto to bo
		hlo=new UserHLO();
		BeanUtils.copyProperties(dto, hlo);
		 count=dao.validate(hlo);
		 System.out.println(count);
		return (count==1)? "valid crediantial":"invalid credential";
	}

	
}
