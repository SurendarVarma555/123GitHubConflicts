package com.vidvaan.service;

import java.util.List;

import com.vidvaan.dao.EmployeeDao;
import com.vidvaan.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeedao;

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	@Override
	public void addEmployee(Employee employee) {

		employeedao.createEmployee(employee);
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int eid) {
		employeedao.updateEmployeeEmailById(newEmail, eid);
	}

	@Override
	public void deleteEmployeeById(int eid) {
		
		
		employeedao.deleteEmployeeById(eid);
	}

	@Override
	public Employee fetchEmployeeById(int eid) {

		return employeedao.getEmployeeById(eid);
	}

	@Override
	public void getAllEmplyeesInfo() {
		employeedao.getAllEmplyeesDetails();
	}

}
