package com.nt.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserHLO;

@Repository("loginDao")
public class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY=" select count(*) from UserHLO where user=:user and pwd=:pwd";
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int validate(UserHLO hlo) {
		int count=0;
		count=ht.execute(ses->{
			int cnt=0;
			Query query=ses.createQuery(AUTH_QUERY);
			query.setParameter("user", hlo.getUser());
			query.setParameter("pwd", hlo.getPwd());
			cnt=query.executeUpdate();
			return cnt;
		});
		return count;
	}

}
