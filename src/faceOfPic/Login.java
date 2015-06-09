package faceOfPic;
import java.awt.*;

import javax.swing.*;
public class Login extends JFrame{
		 JLabel lb1,lb2,lb3;
		 protected String ID,password;
		 JPanel p1,p2,p3,p4;
		 protected JTextField txtt1;
		 protected JPasswordField pwd;
		 protected JButton jbt1,jbt2; //��¼���һ�����
		 
		 Container c;
		 JPanel imagePanel;
		 ImageIcon background;
		 /**
		  * 
		  */
		 public Login(){
			  super();
			  //����
			  p1 = new JPanel();
			  lb1 = new JLabel("Welcome to Snapost!");
			  lb1.setFont(new Font("������κ",Font.BOLD,22));
			  p1.add(lb1);
			  //name
			  p2 = new JPanel();
			  lb2 = new JLabel("Name:");
			  lb2.setFont(new Font("������κ",Font.BOLD,18));
			  txtt1 = new JTextField(12);
			  txtt1.setFont(new Font("",Font.BOLD,18));
			  p2.add(lb2);
			  p2.add(txtt1);
			  //����
			  p3 = new JPanel();
			  lb3 = new JLabel("Password:");
			  lb3.setFont(new Font("������κ",Font.BOLD,18));
			  pwd = new JPasswordField(12);
			  pwd.setFont(new Font("",Font.BOLD,18));
			  p3.add(lb3);
			  p3.add(pwd);
			  //��½���һ�����
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
		 * �ж��û�������Ϸ���
		 */
		public boolean judgeID(){
			 if (txtt1.getText().length() == 0) {
			     JOptionPane.showOptionDialog(this, "�û�������Ϊ��",
			                 "����������", JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.ERROR_MESSAGE,
			                    null, null, null);
			     return false;}
			 return true;
		 }
		 /**
		 * �ж���������Ϸ���
		 */
		public boolean judgePWD(){
			 if (pwd.getPassword().length== 0) {
			     JOptionPane.showOptionDialog(this, "���벻��Ϊ��",
			                 "����������", JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.ERROR_MESSAGE,
			                    null, null, null);
			     return false;}
			 return true;
		 }
		 /**
		 * ���뷢�ͳɹ�
		 */
	    public void successAddr(){
			 JOptionPane.showMessageDialog(this,"���Ժ������ѷ�������������");
	    	
		 }
		 /**
		 * ��ʾ��¼�ɹ�
		 */
		public void successLogin(){
			//JOptionPane.showMessageDialog(this,"��½�ɹ�");
			System.out.println(ID);
			Picture pic = new Picture();
			
	    	pic.ID = ID;
	    	System.out.println(pic.ID);
	    	pic.picture();
		 } 
		 /**
		 * ��ʾ��¼ʧ��
		 */
		public void failLogin(){
		     JOptionPane.showOptionDialog(this, "��½ʧ��",
		                 null, JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.ERROR_MESSAGE,
		                    null, null, null);
	 } 
	
	}
