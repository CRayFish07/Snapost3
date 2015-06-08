package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Database.Insert;
import Database.Select;
import Database.Update;
//@WebServlet("/SnapostnewUpload")
public class SnapostnewUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public SnapostnewUpload() {
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
    	//System.out.println("newUpload");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");  
        //Ϊ�������ṩ������Ϣ  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //�����������ʵ��  
        ServletFileUpload sfu = new ServletFileUpload(factory);  
        //��ʼ����  
        
        sfu.setFileSizeMax(1024*1024);  
        //ÿ�����������ݻ��װ��һ����Ӧ��FileItem������  
        try {  
            List<FileItem> items = sfu.parseRequest(request);  
            //���ֱ���  
//            System.out.println(items.size());
            for (int i = 0; i < items.size(); i++) {  
                FileItem item = items.get(i);  
//                System.out.println("i="+i);
                //isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ�����  
//                System.out.println(item.getFieldName());
                if(!item.isFormField()){  
//                	System.out.println("item.isFormField=false");
                    ServletContext sctx = getServletContext();  
                    //��ô���ļ�������·��  
                    //upload�µ�ĳ���ļ���   �õ���ǰ���ߵ��û�  �ҵ���Ӧ���ļ���  
                      
                    String path = sctx.getRealPath("upload");  
//                    System.out.println(path);  
                    //����ļ���  
                    String fileName = item.getName();  
                    System.out.println(fileName);  
                    //�÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���  
                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
                    File file = new File(path+"\\"+fileName);  
                    if(file.length()>1024*1024){
                    	response.sendRedirect("sizefalse.jsp");
                    }
                    
//                    System.out.println(file.getPath());
                   // if(!file.exists()){  
                    	request.getSession().setAttribute("photoPath",fileName);
                    	if((fileName.split("\\."))[1].equals("jpg")==false&&(fileName.split("\\."))[1].equals("png")==false){
                    		file.delete();
                    		response.sendRedirect("false1.jsp");
                    	}else{
                    	item.write(file); 
                    	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    	java.util.Date currTime = new java.util.Date();
                    	String curTime = formatter.format(currTime);
                       	String []suffix = fileName.split("\\.");
                       	String cc = curTime.replace(" ", "");
                       	String tt = cc.replace(":", "");
                       	tt = tt.replace("-", "");
                    	fileName = tt+"."+suffix[1];
 
                    	if(file.exists()){
                    		file.renameTo(new File(path+"\\"+fileName));
                    		
                    	}
                    	String username = (String)(request.getSession().getAttribute("name"));
                    	String []values = new String[5];
                    	values[0] = username;

                    	if(items.get(0).getFieldName().equals("filename")){
                    		response.sendRedirect("albumfalse.jsp");                    	
                    	}else{
                    	values[1] = items.get(0).getString("GBK");
//                    	System.out.println("albumname:"+values[1]);
                    	//values[1] = "1";
                    	values[2] = items.get(2).getString("GBK");



                    	values[3] = curTime;
                    	values[4] = fileName;
//                    	System.out.println(curTime);
                    	request.getSession().setAttribute("globalalbumname",values[1]);

//                    	System.out.println("Upload albumname:"+values[1]);
                    	request.getSession().setAttribute("globalphotoname", fileName);
//                    	System.out.println("Upload photoname:"+fileName);
                    	request.getSession().setAttribute("jsporservlet", "servlet");
                    	
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
                		
                		String[] property1 = {"NUMBER"};
                		String t = "ALBUM";
                		String[] type1 = { "int"};
                		String[] r = {"=","="};
                		String[] elements2 = {username,values[1].trim()};
                		String[] property2 = {"USERNAME","ALBUM_NAME"};
                		String[] type2 = {"char","char"};
                		Update.UpdateElement(updatevalues, property1, type1, elements2, property2, type2, r, t);

                    	response.sendRedirect("pic_list.jsp");  
                    	}
                    	}
                   // } 
                    //response.sendRedirect("album_check.jsp");  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 

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
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
