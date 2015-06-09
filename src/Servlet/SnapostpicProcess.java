package Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ImageProcess.Image;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/SnapostpicProcess")
public class SnapostpicProcess extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SnapostpicProcess() {
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
        //Ϊ�������ṩ������Ϣ  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //�����������ʵ��  
        ServletFileUpload sfu = new ServletFileUpload(factory);  
        //��ʼ����  
        sfu.setFileSizeMax(1600*1600);  
        //ÿ�����������ݻ��װ��һ����Ӧ��FileItem������  
          

        ServletContext sctx = getServletContext();  
            //��ô���ļ�������·��  
            //upload�µ�ĳ���ļ���   �õ���ǰ���ߵ��û�  �ҵ���Ӧ���ļ���  
            String path = sctx.getRealPath("upload");  
            //����ļ���  

            String albumname = request.getParameter("globalalbumname");
            String originphotoname = request.getParameter("originphotoname");
            System.out.println("origin:"+originphotoname);
            String picnum = request.getParameter("picNum");
            
            String photopath = path+"/"+originphotoname;

        	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	java.util.Date currTime = new java.util.Date();
        	String curTime = formatter.format(currTime);
        	String newphotoname = "";
        	Image image  = new Image(photopath);
            if(picnum.equals("1")){//�ڰ�       		
        		image.convertToBlackAndWhite();            	      		            	
            }else if(picnum.equals("2")){//��б
        		image.affineTransform(0.5,0.0);          	
            }else if(picnum.equals("3")){//ȡ����
        		image.crop(image.getWidth()/5, image.getHeight()/5,4*image.getWidth()/5, 4*image.getHeight()/5);           	
            }else if(picnum.equals("4")){//����
        		image.flipHorizontally();         	
            }else if(picnum.equals("5")){//����ͼ
            	image.multiply(2, 2);
            }else if(picnum.equals("6")){//��ת ��
            	image.rotateLeft();
            }else if(picnum.equals("7")){//��ת ��
            	image.rotateRight();
            }
            newphotoname = curTime+"."+originphotoname.split("\\.")[1];
            newphotoname = newphotoname.replace("-", "");
            newphotoname = newphotoname.replace(" ", "");
            newphotoname = newphotoname.replace(":", "");
            System.out.println("newphotoname:"+newphotoname);
            image.saveAs(path+"/"+newphotoname);
        	request.getSession().setAttribute("globalalbumname",albumname);
        	request.getSession().setAttribute("globalphotoname",newphotoname);
        	request.getSession().setAttribute("originphotoname",originphotoname);
        	request.getSession().setAttribute("jsporservlet", "servlet");
        	response.sendRedirect("single_pic.jsp");

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
