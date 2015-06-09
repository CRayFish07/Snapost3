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
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
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
		String friend = "∫√”—";
		Drop.DropTable(friend);
	}
}
