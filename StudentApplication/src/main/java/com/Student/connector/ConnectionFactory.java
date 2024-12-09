package com.Student.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
//	to call method in another class i.e DAO implementation class-it is made static
 public static Connection requestConnection() {
	 Connection con = null;
	 String url = "jdbc:mysql://localhost:3306/company";
	 String user = "root";
	 String password = "sahana1430#$";
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return con;
 }
 
}
