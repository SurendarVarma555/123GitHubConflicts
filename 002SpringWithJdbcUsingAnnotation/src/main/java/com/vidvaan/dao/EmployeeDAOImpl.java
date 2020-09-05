package com.vidvaan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vidvaan.model.Employee;

@Repository("employeedao")
public class EmployeeDAOImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		String sql = "Select * from Employee where eid=?";
		Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), eid);
		System.out.println("Employee ID: " + employee.getEid() + "   Name: " + employee.getEname() + " " + "   Salary: "
				+ employee.getEsalary() + " " + "   Mail:" + employee.getEmail());
		return employee;
	}

	@Override
	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO EMPLOYEE(eid,ename,esalary,email) VALUES(?,?,?,?)";
		int update = jdbcTemplate.update(SQL,
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsalary(), employee.getEmail() });
		if (update > 0)
			System.out.println("Employee is Created:");

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int eid) {
		String SQL = "UPDATE Employee SET email=? WHERE eid=?";
		int rowUpdate = jdbcTemplate.update(SQL, newEmail, eid);
		if (rowUpdate > 0)
			System.out.println("No.Of Employees Updated:  " + rowUpdate);
		System.out.println("Updated Employee Id:" + eid);
	}

	@Override
	public void deleteEmployeeById(int eid) {
		String SQL = "DELETE FROM Employee WHERE eid=?";
		int update = jdbcTemplate.update(SQL, eid);
		if (update > 0)
			System.out.println("Employee is deleted..");
	}

	@Override
	public void getAllEmplyeesDetails() {
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> employees = (List<Employee>) jdbcTemplate.query("select * from employee", rowMapper);
		employees.forEach(allEmployeesIfo -> System.out.println(allEmployeesIfo));
	}

}
