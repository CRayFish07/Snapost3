package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Select;
import Database.Update;

//@WebServlet("/SnapostPassword")
public class SnapostPassword extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostPassword() {
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

		String[] values = new String[1];
		String old = request.getParameter("inputPassword2");
		values[0] = request.getParameter("inputPassword21");
				
		String[] property1 = {"MPASSWORD"};
		String t = "Member";
		String[] type1 = {"char"};
		String[] r = {"="};
		String[] elements2 = {request.getSession().getAttribute("name").toString()};
		String[] property2 = {"MNAME"};
		String[] type2 = {"char"};
		
		String[] elements = {request.getSession().getAttribute("name").toString()};
		String[] property = {"MNAME"};
		String table = "Member";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> result = new ArrayList<String>();
		@SuppressWarnings("unused")
		int count = Select.SelectElement(elements, property, table, type, restraints, result);	
		if(result.get(1).replaceAll(" ", "").equals(old) == false)
		{
			request.getSession().setAttribute("wrongType","Password Incorrect");
			request.getSession().setAttribute("back", "setting_password.jsp");
			response.sendRedirect("false.jsp");	
		}
		else
		{
			if(Update.UpdateElement(values, property1, type1, elements2, property2, type2, r, t) == 1)	//���и���
			{	
				request.getSession().setAttribute("wrongType", "Successfully reset your password. Please log in again!");
				request.getSession().setAttribute("back", "login_in.jsp");
				response.sendRedirect("false.jsp");		//���óɹ���ҳ����ת
			}
		}
		response.setContentType("text/html");
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
		out.close();
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
