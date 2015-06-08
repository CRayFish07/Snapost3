package Servlet;
import Database.*;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SnapostRegister")
public class SnapostRegister extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config)
	{
		try{
			super.init(config);
		}
		catch(ServletException se){
			se.printStackTrace();
		}
		
	}
	public void destroy(){
		super.destroy();
	}
	//�����û���Ϣ
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		@SuppressWarnings("unused")
		int count;
		String username = request.getParameter("logname");
		String usersex = request.getParameter("sex");
		String userpassword = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String userdescription = request.getParameter("message");
		String email = request.getParameter("email");
		String birth = request.getParameter("age");
		
		String[] values = new String[7];
		values[0] = username;
		values[1] = userpassword;
		values[2] = usersex;
		values[3] = birth;
		values[4] = email;
		values[5] = userdescription;
		values[6] = "1";
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		System.out.println(values[3]);
		System.out.println(values[4]);
		System.out.println(values[5]);
		System.out.println(values[6]);
		if(!(values[0].equals("") || values[1].equals("") || repassword.equals("")))
		{
			Insert.InsertMember(values);	
/*			if(Insert.InsertMember(values)){
				<jsp:forward page = "showRegisterMess.jsp"/>
			}
			else{
				<jsp:forward page = "false4.jsp"/>
			}*/
		}
		else
			System.out.println("fail to insert");
//		try{
//			u.insert(user);
//			request.getSession().setAttribute("userid",user.getUserID());
//			request.getSession().setAttribute("username",user.getUserName());
//			request.getSession().setAttribute("viplevel",user.getVIPLevel());
//			request.getSession().setAttribute("vippoint",user.getReputation());
//			request.getSession().setAttribute("balance",user.getBalance());
//			request.getSession().setAttribute("sex",user.getSex());
//			request.getSession().setAttribute("password",user.getUserpassword());
//			request.getSession().setAttribute("mail",user.getemailAddress());
//			request.getSession().setAttribute("tags",user.getUserdescription());
//			
//			int m = count.getUsersCount();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
			
		response.sendRedirect("MyJsp.jsp");    //��ת����ҳ��
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doPost(request,response);
	}
}