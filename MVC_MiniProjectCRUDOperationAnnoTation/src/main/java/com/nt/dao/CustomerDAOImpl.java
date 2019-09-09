package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("custDao")
public class CustomerDAOImpl implements CustomerDAO {
	
	private static final String GET_ALL_CUSTOMER="SELECT CNO,CNAME,ADDR,SAL,MOBNO,BILLAMT FROM CUSTOMER_INFO";
	private static final String GET_ONE_RECORD="SELECT CNO,CNAME,ADDR,SAL,MOBNO,BILLAMT FROM CUSTOMER_INFO WHERE CNO=?";
	private static final String INSERT_RECORD="UPDATE CUSTOMER_INFO SET CNAME=?,ADDR=?,SAL=?,MOBNO=?,BILLAMT=? WHERE CNO=?";
	private static final String DELETE_RECORD="DELETE FROM CUSTOMER_INFO WHERE CNO=?";
	private static final String NEW_RECORD="INSERT INTO CUSTOMER_INFO VALUES(?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate template;


	@Override
	public List<CustomerBO> getAll() {
		
		List<CustomerBO> lbo=template.query(GET_ALL_CUSTOMER, new CustomerRowMapper());
		return lbo;
	}

	private class CustomerRowMapper implements RowMapper<CustomerBO>{

		@Override
		public CustomerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CustomerBO bo=new CustomerBO();
			
			bo.setCno(rs.getInt(1));
			bo.setCname(rs.getString(2));
			bo.setAddr(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setMobno(rs.getLong(5));
			bo.setBillamt(rs.getInt(6));
			return bo;
		}
		
	}

	@Override
	public CustomerBO updatebySno(int cno) {
		
		CustomerBO bo=null;
		bo=template.queryForObject(GET_ONE_RECORD,(rs,index)->{

			CustomerBO boo=new CustomerBO();
			
			boo.setCno(rs.getInt(1));
			boo.setCname(rs.getString(2));
			boo.setAddr(rs.getString(3));
			boo.setSal(rs.getFloat(4));
			boo.setMobno(rs.getLong(5));
			boo.setBillamt(rs.getInt(6));
			return boo;
		}, cno);
		return bo;
	}

	@Override
	public int insertBycno(CustomerBO bo) {
		int cnt=0;
		System.out.println(bo);
		cnt=template.update(INSERT_RECORD, bo.getCname(),bo.getAddr(),bo.getSal(),bo.getMobno(),bo.getBillamt(),bo.getCno());
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public int deleteBycno(int cno) {
		int cnt=0;
		cnt=template.update(DELETE_RECORD, cno);
		return cnt;
	}

	@Override
	public int insertNewRecord(CustomerBO bo) {
	int cnt=0;
	cnt=template.update(NEW_RECORD,bo.getCno(),bo.getCname(),bo.getAddr(),bo.getSal(),bo.getMobno(),bo.getBillamt());
		return cnt;
	}
	

}
