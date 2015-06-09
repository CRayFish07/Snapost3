package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Drop
{
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			String drop = "DROP TABLE " + name;
			System.out.println(drop);
			rs = stmt.executeUpdate(drop);
			
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
		String friend = "zhangsan";
		Drop.DropTable(friend);
	}
}
