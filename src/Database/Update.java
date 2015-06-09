package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update 
{
	public static int UpdateElement(String[] elements1, String[] property1, 
			String[] type1, String[] elements2, String[] property2, String[] type2, String[] restraints, String table)
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

			for(int i = 0; i < elements1.length; i++)
			{
				if(type1[i].equals("char"))
					elements1[i] = "'" + elements1[i] + "'";
				System.out.println(elements1[i]);
			}
			for(int i = 0; i < elements2.length; i++)
			{
				if(type2[i].equals("char"))
					elements2[i] = "'" + elements2[i] + "'";
				System.out.println(elements2[i]);
			}

			String condition1 = "";
			for(int i = 0; i < elements1.length; i++)
				if(i != elements1.length - 1)
					condition1 = condition1 + property1[i] + "=" + elements1[i] + " , ";
				else
					condition1 = condition1 + property1[i] + "=" + elements1[i];
			
			String condition2 = "";
			for(int i = 0; i < elements2.length; i++)
				if(i != elements2.length - 1)
					condition2 = condition2 + property2[i] + restraints[i] + elements2[i] + " AND ";
				else
					condition2 = condition2 + property2[i] + restraints[i] + elements2[i];
			
			String update = "update " + table + " set " + condition1 +  " where " + condition2;
			System.out.println(update);
			rs = stmt.executeUpdate(update);
			
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
		String[] values = new String[1];
		values[0] = "1";
		
		String[] property1 = {"id"};
		String t = "ALBUM";
		String[] type1 = { "int"};
		String[] r = {"=","="};
		String[] elements2 = {"coco","1"};
		String[] property2 = {"USERNAME","ALBUM_NAME"};
		String[] type2 = {"char","int"};
		System.out.println(Update.UpdateElement(values, property1, type1, elements2, property2, type2, r, t));
		
	}
}


