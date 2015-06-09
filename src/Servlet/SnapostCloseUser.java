package Servlet;

import Database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SnapostCloseUser")
public class SnapostCloseUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostCloseUser() {
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

		String username = request.getParameter("Username");
		String closetime = request.getParameter("closure_time");
		
		String name = "Administor";
		String title = "User " + username + " is closed for 1 " + closetime + "!";
		String content = "User " + username + " publishes some illegal or unsiutable pictures and we have warned him/her for 3 times. Close!!!";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
		String date=sdf.format(new Date());
		
		String[] values = new String[4];
		values[0]= name;
		values[1] = content;
		values[2] = title;
		values[3] = date;
		
		Insert.InsertAnnounce(values);
		
		String[]values2 = new String[3];
		values2[0] = username;
		values2[1] = closetime;
		values2[2] = date;
		Insert.InsertForbidden(values2);
		
		response.sendRedirect("ad_history.jsp");
		
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
	
	/**
	 *
	 * 	int x = 0;
   	while (x){
       	System.out.println("hello, world");
       	int y = x;
       	if (y > 1) int z;
       	else break;
       }
	 */
	
	
	/*	int x = 0;
	while (x){
    	System.out.println("hello, world");
    	int y = x;
    	if (y > 1) int z;
    	else break;
    }
 
private void refreshOnlineUserList(){
	
	
	try {//send
		toServer.writeUTF("qou" + currentUser.getName());
		toServer.flush();
		System.out.println("qou" + currentUser.getName());
		//recv
		String replyRefreshPackage = fromServer.readUTF();
		if(replyRefreshPackage.substring(0, 3).equalsIgnoreCase("rou")){
			System.out.println("Start fresh!");
			String [] temp = replyRefreshPackage.substring(3).split("\\^");
			System.out.println(replyRefreshPackage);
			//refresh
			defaultListModel.clear();
			for(int i = 0; i < temp.length; i++){
				defaultListModel.addElement(temp[i]);
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
*/

}
