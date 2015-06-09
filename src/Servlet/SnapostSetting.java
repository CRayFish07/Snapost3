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

//@WebServlet("/SnapostSetting")
public class SnapostSetting extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostSetting() {
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

		doPost(request, response);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
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

		String[] values = new String[6];
		values[0] = request.getParameter("inputname2");
		values[1] = request.getParameter("inputPassword2");
		values[2] = request.getParameter("inputsex2");
		values[3] = request.getParameter("inputbirth2");
		values[3] = values[3].substring(0, 9);
		values[4] = request.getParameter("inputEmail2");
		values[5] = request.getParameter("inputSig2");
		
		String[] property1 = {"mname", "mpassword", "sex", "birthday", "email", "signature"};
		String t = "Member";
		String[] type1 = {"char", "char", "char", "char", "char", "char"};
		String[] r = {"="};
		String[] elements2 = {request.getSession().getAttribute("name").toString()};
		String[] property2 = {"mname"};
		String[] type2 = {"char"};
		
		String name2 = request.getParameter("inputname2");
		String[] elements = {name2};
		String[] property = {"mname"};
		String table = "Member";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> result = new ArrayList<String>();
		int count = 0;
		count = Select.SelectElement(elements, property, table, type, restraints, result);
		if(name2.equals(request.getSession().getAttribute("name")))
			count = 0;
		if(count > 0)
		{
			request.getSession().setAttribute("wrongType","This username is used by others. Please change another one");
			request.getSession().setAttribute("back", "setting.jsp");
			response.sendRedirect("false.jsp");	
		}
		else
		{
			if(Update.UpdateElement(values, property1, type1, elements2, property2, type2, r, t) == 1)	//���и���
			{	
				request.getSession().setAttribute("wrongType", "Successfully reset your personal information!");
				request.getSession().setAttribute("back", "main_page2.jsp");
				request.getSession().setAttribute("name", request.getParameter("inputname2"));
				request.getSession().setAttribute("signature", request.getParameter("inputSig2"));
				if(request.getParameter("inputsex2") == null)
					request.getSession().setAttribute("sex","unknown");
				else
					request.getSession().setAttribute("sex",request.getParameter("inputsex2"));
				response.sendRedirect("false.jsp");		//���óɹ���ҳ����ת
			}
			else
			{
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
				out.println("name = " + elements2[0]);
				out.println("name len = " + elements2[0].length());
				out.flush();
				out.close();
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
