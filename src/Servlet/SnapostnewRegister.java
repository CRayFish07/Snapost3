package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Insert;

//@WebServlet("/SnapostnewRegister")
public class SnapostnewRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostnewRegister() {
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

		@SuppressWarnings("unused")
		int value;
		String username = request.getParameter("inputname2");
		String usersex = request.getParameter("inputsex2");
		String userpassword = request.getParameter("inputPassword2");
		String userdescription = request.getParameter("inputSig2");
		String email = request.getParameter("inputEmail2");
		String birth = request.getParameter("inputbirth2");
		
		String[] values = new String[7];
		values[0] = username;
		values[1] = userpassword;
		values[2] = usersex;
		values[3] = birth;
		values[4] = email;
		values[5] = userdescription;
		values[6] = "1";
		System.out.println("fyf"+values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		System.out.println(values[3]);
		System.out.println(values[4]);
		System.out.println(values[5]);
		System.out.println(values[6]);
		
		String[] elements = {username};
		String[] property = {"MNAME"};
		String table = "Member";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> result = new ArrayList<String>();
		int count = Database.Select.SelectElement(elements, property, table, type, restraints, result);	
		System.out.println("!!count = " + count);
		if(count > 0)
		{
			request.getSession().setAttribute("wrongType","This username is used by others. Please change another one");
			request.getSession().setAttribute("back", "login_in.jsp");
			response.sendRedirect("false.jsp");	
		}
		else
		{
			value = Insert.InsertMember(values);	
			//
			Database.Create.CreateTable(username);
			String[] elements1 = {username};
			System.out.println("username: " + elements1[0]);
			ArrayList<String> result1 = new ArrayList<String>();
			Database.Select.SelectElement(elements1, property, table, type, restraints, result1);
			System.out.println("result1size:"+result1.size());
			request.getSession().setAttribute("name", username);
			request.getSession().setAttribute("id", result1.get(6));
			request.getSession().setAttribute("signature", userdescription);
			if(usersex == null)
				request.getSession().setAttribute("sex","unknown");
			else
				request.getSession().setAttribute("sex",usersex);
			request.getSession().setAttribute("wrongType","Successfully register. Please log in!");
			request.getSession().setAttribute("back", "login_in.jsp");
			response.sendRedirect("false.jsp");	
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println("usersex = "+(usersex == null));
		out.println(values[0]);
		out.println(values[1]);
		out.println(values[2]);
		out.println(values[3]);
		out.println(values[4]);
//		out.println(value);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
//		response.sendRedirect("MyJsp.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("MyJsp.jsp");
//		dispatcher.forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		// Put your code here
			int n = 1;
	    	int index = n;
	    	int factor = 2;
	    	//System.out.print("The minimum factors of " + n + " is: ");
	    	while(factor <= index){
	    		if(index % factor == 0){
	    			index /= factor;
	    			//System.out.print(factor + " ");
	    		}
	    		else{
	    			factor ++;
	    		}
	    	}
	    	n = 1;
	    	index = n;
	    	factor = 2;
	    	//System.out.print("The minimum factors of " + n + " is: ");
	    	while(factor <= index){
	    		if(index % factor == 0){
	    			index /= factor;
	    			//System.out.print(factor + " ");
	    		}
	    		else{
	    			factor ++;
	    		}
	    	}
	    	n = 1;
	    	index = n;
	    	factor = 2;
	    	//System.out.print("The minimum factors of " + n + " is: ");
	    	while(factor <= index){
	    		if(index % factor == 0){
	    			index /= factor;
	    			//System.out.print(factor + " ");
	    		}
	    		else{
	    			factor ++;
	    		}
	    	}
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

}
