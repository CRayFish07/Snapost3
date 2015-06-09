package Servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Delete;
import Database.Select;
import Database.Update;

//@WebServlet("/SnapostdeletePhoto")
public class SnapostdeletePhoto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostdeletePhoto() {
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
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8"); 
		String username = (String)(request.getSession().getAttribute("name"));
		String albumname = request.getParameter("galbumname");
		String photoname = request.getParameter("goriginphoto");
		//String originphoto = request.getParameter("goriginphoto");
		request.getSession().setAttribute("globalalbumname",albumname);
		//request.getSession().setAttribute("globalphotoname",photoname);
		request.getSession().setAttribute("jsporservlet", "servlet");
		System.out.println("deletePhoto albumname:"+albumname+" photoname:"+photoname);
		/*���ļ�����ɾ��ͼƬ*/
	    boolean flag = false;  
	    //File file = new File("../iPic/upload/"+photoname);  
        //upload�µ�ĳ���ļ���   �õ���ǰ���ߵ��û�  �ҵ���Ӧ���ļ���  
	    ServletContext sctx = getServletContext();  
        String path = sctx.getRealPath("upload");  
        //����ļ���  

        //�÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���  
        photoname = photoname.substring(photoname.lastIndexOf("/")+1);  
        File file = new File(path+"/"+photoname);  
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    } 
	    
	    if(flag==true)
	    	System.out.println("delete the photo success");
		/*�����ݿ�ɾ��ͼƬ��¼*/
		String[] elements = {username,albumname,photoname};
		String[] property = {"USERNAME","ALBUM_NAME","PIC_NAME"};
		String table = "PHOTO";
		String[] type = {"char","char","char"};
		String[] restraints = {"=","=","="};
		Delete.DeleteElement(elements, property, table, type, restraints);
		/*����������ݿ�*/
		String[] updateelements = {username,albumname};
		String[] updateproperty = {"USERNAME","ALBUM_NAME"};
		String updatetable = "ALBUM";
		String[] updatetype = {"char","char"};
		String[] updaterestraints = {"=","="};
		ArrayList<String> updateresult = new ArrayList<String>();
		@SuppressWarnings("unused")
		int updatecount = Select.SelectElement(updateelements, updateproperty, updatetable, updatetype, updaterestraints, updateresult);
		int updatenum =  Integer.parseInt(updateresult.get(4).trim());
		updatenum = updatenum-1;
		
		String[] updatevalues = new String[1];
		updatevalues[0] = Integer.toString(updatenum);
		
		String[] property1 = {"id"};
		String t = "ALBUM";
		String[] type1 = { "int"};
		String[] r = {"=","="};
		String[] elements2 = {username,albumname.trim()};
		String[] property2 = {"USERNAME","ALBUM_NAME"};
		String[] type2 = {"char","char"};
		Update.UpdateElement(updatevalues, property1, type1, elements2, property2, type2, r, t);
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
