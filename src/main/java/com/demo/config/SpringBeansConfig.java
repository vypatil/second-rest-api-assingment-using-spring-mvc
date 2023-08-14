package com.demo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.demo")
public class SpringBeansConfig {
	
	
	public DriverManagerDataSource datasource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring-mvc-assingment");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setPackagesToScan("com.demo.entity");
		sessionFactory.setHibernateProperties(readHibernateProps());

		return sessionFactory;
	}	
	public Properties readHibernateProps() {
		
		Properties props= new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		return props;
		
		
	}

}
