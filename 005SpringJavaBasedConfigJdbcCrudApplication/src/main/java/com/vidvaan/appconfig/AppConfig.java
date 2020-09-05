package com.vidvaan.appconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vidvaan.dao.EmployeeDAOImpl;
import com.vidvaan.dao.EmployeeDao;
import com.vidvaan.service.EmployeeService;
import com.vidvaan.service.EmployeeServiceImpl;

@Configuration
public class AppConfig {
	@Bean(name = { "ds" })
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("java_files");
		ds.setPassword("suri");

		return ds;

	}

	@Bean(name = { "jdbaTemplate" })
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		;
		return jdbcTemplate;
	}

	@Bean(name = { "employeedao" })
	public EmployeeDao getEmployeeDAOImpl() {
		EmployeeDAOImpl employeedao = new EmployeeDAOImpl();
		employeedao.setJdbctemplate(getJdbcTemplate());

		return employeedao;
	}

	@Bean(name = { "employeeservice" })
	public EmployeeService getEmployeeServiceImpl() {

		EmployeeServiceImpl employeeservice = new EmployeeServiceImpl();
		employeeservice.setEmployeedao(getEmployeeDAOImpl());

		return employeeservice;

	}

}
