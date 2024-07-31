package com.jspider.jdbc_prepared_statement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class BookConnection 
{
	public static Connection getBookConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Successfully");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC-Full-Stack-Project","root","jaggi@74041313");
			System.out.println(connection);
			return connection;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection not Sucessfully");
			return null;
		}
	}
}
