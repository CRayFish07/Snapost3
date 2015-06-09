package Database;

import java.sql.*;

public class Create 
{
	public static int CreateTable(String name)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/snapost";
		String user = "root";
		String passwd = "";
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			String create = "CREATE TABLE " + name +
							" (FRIEND CHAR(20)  Primary Key(FRIEND));";
			System.out.println(create);
			rs = stmt.executeUpdate(create);
			
			System.out.println(rs);
			
			if(stmt != null)
				stmt.close();
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
		String friend = "fri";
		System.out.println(Create.CreateTable(friend));
	}
}
