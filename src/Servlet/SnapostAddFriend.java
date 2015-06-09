package Servlet;

import Database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SnapostAddFriend")
public class SnapostAddFriend extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	
	public SnapostAddFriend() {
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

		response.setContentType("text/html");
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
		out.close();
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect("friend_check.jsp");
		String values = request.getParameter("input");
		String table = (String) request.getSession().getAttribute("name");
		String[] elements1 = {values};
		String[] property1 = {"MNAME"};
		String[] type1 = {"char"};
		String[] restraints1 = {"="};
		String table1 = "Member";
		ArrayList<String> result1 = new ArrayList<String>();
		if(Select.SelectElement(elements1, property1, table1, type1, restraints1, result1) <= 0)
		{
			request.getSession().setAttribute("wrongType","Username invalid!");
			request.getSession().setAttribute("back", "friend_check.jsp");
			response.sendRedirect("false.jsp");	
		}
		else{
			if(values.replaceAll(" ", "").equals(table.replaceAll(" ","")))
			{
				request.getSession().setAttribute("wrongType","You cannot add yourself!");
				request.getSession().setAttribute("back", "friend_check.jsp");
				response.sendRedirect("false.jsp");	
			}
			else
			{
				String[] elements = {values};
				String[] property = {"FRIEND"};
				String[] type = {"char"};
				String[] restraints = {"="};
				ArrayList<String> result = new ArrayList<String>();
				int count = Select.SelectElement(elements, property, table, type, restraints, result);	
				if(count > 0){
					//�����Ի��򣬡��Է��������ĺ��ѣ���������ӡ�
					request.getSession().setAttribute("wrongType","You have added him/her, and you cannot add again!");
					request.getSession().setAttribute("back", "friend_check.jsp");
					response.sendRedirect("false.jsp");		
				}
				else{
					Insert.InsertFriend(values, table);
					response.sendRedirect("friend_check.jsp");
					
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
					out.println("<HTML>");
					out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
					out.println("  <BODY>");
					out.print("    This is ");
					out.print(this.getClass());
					out.println(", using the POST method");
					out.println("name = " + values);
					out.println("table = " + table);
					out.println("  </BODY>");
					out.println("</HTML>");
					out.flush();
					out.close();
				}
			}
		}
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
