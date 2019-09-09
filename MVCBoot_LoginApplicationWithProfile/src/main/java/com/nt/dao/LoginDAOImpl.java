package com.nt.dao;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.LoginBo;

@Named("loginDao")
public class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY="select count(*) from userlist where uname=? and password=?";
	
	@Resource
	private JdbcTemplate jt;

	@Override
	public int validate(LoginBo bo) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUser(),bo.getPwd());
		System.out.println(count);
		return count;
	}

}
