package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert 
{
	public static int InsertAlbum(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + "'" + values[4] + "'" +")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into ALBUM values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
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
	public static int InsertPhoto(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + "'" + values[4] + "'" +")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Photo values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
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
	public static int InsertMember(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
			{
				if(i < 6)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
				else
					value = value + values[i] +")";
			}
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Member values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
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
	
	public static int InsertAnnounce(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
			String value = "";
			for(int i = 0; i < 3; i++)
					value = value + "'" + values[i] + "',";
			value = value + "'" + values[3] + "')";

			System.out.println(value);
			
			String insert = "insert into Announce values(" + value;
			System.out.println(insert);
			
			rs = stmt.executeUpdate(insert);
			
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
	
	public static int InsertForbidden(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "',";		//对字符串操作进行处理
			value = value + "'" + values[1] + "',";
			value = value + "'" + values[2] + "')";
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Forbidden values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
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
	
	public static int InsertFriend(String values, String table)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			stmt = con.createStatement();
			String value = "";
			value = value + "'" + values + "')";

			System.out.println(value);
			
			String insert = "insert into " + table + " values(" + value;
			System.out.println(insert);
			
			rs = stmt.executeUpdate(insert);
			
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
	
	public static int InsertShare(String[] values)
	{
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try
		{
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=iPic", "sa", "qinke0704mayday");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 5)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + "'" + values[5] + "'" +")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Share values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
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
		String[] values = {"coco", "1", "233"};
		Insert.InsertAlbum(values);
	}
}
