package faceOfPic;
import java.awt.*;

import javax.swing.*;
public class Login extends JFrame{
		 JLabel lb1,lb2,lb3;
		 protected String ID,password;
		 JPanel p1,p2,p3,p4;
		 protected JTextField txtt1;
		 protected JPasswordField pwd;
		 protected JButton jbt1,jbt2; //登录和找回密码
		 
		 Container c;
		 JPanel imagePanel;
		 ImageIcon background;
		 /**
		  * 
		  */
		 public Login(){
			  super();
			  //标题
			  p1 = new JPanel();
			  lb1 = new JLabel("Welcome to Snapost!");
			  lb1.setFont(new Font("华文新魏",Font.BOLD,22));
			  p1.add(lb1);
			  //name
			  p2 = new JPanel();
			  lb2 = new JLabel("Name:");
			  lb2.setFont(new Font("华文新魏",Font.BOLD,18));
			  txtt1 = new JTextField(12);
			  txtt1.setFont(new Font("",Font.BOLD,18));
			  p2.add(lb2);
			  p2.add(txtt1);
			  //密码
			  p3 = new JPanel();
			  lb3 = new JLabel("Password:");
			  lb3.setFont(new Font("华文新魏",Font.BOLD,18));
			  pwd = new JPasswordField(12);
			  pwd.setFont(new Font("",Font.BOLD,18));
			  p3.add(lb3);
			  p3.add(pwd);
			  //登陆和找回密码
			  p4 = new JPanel();
			  jbt1 = new JButton("<html>"+"<font color=> Login </font>");
			  JRootPane rootPane = this.getRootPane();
			  rootPane.setDefaultButton(jbt1);
			  jbt2 = new JButton("<html>"+"<font color=> FindPassword </font>");
			  p4.add(jbt1);
			  p4.add(Box.createRigidArea(new Dimension(50,0)));
			  p4.add(jbt2);
			  
			  background = new ImageIcon("./src/image/back1.jpg");
			  JLabel label = new JLabel(background);
			  label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
			  imagePanel = (JPanel)this.getContentPane();
			  imagePanel.setOpaque(false);
			  imagePanel.setLayout(new GridLayout(0,1));
			  p1.setOpaque(false);
			  p2.setOpaque(false);
			  p3.setOpaque(false);
			  p4.setOpaque(false);
			  imagePanel.add(p1);
			  imagePanel.add(p2);
			  imagePanel.add(p3);
			  imagePanel.add(p4);
			  this.getLayeredPane().setLayout(null);
			  this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			  this.setSize(400,350);
			  this.setVisible(true);
			  this.setLocation(50,50);
			  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 }
		 /**
		 * 判断用户名输入合法性
		 */
		public boolean judgeID(){
			 if (txtt1.getText().length() == 0) {
			     JOptionPane.showOptionDialog(this, "用户名不能为空",
			                 "请重新输入", JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.ERROR_MESSAGE,
			                    null, null, null);
			     return false;}
			 return true;
		 }
		 /**
		 * 判断密码输入合法性
		 */
		public boolean judgePWD(){
			 if (pwd.getPassword().length== 0) {
			     JOptionPane.showOptionDialog(this, "密码不能为空",
			                 "请重新输入", JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.ERROR_MESSAGE,
			                    null, null, null);
			     return false;}
			 return true;
		 }
		 /**
		 * 密码发送成功
		 */
	    public void successAddr(){
			 JOptionPane.showMessageDialog(this,"请稍候，密码已发送至您的邮箱");
	    	
		 }
		 /**
		 * 显示登录成功
		 */
		public void successLogin(){
			//JOptionPane.showMessageDialog(this,"登陆成功");
			System.out.println(ID);
			Picture pic = new Picture();
			
	    	pic.ID = ID;
	    	System.out.println(pic.ID);
	    	pic.picture();
		 } 
		 /**
		 * 显示登录失败
		 */
		public void failLogin(){
		     JOptionPane.showOptionDialog(this, "登陆失败",
		                 null, JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.ERROR_MESSAGE,
		                    null, null, null);
	 } 
	
	}
