package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;


public class EmpSearchDAOImpl implements EmpSearchDAo {
	
	private static final String query="select empno,ename,job,sal,mgr,deptno from emp "+" where (empno is not null and empno= ?) "+" or (ename is not null and ename = ?) "+" or (job is not null and job=?) "+" or (sal is not null and sal= ?)";

	private JdbcTemplate jt;
	
	public EmpSearchDAOImpl() {
		System.out.println("EmpSearchDAOImpl-0-param");
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<EmpSearchResultBO> search(EmpSearchBO sbo) {
		System.out.println("dao-search");
		
		List<EmpSearchResultBO> listRBO=jt.query(query, new EmpRowMapper(), sbo.getEmpno(),sbo.getEname(),sbo.getJob(),sbo.getSal());
		
		System.out.println(listRBO);
		
		return listRBO;
	}

	private static final class EmpRowMapper implements RowMapper<EmpSearchResultBO>{

		@Override
		public EmpSearchResultBO mapRow(ResultSet rs, int pos) throws SQLException {
			
			//copy the record bo to rbo
			EmpSearchResultBO rbo= new EmpSearchResultBO();
			
			  rbo.setEmpno(rs.getInt(1)); 
			  rbo.setEname(rs.getString(2));
			  rbo.setJob(rs.getString(3)); 
			  rbo.setSal(rs.getInt(4));
			  rbo.setMgrno(rs.getInt(5)); 
			  rbo.setDeptno(rs.getInt(6));
			 
			System.out.println(rbo.getEname());
			return rbo;
		}
	}
}
