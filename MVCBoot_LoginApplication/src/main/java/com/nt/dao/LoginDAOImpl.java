package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.LoginBo;

@Repository("loginDao")
public class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY="select count(*) from userlist where uname=? and password=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int validate(LoginBo bo) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUser(),bo.getPwd());
		System.out.println(count);
		return count;
	}

}
