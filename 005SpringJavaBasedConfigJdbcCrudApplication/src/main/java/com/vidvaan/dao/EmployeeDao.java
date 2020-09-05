package com.vidvaan.dao;

import java.util.List;

import com.vidvaan.model.Employee;

public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);

	public abstract void updateEmployeeEmailById(String newEmail ,int eid);

	public abstract void deleteEmployeeById(int eid);

	public abstract Employee getEmployeeById(int eid);

	public abstract void  getAllEmplyeesDetails();  //Returns List of Employees

}
