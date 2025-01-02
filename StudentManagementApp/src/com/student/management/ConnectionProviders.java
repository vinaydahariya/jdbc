package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProviders {
	
	public static Connection con;
	
	public static Connection createConnection() {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create the connection..
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/simple-jdbc";
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
