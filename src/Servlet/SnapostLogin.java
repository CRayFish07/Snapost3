package Servlet;

import Database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SnapostSnapostLogin")
public class SnapostLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostLogin() {
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
		return;
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
		
		String name = request.getParameter("inputname1");
		String password = request.getParameter("inputPassword1");
		
		String[] elements2 = {name};
		String[] property2 = {"MNAME"};
		String table2 = "Forbidden";
		String[] type2 = {"char"};
		String[] restraints2 = {"="};
		ArrayList<String> result2 = new ArrayList<String>();
		//request.getSession().setAttribute("wrongType","You are fobidden!Cannot log in!");
		//response.sendRedirect("false.jsp");
		if(name.equals("admin") && password.equals("admin"))
		{
			response.sendRedirect("ad_mainpage.jsp");
		}
		else{
			if(Select.SelectElement(elements2, property2, table2, type2, restraints2, result2) > 0)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
				String date=sdf.format(new Date());
				String date2 = result2.get(2).replaceAll(" ", "");
				long days = 0;
				try {
					java.util.Date now = sdf.parse(date);
					java.util.Date close = sdf.parse(date2);
					long diff = now.getTime() - close.getTime();
					days = diff / (1000 * 60 * 60 * 24);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//request.getSession().setAttribute("wrongType","You are fobidden!Cannot log in!");
				//response.sendRedirect("main_page2.jsp");
				if(result2.get(1).replaceAll(" ", "").equals("day"))
				{
					if(days <= 1)
					{
						request.getSession().setAttribute("wrongType","You are fobidden!Cannot log in!");
						request.getSession().setAttribute("back", "login_in.jsp");
						response.sendRedirect("false.jsp");
					}
				}
				else if(result2.get(1).replaceAll(" ", "").equals("week"))
				{
					if(days <= 7)
					{
						request.getSession().setAttribute("wrongType","You are fobidden!Cannot log in!");
						request.getSession().setAttribute("back", "login_in.jsp");
						response.sendRedirect("false.jsp");
					}
				}
			}
			else
			{
				String[] elements = {name};
				String[] property = {"MNAME"};
				String table = "Member";
				String[] type = {"char"};
				String[] restraints = {"="};
				ArrayList<String> result = new ArrayList<String>();
				
				int count = Select.SelectElement(elements, property, table, type, restraints, result);	
				String passwd = null;
				
				if(count == 0 || result.size() == 0){
					request.getSession().setAttribute("wrongType","Username Wrong");
					request.getSession().setAttribute("back", "login_in.jsp");
					response.sendRedirect("false.jsp");		//�����û�������ȷ����ʾ
				}
				else{
					passwd = result.get(1).replaceAll(" ", "");
				
					if(!password.equals(passwd)) {
						request.getSession().setAttribute("wrongType","Password Wrong");
						request.getSession().setAttribute("back", "login_in.jsp");
						response.sendRedirect("false.jsp");		//�����������벻��ȷ����ʾ
					}
					else{
						request.getSession().setAttribute("name", name);
						request.getSession().setAttribute("id", result.get(6));
						request.getSession().setAttribute("signature", result.get(5));
						if(result.get(2).replaceAll(" ", "") == "")
							request.getSession().setAttribute("sex", "unknown");
						else
							request.getSession().setAttribute("sex", result.get(2));
						System.out.println(result.get(2));
						if(name.replaceAll(" ", "").equals("admin")){
							response.sendRedirect("ad_mainpage.jsp");
						}
						else{
							response.sendRedirect("main_page2.jsp");
						}
//							
//							if(Create.CreateTable(name) == 0)
//							{
//								response.sendRedirect("main_page2.jsp");
//								//RequestDispatcher dispatcher = request.getRequestDispatcher("main_page2.jsp");
//								//dispatcher.forward(request, response);
//							}
//							else
//							{
//								response.setContentType("text/html");
//								PrintWriter out = response.getWriter();
//								out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//								out.println("<HTML>");
//								out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//								out.println("  <BODY>");
//								out.print("    This is ");
//								out.print(this.getClass());
//								out.println(", using the POST method");
//								out.println("name = " + name);
//								out.println("  </BODY>");
//								out.println("</HTML>");
//								out.flush();
//								out.close();
//							}
//						}
					}
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
