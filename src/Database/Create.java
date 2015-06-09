package Database;

import java.sql.*;

public class Create 
{
	public static int CreateTable(String name)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
			
			String create = "CREATE TABLE " + name +
							" (FRIEND CHAR(20) FOREIGN KEY REFERENCES Member(MNAME) " +
							"ON UPDATE CASCADE ON DELETE CASCADE, Constraint PK" + name + " Primary Key(FRIEND));";
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