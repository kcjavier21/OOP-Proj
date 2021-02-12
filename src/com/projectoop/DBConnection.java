package com.projectoop;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection databaseLink;
	
	public Connection getConnection() {
		//String databaseName = "oop";
		String databaseUser = "sql12392003";
		String databasePassword = "DLSFJSjgud";
		String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12392003";
		
		System.out.println("Nice!");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		System.out.println("DATABASE LINK: " + databaseLink);
		return databaseLink;
	}
}
