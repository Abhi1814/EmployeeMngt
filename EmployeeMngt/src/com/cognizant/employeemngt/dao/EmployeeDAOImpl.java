package com.cognizant.employeemngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.employeemngt.bean.Employee;
import com.cognizant.employeemngt.utils.dbuTILS;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection connection;

	public String addEmployee(Employee employee) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "insert into employee (id,firstname,lastname, salary)" + "values(?,?,?,?)";
		 connection = dbuTILS.getConnection();
		 try{
		 preparedStatement = connection.prepareStatement(insertStatement);
		 preparedStatement.setString(1,employee.getEmployeeId());
		 preparedStatement.setString(2,employee.getFirstName());
		 preparedStatement.setString(3, employee.getLastName());
		 preparedStatement.setFloat(4, employee.getSalary());
		 
		 int res = preparedStatement.executeUpdate();
		 return "success";
				 
		 } 
		 catch(SQLException e)
		 {
			 e.printStackTrace();
			 try{
				 connection.rollback();
			 }
			 catch(SQLException e1){
				 e1.printStackTrace();
			 }
			 return "fail";
		 }
		finally{
			
			dbuTILS.closeConnection(connection);
			
		}
	}

	public String updateEmployee(String id, Employee employee) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "update employee set id=?, lastname=?,salary=? where firstname=?";
		 connection = dbuTILS.getConnection();
		 try{
		 preparedStatement = connection.prepareStatement(insertStatement);
		 preparedStatement.setString(1,"765448");
		 preparedStatement.setString(2,"Dubey");
		 preparedStatement.setFloat(3,25000);
		 
		 preparedStatement.setString(4,"Rahul");
		 
		 int res = preparedStatement.executeUpdate();
		 return "success";
				 
		 } 
		 catch(SQLException e)
		 {
			 e.printStackTrace();
			 try{
				 connection.rollback();
			 }
			 catch(SQLException e1){
				 e1.printStackTrace();
			 }
			 return "fail";
		 }
		finally{
			
			dbuTILS.closeConnection(connection);
			
		}
	}

	public String deleteEmployee(String id) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "delete from employee where salary=?";
		 connection = dbuTILS.getConnection();
		 try{
		 preparedStatement = connection.prepareStatement(insertStatement);
		 
		 preparedStatement.setFloat(1,0);
		 
		 int res = preparedStatement.executeUpdate();
		 return "success";
				 
		 } 
		 catch(SQLException e)
		 {
			 e.printStackTrace();
			 try{
				 connection.rollback();
			 }
			 catch(SQLException e1){
				 e1.printStackTrace();
			 }
			 return "fail";
		 }
		finally{
			
			dbuTILS.closeConnection(connection);
			
		}
		
	}

	public Employee getEmployee(String id) {
		String query = "select * from employee where id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		ArrayList<Employee> employees = new ArrayList<>();
		try{
			connection = dbuTILS.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				float salary = resultSet.getFloat("salary");
				
				Employee employee = new Employee(id,firstname,lastname,salary);
				
				
				return employee;
			}
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally{
					
					dbuTILS.closeConnection(connection);
					
				}
		return null;
	}

	public List<Employee> getEmployeesByName(String name) {
		String query = "select * from employee where firstname=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		ArrayList<Employee> employees = new ArrayList<>();
		try{
			connection = dbuTILS.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,name);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				String id = resultSet.getString("id");
				String lastname = resultSet.getString("lastname");
				float salary = resultSet.getFloat("salary");
				
				Employee employee = new Employee(id,name,lastname,salary);
				
			employees.add(employee);
				
				
			}
			return employees;
			//return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally{
					
					dbuTILS.closeConnection(connection);
					
				}
		return null;
	}
	

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
