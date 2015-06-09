package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Delete;
import Database.Select;

//@WebServlet("/SnapostdeleteAlbum")
public class SnapostdeleteAlbum extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostdeleteAlbum() {
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
		String albumname = request.getParameter("globalalbumname");
		System.out.println("deleteAlbum albumname:"+albumname);
//		request.getSession().setAttribute("jsporservlet", "servlet");
		
		
		
		/*���ļ�����ɾ��ͼƬ*/
	    boolean flag = false;  
	    //File file = new File("../iPic/upload/"+photoname);  
        //upload�µ�ĳ���ļ���   �õ���ǰ���ߵ��û�  �ҵ���Ӧ���ļ���  
	    ServletContext sctx = getServletContext();  
        String path = sctx.getRealPath("upload");  
        //����ļ���  
        //����ͼƬ
		String[] elements1 = {username,albumname};
		String[] property1 = {"USERNAME","ALBUM_NAME"};
		String table1 = "PHOTO";
		String[] type1 = {"char","char"};
		String[] restraints1 = {"=","="};
		ArrayList<String> result = new ArrayList<String>();
		int count = Select.SelectElement(elements1, property1, table1, type1, restraints1, result);
		
		for(int i =4 ;i<result.size();i=i+count){
	        //�÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���  
			String pp = result.get(i).trim();
			System.out.println("pp:"+pp);
	        String photoname = pp.substring(pp.lastIndexOf("/")+1);  
	        File file = new File(path+"\\"+photoname);  
	        System.out.println("deletealbum photoname:"+photoname);
		    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		        flag = true;  
		    } 
		    
		    if(flag==true)
		    	System.out.println("delete the photo success");
			/*�����ݿ�ɾ��ͼƬ��¼*/
			String[] elements2 = {username,albumname,photoname};
			String[] property2 = {"USERNAME","ALBUM_NAME","PHOTO_NAME"};
			String table2 = "PHOTO";
			String[] type2 = {"char","char","char"};
			String[] restraints2 = {"=","=","="};
			Delete.DeleteElement(elements2, property2, table2, type2, restraints2);			
			
		}
		
		/*ɾ�����*/
		String[] elements = {username,albumname};
		String[] property = {"USERNAME","ALBUM_NAME"};
		String table = "ALBUM";
		String[] type = {"char","char"};
		String[] restraints = {"=","="};
		Delete.DeleteElement(elements, property, table, type, restraints);


		response.sendRedirect("album_check.jsp"); 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
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
