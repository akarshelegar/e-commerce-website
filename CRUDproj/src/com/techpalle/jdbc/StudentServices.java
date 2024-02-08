package com.techpalle.jdbc;
import java.sql.*;

public class StudentServices {
	
	private static Connection cn = null;
	private static Statement stm = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static Connection myConnection() throws ClassNotFoundException, SQLException {

			//step1: Load Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2: Establish the Connection
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "7259");
			
			return cn;
	}
	
	public static void creating() {
		try {
			cn = myConnection();
			stm = cn.createStatement();
			stm.executeUpdate("create table Student(sno int primary key auto_increment, sname varchar(50), sub varchar(50), email varchar(50) unique)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(stm!=null)
		{
			try {
			stm.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cn!=null)
		{
			try {
				cn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
}
}
	public static void inserting(String sname, String sub, String email)
	{
		try {
			cn = myConnection();
			ps= cn.prepareStatement("insert into Student(sname, sub, email) values(?, ?, ?)");
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(ps!=null)
		{
			try {
			ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cn!=null)
		{
			try {
				cn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
}
}
	public static void delete(int sno)
	{
		try {
			cn = myConnection();
			ps= cn.prepareStatement("delete from Student where sno = ?");
			ps.setInt(1, sno);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(ps!=null)
		{
			try {
			ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cn!=null)
		{
			try {
				cn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
}
	}
	public static void Update(int sno, String sname, String email)
	{
		try {
			cn = myConnection();
			ps= cn.prepareStatement("update Student set sno=?, sname=?, email=?");
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(ps!=null)
		{
			try {
			ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cn!=null)
		{
			try {
				cn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
}
	}
	public static void read() {
		try {
			cn = myConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from Student");
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(stm!=null)
		{
			try {
			stm.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cn!=null)
		{
			try {
				cn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
}
	}
}

