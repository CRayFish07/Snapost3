package Database;

import java.sql.*;
import java.util.ArrayList;

public class Select
{
	public static int SelectAll(String table, ArrayList<String> selection)
	{
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
			String select = "select * from " + table;
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next())
			{
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			//return count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			count = -1;
		}
		return count;
	}

	public static int SelectElement(String[] elements, String[] property, 
			String table, String[] type, String[] restraints, ArrayList<String> selection)
	{	
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
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
				
			String select = "select * from " + table + " where " + condition;
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next())
			{
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			return count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public static int SelectAllTime(String table, ArrayList<String> selection)
	{
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
			String select = "select * from " + table + " order by PHOTO_NAME DESC";
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next())
			{
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			//return count;
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			count = -1;
		}
		return count;
	}
	public static void main(String[] args)
	{
		/*String[] elements = {"coco"};
		String[] property = {"USERNAME"};
		String table = "ALBUM";
		String[] type = {"char"};
		String[] restraints = {"="};*/
		ArrayList<String> selection = new ArrayList<String>();
		//int count = Select.SelectElement(elements, property, table, type, restraints, result);
/*		if(result != null)
		{
			for(int i = 0; i < result.size(); i++)
			{
				System.out.print(result.get(i) + " ");
				if((i + 1) % count == 0)
					System.out.println();
			}
		}*/
		Select.SelectAllTime("PHOTO", selection);
		//System.out.println("count:"+count+"  "+"result.size:"+result.size());
	}
}
