package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.*;

//@WebServlet("/SnapostsaveNewPic")
public class SnapostsaveNewPic extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostsaveNewPic() {
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
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8"); 
		String username = (String)(request.getSession().getAttribute("name"));
		String photoname = request.getParameter("globalphotoname");
		String albumname = request.getParameter("globalalbumname");
		
    	String []values = new String[5];
    	values[0] = username;
    	values[1] = albumname;
    	values[2] = "copy";

    	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	java.util.Date currTime = new java.util.Date();
    	String curTime = formatter.format(currTime);

    	values[3] = curTime;
    	values[4] = photoname;

    	
        //���ϴ�ͼƬ�����ּ�¼�����ݿ���  
    	Insert.InsertPhoto(values);
    	
       // item.write(file);  
   
        
        /*������*/
		String[] updateelements = {username,values[1]};
		String[] updateproperty = {"USERNAME","ALBUM_NAME"};
		String updatetable = "ALBUM";
		String[] updatetype = {"char","char"};
		String[] updaterestraints = {"=","="};
		ArrayList<String> updateresult = new ArrayList<String>();
		@SuppressWarnings("unused")
		int updatecount = Select.SelectElement(updateelements, updateproperty, updatetable, updatetype, updaterestraints, updateresult);
		int updatenum =  Integer.parseInt(updateresult.get(4).trim());
		updatenum = updatenum+1;

		String[] updatevalues = new String[1];
		updatevalues[0] = Integer.toString(updatenum);
		
		String[] property1 = {"id"};
		String t = "ALBUM";
		String[] type1 = { "int"};
		String[] r = {"=","="};
		String[] elements2 = {username,values[1].trim()};
		String[] property2 = {"USERNAME","ALBUM_NAME"};
		String[] type2 = {"char","char"};
		Update.UpdateElement(updatevalues, property1, type1, elements2, property2, type2, r, t);

    	request.getSession().setAttribute("globalalbumname",albumname);
//    	System.out.println("Upload albumname:"+values[1]);
    	request.getSession().setAttribute("globalphotoname", photoname);
//    	System.out.println("Upload photoname:"+fileName);
    	request.getSession().setAttribute("jsporservlet", "servlet");
		response.sendRedirect("pic_list.jsp");
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
