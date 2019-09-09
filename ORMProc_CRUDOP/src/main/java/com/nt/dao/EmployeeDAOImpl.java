package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.EmployeeHLO;

@Repository("empdao")
public class EmployeeDAOImpl  implements EmployeeDAO{
	private static final String QUERY_FOR_GET_ALL="from EmployeeHLO";
	private static final String QUERY_FOR_UPDATE_EMAIL="update EmployeeHLO set email=:email where eid=:eid";
	private static final String QUERY_FOR_DELETE_RECORD="delete from EmployeeHLO where lname=:lname ";
	private static final String QUERY_FOR_FETCH_BY_LASTNAME="from EmployeeHLO where lname=:lname1,lname2,lname3 ";
	@Autowired(required=true)
	private HibernateTemplate ht;

	@Override
	public List<EmployeeHLO> getAllEmployees() {
		List<EmployeeHLO> hlo=null;
		hlo=(List<EmployeeHLO>) ht.find(QUERY_FOR_GET_ALL);
		return hlo;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int insertEmp(EmployeeHLO hlo) {
		ht.setCheckWriteOperations(false);
		int idval=0;
		idval=(int)ht.save(hlo);
		System.out.println(idval);
		return idval;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int updateEmpEmail(int eid, String newEmail) {
		int result=0;
		result=ht.execute(ses->{
			int cnt=0;
			Query query=ses.createQuery(QUERY_FOR_UPDATE_EMAIL);
			query.setParameter("email", newEmail);
			query.setParameter("eid", eid);
			cnt=query.executeUpdate();
			return cnt;
		});
		return result;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int deleteEmpByLastName(String lname) {
		int cnt1=0;
		cnt1=ht.execute(ses->{
			int cnt=0;
			Query query=ses.createQuery(QUERY_FOR_DELETE_RECORD);
			query.setParameter("lname", lname);
			cnt=query.executeUpdate();
			return cnt;
		});
		return cnt1;
	}

	@Override
	public List<EmployeeHLO> delrecByLname(String lname1, String lname2, String lname3) {
		
		List<EmployeeHLO> hlo=null;
		hlo=(List<EmployeeHLO>)ht.findByNamedQueryAndNamedParam(QUERY_FOR_FETCH_BY_LASTNAME, new String[] {"lname1","lname2","lname3"},new String[] {lname1,lname2,lname3});
		return hlo;
	}

}
