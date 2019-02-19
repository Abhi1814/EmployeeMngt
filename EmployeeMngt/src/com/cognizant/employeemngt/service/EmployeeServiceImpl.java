package com.cognizant.employeemngt.service;

import java.util.List;

import com.cognizant.employeemngt.bean.Employee;
import com.cognizant.employeemngt.dao.EmployeeDAO;
import com.cognizant.employeemngt.dao.EmployeeDAOImpl;


public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(id, employee);
	}

	@Override
	public String deleteEmployee(String id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeesByName(name);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

}
