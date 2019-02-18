package com.cognizant.employeemngt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbuTILS {
	
	public final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public static final String driverName ="oracle.jdbc.driver.OracleDriver";
	public static final String userName="GOODJOB";
	public static final String password="root";
	
	public static Connection getConnection() {
		Connection connection = null;
		try{
			
		Class.forName(driverName);
		connection = DriverManager.getConnection(URL, userName, password);
		return connection;
		
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void closeConnection (Connection connection) {
		
	}

}
