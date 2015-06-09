package faceOfPic;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;





public class FaceOfPic extends JFrame{
	
	protected String ID,password;//������õ�½/ע��������Ϣ
	protected String LoginID,Loginpassword;//��ʾ�Ѿ����ߵ��û���Ϣ
	protected String AbulmName;
	 Socket s = null;
	 DataOutputStream dos = null;
	 DataInputStream dis = null;//ͨ��Ԫ��
	 
	 private int live = 0;//0��δ��¼  	1���ѵ�½	
	 private boolean cont = false;//�̱߳�־
	
	protected JLabel Welcome ; 
	protected JPanel One ;
	protected JPanel Two ;
	
	protected TextField tfTxt = new TextField(10);
	protected JButton jbtSearch = new JButton("Search");
	protected JButton jbtLogin = new JButton("login");
	protected JButton jbtRegister = new JButton("register");
	protected JButton jbtFileChoose = new JButton("ChooseFile"); //���ڼ��ϡ�+���ķ���ͼƬ
	protected JButton jbtUploadPic = new JButton("Upload");//
	
	Container c;
	JPanel imagePanel;
	
	
	public FaceOfPic(){
		super();
		One = new JPanel();
		Welcome = new JLabel("Welcome to Snapost!");
		Welcome.setFont(new Font("������κ",Font.BOLD,22));
		One.add(Welcome);
		
		/*JRootPane rootPane1 = this.getRootPane();
		rootPane1.setDefaultButton(jbtLogin);
		JRootPane rootPane2 = this.getRootPane();
		 rootPane2.setDefaultButton(jbtRegister);*/
		Two = new JPanel();
		Two.add(jbtLogin);
		Two.add(jbtRegister);
		
		ImageIcon background = new ImageIcon("./src/image/back3.jpg");
		JLabel label = new JLabel(background);
	 	label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
	 	imagePanel = (JPanel)this.getContentPane();
	 	imagePanel.setOpaque(false);
	 	imagePanel.setLayout(new GridLayout(0,1));
	 	One.setOpaque(false);
	 	Two.setOpaque(false);
	 	imagePanel.add(One);
	 	imagePanel.add(Two);
	 	
	 	 this.getLayeredPane().setLayout(null);
		 this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		  this.setSize(400,350);
		  this.setVisible(true);
		  this.setLocation(50,50);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  
		//��¼��Ӧ
			jbtLogin.addActionListener(new ActionListener(){
			   	  public void actionPerformed(ActionEvent e){
			   		 
			   		  sendLogin();
			   		
			   	  }
			});
			
			//ע����Ӧ
			jbtRegister.addActionListener(new ActionListener(){
			   	  public void actionPerformed(ActionEvent e){
			   		  sendRegister();

			   	  }
			 }); 
	}
		
	/**
	 * ���͵�¼��Ϣ
	 */
	public void sendLogin(){
			this.setVisible(false);
			final Login login = new Login();
			login.jbt1.addActionListener(new ActionListener(){ 
			    public void actionPerformed(ActionEvent e){ 
				    if(login.judgeID()==false ||login.judgePWD()==false){
				    	
				    	return ;
				    }
								
				    else{
				    	
				  
					    ID = login.txtt1.getText();
					    password = new String(login.pwd.getPassword());
					    
					    login.ID = ID;
					    
					    login.successLogin();
					    
					/*   try { 
					   		 // live = 1;//
						   	    dos.writeUTF("12"+ID+"#"+password);//д�������
						   	    dos.flush(); 
					     } catch (IOException e1) {						   	  
						   	    e1.printStackTrace();
						 }  
					    */
					    login.dispose();//�˳���¼
				    }
			    }
			    
			});
	  
	}
	/**
	 * �����һ�������Ϣ
	 */
	public void sendAddr(){
		this.setVisible(false);
		final Login login = new Login();
		login.jbt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				login.successAddr();
				ID = login.txtt1.getText();
				/*try {
					dos.writeUTF("13"+ID);
					dos.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				login.dispose();
				//return;
			}
		});
		
	}
	/**
	 * ����ע����Ϣ
	 */
	public void sendRegister(){
		 this.setVisible(false);
		 final Register register = new Register();
		 register.jbt1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 if(register.judgeID() == false || register.judgePWD() == false ||register.judgeAddr() == false){
					 
					 return;
				 }
					 
				 else{
					 register.successRegister();
					 ID = register.txtt1.getText();
					 password = new String(register.pwd1.getPassword());
				/*	 try { 
				   		  	//live = 0;
					   	    dos.writeUTF("11"+ID+"#"+password);//д�������
					   	    dos.flush(); 
				     } catch (IOException e1) {						   	  
					   	    e1.printStackTrace();
					   	   } */
					 register.dispose(); 
				 }
			 }
		 });

	 }
	
	
 public static void main(String[] args) {
	  FaceOfPic f = new FaceOfPic();
}
}
