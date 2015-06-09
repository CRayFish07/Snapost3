package faceOfPic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Picture extends JFrame{
	public String ID;
	public String PicPath;
	public List pathList = new ArrayList();
	
	protected JPanel welcomePanel,choosePanel,PicPanel;
	protected JButton chooseButton,nextPicButton;
	
	protected JLabel welcomeLabel,chooseLabel,nextLabel,PicLabel;
	//protected JList listFunc = new JList(); //显示图片功能选项
	
	protected JFileChooser fDialog = new JFileChooser();
	BASE64Encoder encoder = new sun.misc.BASE64Encoder();//如果这里出现错误，百度这个包，添加一下就好了。
	BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	
	Container c;
	 JPanel imagePanel;
	 ImageIcon background;
	 protected int number = 0;  //技术
	 
	 protected JPopupMenu popupMenu;
	  
	  
	 public Picture(){
		 super();
		 PicPath = "./src/image/back4.jpg";
		 pathList.add(PicPath);
		 
		ImageIcon icon = new ImageIcon(PicPath);
		PicLabel = new JLabel();
		PicLabel.setIcon(icon);
	 }
	 
	public void picture(){
		//super();
		
		welcomeLabel = new JLabel("Welcome to Snapost, "+ID+"!");
		welcomeLabel.setFont(new Font("华文新魏",Font.BOLD,22));
		welcomePanel = new JPanel();
		welcomePanel.add(welcomeLabel,BorderLayout.CENTER);
		
		chooseButton = new JButton("AddPicture");
		nextPicButton = new JButton("NextPicture");
		choosePanel = new JPanel(); 
		choosePanel.add(chooseButton);
		choosePanel.add(nextPicButton);
		//welcomePanel.add(chooseButton,BorderLayout.SOUTH);
		//welcomePanel.add(nextPicButton,BorderLayout.SOUTH);
		
		
		PicPanel = new JPanel();
		PicPanel.add(PicLabel);
		PicPanel.setPreferredSize(new Dimension(500,500));
		
		background = new ImageIcon("./src/image/back1.jpg");
	   JLabel label = new JLabel(background);
	   label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
	   imagePanel = (JPanel)this.getContentPane();
	   imagePanel.setOpaque(false);
	   imagePanel.setLayout(new GridLayout(0,1));
		
	   welcomePanel.setOpaque(false);
	   choosePanel.setOpaque(false);
	   PicPanel.setOpaque(false);
	   
	   
	  imagePanel.add(welcomePanel,BorderLayout.NORTH);
	  imagePanel.add(PicPanel,BorderLayout.CENTER);
	  imagePanel.add(choosePanel,BorderLayout.SOUTH);
	   
	   pack();
	  this.getLayeredPane().setLayout(null);
	  this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	  this.setSize(500,450);
	  this.setVisible(true);
	  this.setLocation(50,50);
	  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  
	  chooseButton.addActionListener(new ActionListener(){
	   	  public void actionPerformed(ActionEvent e){
	   		  chooseFile();
	   		 //Two.add(lbPic,BorderLayout.NORTH);
	   	  }
	 }); 
	  nextPicButton.addActionListener(new ActionListener(){
	   	  public void actionPerformed(ActionEvent e){
	   		  //chooseFile();
	   		 //Two.add(lbPic,BorderLayout.NORTH);
	   		PicPath = (String)pathList.get(number);
	   		 ImageIcon icon = new ImageIcon(PicPath);
			
			PicLabel.setIcon(icon);
			number++;
			if(number == pathList.size())
				number = 0;
				
	   	  }
	 }); 
	  
	  
	  PicLabel.addMouseListener(new MouseAdapter() {
		   
		   @Override
		   public void mouseClicked(MouseEvent e) {
//		    maybeShowPopup(e);
		   }

		   @Override
		   public void mousePressed(MouseEvent e) {
			   System.out.println("1右键点击图片了");
			   showList(e);
		   }

		   @Override
		   public void mouseReleased(MouseEvent e) {
			   System.out.println("2右键点击图片了");
			   showList(e);
		   }
		   
		   	/**
		   	 * 显示功能list
			 * @param e
			 */
			private void showList(MouseEvent e){
				  setList();
				popupMenu.show(e.getComponent(),e.getX(), e.getY());
				
				 
			}
	  	});
	}
	
	/**
	 * 设置功能条目
	 */
	public void setList(){
		 popupMenu = new JPopupMenu("Function");
		 JMenuItem item1 = new JMenuItem("Delete");
		  popupMenu.add(item1); //添加菜单项Delete
		  item1.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendDelete();
		       }
		  });
  
		 JMenuItem item2 =  new JMenuItem("Beautify");
		  popupMenu.add(item2);
		  item2.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendBeautify();
		       }
		  });
		  
		  JMenuItem item3 = new JMenuItem("Download");
		  popupMenu.add(new JMenuItem("Download"));
		  item3.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendDownload();
		       }
		  });
		  
		  JMenuItem item4 = new JMenuItem("Like");
		  popupMenu.add(item4);
		  item4.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendLike();
		       }
		  });
		  
		  JMenuItem item5 = new JMenuItem("UnLike");
		  popupMenu.add(item5);
		  item5.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendUnLike();
		       }
		  });
		  
		  JMenuItem item6 = new JMenuItem("Comment");
		  popupMenu.add(item6);
		  item6.addMouseListener(new MouseAdapter(){
			   public void mouseReleased(MouseEvent e) {
				  sendComment();
		       }
		  });
		  
	
	}
	public void sendDelete(){
		 int option = JOptionPane.showConfirmDialog(null,
			       "是否删除该图片？", "删除图片？", JOptionPane.YES_NO_OPTION,
			       JOptionPane.WARNING_MESSAGE, null);
			   
				
		   switch (option) {
			     case JOptionPane.YES_NO_OPTION: {
			    	 JOptionPane.showMessageDialog(this,"该图片已删除");
			      break;
			     }
			     case JOptionPane.NO_OPTION:
			      System.exit(0);

			     }
	}
	
	public void sendBeautify(){
		 int option = JOptionPane.showConfirmDialog(null,
			       "是否美化该图片？", "美化图片？", JOptionPane.YES_NO_OPTION,
			       JOptionPane.WARNING_MESSAGE, null);
			   
				
		   switch (option) {
			     case JOptionPane.YES_NO_OPTION: {
			    	 JOptionPane.showMessageDialog(this,"该图片已美化");
			      break;
			     }
			     case JOptionPane.NO_OPTION:
			      System.exit(0);

			     }
	}
	
	public void sendDownload(){
		 int option = JOptionPane.showConfirmDialog(null,
			       "是否下载该图片？", "下载图片？", JOptionPane.YES_NO_OPTION,
			       JOptionPane.WARNING_MESSAGE, null);
			   
				
		   switch (option) {
			     case JOptionPane.YES_NO_OPTION: {
			    	 JOptionPane.showMessageDialog(this,"该图片已下载");
			      break;
			     }
			     case JOptionPane.NO_OPTION:
			      System.exit(0);

			     }
	}
	
	public void sendLike(){
		 int option = JOptionPane.showConfirmDialog(null,
			       "是否给该图片点赞？", "点赞图片？", JOptionPane.YES_NO_OPTION,
			       JOptionPane.WARNING_MESSAGE, null);
			   
				
		   switch (option) {
			     case JOptionPane.YES_NO_OPTION: {
			    	 JOptionPane.showMessageDialog(this,"该图片已点赞");
			      break;
			     }
			     case JOptionPane.NO_OPTION:
			      System.exit(0);

			     }
		
	}
	
	public void sendUnLike(){
		 int option = JOptionPane.showConfirmDialog(null,
			       "是否踩一踩该图片？", "踩图片？", JOptionPane.YES_NO_OPTION,
			       JOptionPane.WARNING_MESSAGE, null);
			   
				
		   switch (option) {
			     case JOptionPane.YES_NO_OPTION: {
			    	 JOptionPane.showMessageDialog(this,"该图片已踩");
			      break;
			     }
			     case JOptionPane.NO_OPTION:
			      System.exit(0);

			     }
	}
	
	public void sendComment(){
		 JOptionPane.showInputDialog(this, "please input your comment");
	}
	
	public void chooseFile(){
		  //设置文件选择框的标题 
				fDialog.setDialogTitle("请选择图片文件");
				FileNameExtensionFilter filter=new FileNameExtensionFilter
			            ("JPG  Images", "jpg");
				fDialog.setFileFilter(filter);
				//弹出选择框
				int returnVal = fDialog.showOpenDialog(null);
				// 如果是选择了文件
				if(JFileChooser.APPROVE_OPTION == returnVal){
				       //打印出文件的路径，你可以修改位 把路径值 写到 textField 中
					System.out.println(fDialog.getSelectedFile().getName());
					PicPath = fDialog.getSelectedFile().getAbsolutePath();
					pathList.add(PicPath);
					
					ImageIcon icon = new ImageIcon(PicPath);
					//PicLabel = new JLabel();
					PicLabel.setIcon(icon);
					
				}
	}
	/**
	 * 把图片转成二进制
	 * @return二进制的值
	 */
	public String getImageBinary(){
		File f = new File(PicPath);
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);
			byte[] bytes = baos.toByteArray();
			
			return encoder.encodeBuffer(bytes).trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param base64String
	 * 二进制转成图片
	 */
	public void base64StringToImage(String base64String){
		try {
			byte[] bytes1 = decoder.decodeBuffer(base64String);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
			BufferedImage bi1 = ImageIO.read(bais);
			String name = fDialog.getSelectedFile().getName();
			File w2 = new File("./src/image"+name+".jpg"); //图片地址
			ImageIO.write(bi1, "jpg", w2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
