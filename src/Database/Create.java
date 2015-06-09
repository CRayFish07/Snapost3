package Database;

import java.sql.*;

public class Create 
{
	/*
	 * 
	 * API for creating table
	 * !!NEED!!	String name--tablename
	 * 
	 * driver = "com.mysql.jdbc.Driver";
	 * url = "jdbc:mysql://localhost:3306/snapost";
	 * user = "root";
	 * passwd = "";
	 * connect to sql through jdbc
	 * 
	 * **/
	public static int CreateTable(String name)
	{
		Connection con = null;
		
		Statement stmt = null;
		
		int rs = 0;
		
		/*
		 * default way to connect the database server
		 * connection!
		 * **/
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/snapost";
		
		String user = "root";
		
		String passwd = "";
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			//	System.out.println(driver);
			//	System.out.println(url);
			String create = "CREATE TABLE " + name +
							" (FRIEND CHAR(20));";
			System.out.println(create);
			//excute stmt
			rs = stmt.executeUpdate(create);
			//System.out.println(rs);
			System.out.println(rs);
			
			//close stmt
			if(stmt != null)
				stmt.close();
			//close con
			if(con != null)
				con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
   
	public static void main(String[] args) 
	{
		
		//change table here to create different tables
		String friend = "fri";
		
		//create table fri
		System.out.println(Create.CreateTable(friend));
	}
}
