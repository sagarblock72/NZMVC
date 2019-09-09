package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO{
	private static final String INSERT_QUERY="insert into student values(?,?,?)"; 
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(StudentBO bo) {
		int cnt=jt.update(INSERT_QUERY,bo.getSno(),bo.getSname(),bo.getLoc());
		return cnt;
	}

}
