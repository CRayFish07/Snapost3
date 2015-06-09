package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Drop
{
		
	/**
     * API for droping table
     * @param elements1/2 -- elements1 to be replaced by element2
     * @param String[] property1/2 -- respect property both
     * @param table	  -- certain table
     * @param type1/2	  -- type either belongs to
     * @param restraints -- restraints to be noticed
     * 
     * 
     * driver = "com.mysql.jdbc.Driver";
	 * url = "jdbc:mysql://localhost:3306/snapost";
	 * user = "root";
	 * passwd = "";
	 * connect to sql through jdbc
	 * 

     */


	public static void DropTable(String name)
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
			/*
			 * default way to connect the database server
			 * connection!
			 * **/

			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, passwd);
//			System.out.println(driver);
					//	System.out.println(url);

			stmt = con.createStatement();
			
			String drop = "DROP TABLE " + name;
			//excute stmt

			System.out.println(drop);
			rs = stmt.executeUpdate(drop);
			//System.out.println(rs);

			System.out.println(rs);
			//System.out.println("drop seccessfully!");

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
	}
   
	public static void main(String[] args) 
	{
		//change table here to drop tables
		String friend = "zhangsan";
		//drop table
		Drop.DropTable(friend);
	}
}
