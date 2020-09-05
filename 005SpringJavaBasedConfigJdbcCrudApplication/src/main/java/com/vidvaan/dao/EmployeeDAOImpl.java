package com.vidvaan.dao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vidvaan.model.Employee;

public class EmployeeDAOImpl implements EmployeeDao {

	private JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		String sql = "Select * from Employee where eid=?";
		Employee employee = jdbctemplate.queryForObject(sql, new EmployeeRowMapper(), eid);
		System.out.println("Employee ID: " + employee.getEid() + "   Name: " + employee.getEname() + " " + "   Salary: "
				+ employee.getEsalary() + " " + "   Mail:" + employee.getEmail());
		return employee;
	}

	@Override
	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO EMPLOYEE(eid,ename,esalary,email) VALUES(?,?,?,?)";
		int update = jdbctemplate.update(SQL,
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsalary(), employee.getEmail() });
		if (update > 0)
			System.out.println("Employee is Created:");

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int eid) {
		String SQL = "UPDATE Employee SET email=? WHERE eid=?";
		int rowUpdate = jdbctemplate.update(SQL, newEmail, eid);
		if (rowUpdate > 0)
			System.out.println("No.Of Employees Updated:  " + rowUpdate);
		System.out.println("Updated Employee Id:" + eid);
	}

	@Override
	public void deleteEmployeeById(int eid) {
		String SQL = "DELETE FROM Employee WHERE eid=?";
		int update = jdbctemplate.update(SQL, eid);
		if (update > 0)
			System.out.println("Employee is deleted..");
	}

	@Override
	public void getAllEmplyeesDetails() {
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> employees = (List<Employee>) jdbctemplate.query("select * from employee", rowMapper);
		 employees.forEach(allEmployeesIfo->System.out.println(allEmployeesIfo));
	}

}
