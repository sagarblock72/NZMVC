package com.nt.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.bo.UserHLO;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistanceConfig {

	@Bean(name="localsesfact")
	public LocalSessionFactoryBean createLocalSessionfactroyBean() {
		LocalSessionFactoryBean bean=null;
		Properties prop=null;
		
		bean=new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(UserHLO.class);
		
		prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		bean.setHibernateProperties(prop);
		return bean;
	}
	
	@Bean(name="sesfact")
	public SessionFactory createsesFactory() {
		return createLocalSessionfactroyBean().getObject();
	}
	
	@Bean("ht")
	public HibernateTemplate createhibernateTemplete() {
		return new HibernateTemplate(createsesFactory());
	}
	
}
