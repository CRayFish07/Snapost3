package faceOfPic;
import java.awt.*;

import javax.swing.*;
public class Register extends JFrame{
	 JLabel lb1,lb2,lb3,lb4,lbAddr;
	 protected String ID,password;
	 JPanel p1,p2,p3,p4,p5,pAddr;
	 protected JTextField txtt1,txtAddr;
	 protected JPasswordField pwd1,pwd2;
	 protected JButton jbt1,jbt2;
	 
	 Container c;
	 JPanel imagePanel;
	 ImageIcon background;
	 /**
	  * 
	  */
	 public Register(){
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
		  pwd1 = new JPasswordField(12);
		  pwd1.setFont(new Font("",Font.BOLD,18));
		  p3.add(lb3);
		  p3.add(pwd1);
		  //确认密码
		  p4 = new JPanel();
		  lb4 = new JLabel("Repeat:");
		  lb4.setFont(new Font("华文新魏",Font.BOLD,18));
		  pwd2 = new JPasswordField(12);
		  pwd2.setFont(new Font("",Font.BOLD,18));
		  p4.add(lb4);
		  p4.add(pwd2);
		  //邮箱
		  pAddr = new JPanel();
		  lbAddr = new JLabel("Address:");
		  lbAddr.setFont(new Font("华文新魏",Font.BOLD,18));
		  txtAddr = new JTextField(12);
		  txtAddr.setFont(new Font("",Font.BOLD,18));
		  pAddr.add(lbAddr);
		  pAddr.add(txtAddr);
		  //注册
		  p5 = new JPanel();
		  jbt1 = new JButton("<html>"+"<font color=> Register </font>");
		  JRootPane rootPane = this.getRootPane();
		  rootPane.setDefaultButton(jbt1);
		  //jbt2 = new JButton("<html>"+"<font color=> FindPassword </font>");
		  p5.add(jbt1);
		  p5.add(Box.createRigidArea(new Dimension(50,0)));
		  //p5.add(jbt2);
		  
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
		  pAddr.setOpaque(false);
		  p5.setOpaque(false);
		  imagePanel.add(p1);
		  imagePanel.add(p2);
		  imagePanel.add(p3);
		  imagePanel.add(p4);
		  imagePanel.add(pAddr);
		  imagePanel.add(p5);
		  this.getLayeredPane().setLayout(null);
		  this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		  this.setSize(400,350);
		  this.setVisible(true);
		  this.setLocation(50,50);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 }
	 /**
	 * 判断注册用户名输入合法性
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
	 * 判断注册密码输入合法性
	 */
	public boolean judgePWD(){
		 if (pwd1.getPassword().length == 0||pwd2.getPassword().length == 0) {
		     JOptionPane.showOptionDialog(this, "密码不能为空",
		                 "请重新输入", JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.ERROR_MESSAGE,
		                    null, null, null);
		     return false;}
		 else if(!(new String(pwd1.getPassword())).equals((new String(pwd2.getPassword())))){
			 JOptionPane.showOptionDialog(this, "密码不一致",
	                 "请重新输入", JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.ERROR_MESSAGE,
	                    null, null, null);
	     return false;
		 }
		 return true;
	 }
	public boolean judgeAddr(){
		 if (txtAddr.getText().length() == 0) {
		     JOptionPane.showOptionDialog(this, "邮箱地址不能为空",
		                 "请重新输入", JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.ERROR_MESSAGE,
		                    null, null, null);
		     return false;}
		 return true;
	 }
	 
	 public void successRegister(){
		 JOptionPane.showMessageDialog(this,"注册成功");
	 } 
	 public void failRegister(){
	     JOptionPane.showOptionDialog(this, "注册失败",
	                 null, JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.ERROR_MESSAGE,
	                    null, null, null);
	 } 

}

