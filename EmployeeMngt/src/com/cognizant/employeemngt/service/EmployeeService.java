package com.cognizant.employeemngt.service;

import com.cognizant.employeemngt.bean.Employee;
import java.util.List;

public interface EmployeeService {
	
	public String addEmployee(Employee employee);
	public String updateEmployee (String id, Employee employee);
	public String deleteEmployee(String id);
	public Employee getEmployee(String id);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getEmployees();

}
