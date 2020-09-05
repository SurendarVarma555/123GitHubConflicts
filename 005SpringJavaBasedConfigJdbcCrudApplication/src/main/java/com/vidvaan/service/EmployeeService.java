package com.vidvaan.service;

import java.util.List;

import com.vidvaan.model.Employee;

public interface EmployeeService {
	public abstract void addEmployee(Employee employee);

	public abstract void updateEmployeeEmailById(String newEmail ,int eid);

	public abstract void deleteEmployeeById(int eid);

	public abstract Employee fetchEmployeeById(int eid);

	public abstract void getAllEmplyeesInfo();


}
