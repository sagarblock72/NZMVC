package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmpBo;

import lombok.Setter;
@Setter
public class ListEmpDAO {
	
	private static final String GET_RECORD="SELECT EMPNO,ENAME,JOB,SAL FROM EMP ORDER BY SAL";

	private JdbcTemplate jt;
	public List<EmpBo> retriveEmps(){
		List<EmpBo> listEmpBo=(List<EmpBo>)jt.query(GET_RECORD, new EmpRowMapper());
		
		return listEmpBo;
	}
	
	private class EmpRowMapper implements RowMapper<EmpBo>{

		@Override
		public EmpBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			//place resultset obj int bo class obj
			EmpBo empbo=new EmpBo();
			empbo.setEno(rs.getInt(1));
			empbo.setEname(rs.getString(2));
			empbo.setJob(rs.getString(3));
			empbo.setSalary(rs.getFloat(4));
			
			return empbo;
		}
		
		
	}
	

}
