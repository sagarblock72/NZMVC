package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBo;

@Repository("loginDao")
public class LoginDAO {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PASSWORD=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	public int validate(UserBo bo) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUser(),bo.getPwd());
		return count;
	}

}
