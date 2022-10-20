package com.blog.helper;
import java.sql.*;
public class ConnectionProvider {
	static Connection conn;
	public static Connection getConnection() {
		
		if(conn==null) {
			
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FullStackBlog","root","root");
		System.out.println("connected to database");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		return conn;
	}
}
