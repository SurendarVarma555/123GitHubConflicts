package com.vidvaan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vidvaan.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEid(rs.getInt("eid"));
		employee.setEname(rs.getString("ename"));
		employee.setEsalary(rs.getInt("esalary"));
		employee.setEmail(rs.getString("email"));

		return employee;
	}

}
