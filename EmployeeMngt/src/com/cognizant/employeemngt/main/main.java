package com.cognizant.employeemngt.main;

import java.util.List;

import com.cognizant.employeemngt.bean.Employee;
import com.cognizant.employeemngt.service.EmployeeService;
import com.cognizant.employeemngt.service.EmployeeServiceImpl;

public class main {

	public  static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		Employee employee  = new Employee(null, null, null, 0);
		String result = employeeService.addEmployee(employee);
		//System.out.println(employeeService.getEmployee("765355"));
		/*if("success".equals(result))
		{
			System.out.println("record added successfully");
		}
		else
		{
			System.out.println("not done");
		}*/
		
		String result1 = employeeService.updateEmployee(null, employee);
		String result2 = employeeService.deleteEmployee(null);
		Employee result3 = employeeService.getEmployee("765355");
	//	System.out.println("Id: "+ result3.getEmployeeId() +"First NAme: "+ result3.getFirstName());
		List<Employee> result4 = employeeService.getEmployeesByName("Rahul");
		List<Employee> result5 = employeeService.getEmployees();
		
		for(Employee e: result4){
			System.out.println("Id: "+ e.getEmployeeId() +"First NAme: "+ e.getFirstName());
		}
		for(Employee e: result5){
			System.out.println("Id: "+ e.getEmployeeId() +"First NAme: "+ e.getFirstName()+ "last Name : "+ e.getLastName() + "Salary : "+ e.getSalary()  );
		}
		
	}

}
