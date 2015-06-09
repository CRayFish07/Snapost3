package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ImageProcess.Image;

//@WebServlet("/Snapostblack")
public class Snapostblack extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Snapostblack() {
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
	 * 
	 * 
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
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8"); 
		System.out.println("black");
		Image image  = new Image("look.jpg");
		//image.convertToBlackAndWhite();
		//image.affineTransform(0.5,0.0);
		//image.crop(image.getHeight()/5, image.getWidth()/5,4*image.getHeight()/5, 4*image.getWidth()/5);
		
		//image.flipHorizontally();
		//image.multiply(2,2);
		//image.rotate180();
		//image.rotateLeft();
		//image.rotateRight();
		
		image.saveAs("C://picture//result.jpg");
			
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 * 
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

	/**
	 *
	 * 	int x = 0;
   	while (x){
       	System.out.println("hello, world");
       	int y = x;
       	if (y > 1) int z;
       	else break;
       }
      *
	 */
	
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
