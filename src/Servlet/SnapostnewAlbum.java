package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Insert;
import Database.Select;

//@WebServlet("/SnapostnewAlbum")
@SuppressWarnings("serial")
public class SnapostnewAlbum extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SnapostnewAlbum() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
/*		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    @Override  
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");  
		String username = (String)(request.getSession().getAttribute("name"));
		String albumname = request.getParameter("albumname");
		System.out.println("albumname:"+albumname);
		String discription = request.getParameter("albumdiscription");
		System.out.println("discription:"+discription);
		String []values = new String[5];
		values[0] = username;
		values[1] = albumname;
		values[3] = discription;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	java.util.Date currTime = new java.util.Date();
    	String curTime = formatter.format(currTime);
    	values[2] = curTime;
    	values[4] = "0";
		//�鿴�Ƿ����������
		String[] elements = {username,albumname};
		String[] property = {"USERNAME","ALBUM_NAME"};
		String table = "ALBUM";
		String[] type = {"char","char"};
		String[] restraints = {"=","="};
		ArrayList<String> result = new ArrayList<String>();
		@SuppressWarnings("unused")
		int count = Select.SelectElement(elements, property, table, type, restraints, result);
		if(result.size()>0)
			System.out.println("renamed album!");
		else{
			Insert.InsertAlbum(values);
			response.sendRedirect("album_check.jsp");
		}
/*		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
