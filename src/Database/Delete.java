package Database;

import java.sql.*;

public class Delete 
{
	public static void DeleteElement(String[] elements, String[] property, String table, String[] type, String[] restraints)
	{
		/*
		 * 
		 * API for DeleteElement
		 * --------PARAMENTERS-------------------------------
		 * !!NEED!!	String[] elements -- elements to delete
		 * 			String[] property -- respect property
		 * 			String table	  -- certain table
		 * 			String[] type	  -- type that belongs to
		 * 			String[] restraints -- restraints to be noticed
		 * 
		 * 
		 * driver = "com.mysql.jdbc.Driver";
		 * url = "jdbc:mysql://localhost:3306/snapost";
		 * user = "root";
		 * passwd = "";
		 * connect to sql through jdbc
		 * 
		 * **/

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
			stmt = con.createStatement();
//			System.out.println(driver);
			//	System.out.println(url);

			for(int i = 0; i < elements.length; i++)
			{
				if(type[i].equals("char"))
					elements[i] = "'" + elements[i] + "'";
				System.out.println(elements[i]);
			}
			
			String condition = "";
			for(int i = 0; i < elements.length; i++)
				if(i != elements.length - 1)
					condition = condition + property[i] + restraints[i] + elements[i] + " AND ";
				else
					condition = condition + property[i] + restraints[i] + elements[i];
			
			//System.out.println(condition);
			String delete = "delete from " + table + " where " + condition;
			System.out.println(delete);
			//excute stmt
			rs = stmt.executeUpdate(delete);
			
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
	}
	
	public static void main(String[] args)
	{
		//change element name here to delete
		//notice the table/type/restraints
		String[] elements = {"zhangsan"};
		String[] property = {"MNAME"};
		String table = "Member";
		String[] type = {"char"};
		String[] restraints = {"="};
		
		//delete
		Delete.DeleteElement(elements, property, table, type, restraints);
	}
}
