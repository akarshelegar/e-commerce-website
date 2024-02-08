package com.shoppingcart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(con==null)
		{
			//Load Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart", "root", "7259");
			System.out.println("connected");
		}
		return con;
	}

}
