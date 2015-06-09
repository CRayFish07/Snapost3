<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Database.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
 <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- To ensure proper rendering and touch zooming -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="IPIC welcome and sign in page.">
    <meta name="keywords" content="IIIC, welcome, sign in">
    <meta name="author" content="Wang huiyan, Song yiping, Si xuemin, Qi ke">

    <link rel="shortcut icon" href="http://getbootstrap.com/docs-assets/ico/favicon.png">

    <title>Welcome</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Documentation extras -->
    <link href="http://getbootstrap.com/assets/css/docs.min.css" rel="stylesheet">
    <!--[if lt IE 9]><script src="../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <link href="http://libs.baidu.com/fontawesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

  </head>

<body data-spy="scroll" data-target=".navbar-example">
<div class="container">
	<div class="row clearfix">
	<img src="title.png" width="100%" height="220px"/>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
			<%
				session = request.getSession(); 
				String name = (String)(session.getAttribute("name")); 
				String id = (String)(session.getAttribute("id"));
				String sex = (String)(session.getAttribute("sex"));
				String signature = (String)(session.getAttribute("signature"));
				if(sex.replaceAll(" ", "").equals("male")){
			 %>
				<img src="img/nan.jpg" class="img-rounded" width="150" height="150">
			<%	}
				else if(sex.replaceAll(" ", "").equals("female")) {%>
				<img src="img/nv.jpg" class="img-rounded" width="150" height="150">
			<%	} %>
			<h3>
				Name: <%=name %>
			</h3>
			<p>
				ID: <%=id %>
			</p>
			<p>
				Signature: <%=signature %>
			</p>
			<p></p>
			<p>
				<a class="btn" href="login_in.jsp">Logout »</a>
			</p>
		</div>
		
		<div class="col-md-8 column">
			<div class="tab-content">
				<div class="tab-pane active" id="panel-1">
			
			
						<% 
							session=request.getSession(); 
							String username = name;
							String albumname1 = "";
							if(((String)(session.getAttribute("jsporservlet"))).equals("jsp")==true){
// 								System.out.println("pic_list jsporservlet:"+(String)(session.getAttribute("jsporservlet")));
								albumname1 = request.getParameter("globalalbumname");
							}else{
// 								System.out.println("pic_list jsporservlet:"+(String)(session.getAttribute("jsporservlet")));
								albumname1 = (String)(session.getAttribute("globalalbumname"));
							}
							
							//String albumname1=(String)(session.getAttribute("globalalbumname")); 
// 							System.out.println("albumname1:"+albumname1);
// 							System.out.println("pic_list.jsp albumname:"+albumname1);
							String[] elements1 = {username,albumname1};
							String[] property1 = {"USERNAME","ALBUM_NAME"};
							String table1 = "PHOTO";
							String[] type1 = {"char","char"};
							String[] restraints1 = {"=","="};
							ArrayList<String> result1 = new ArrayList<String>();
							int count1 = Select.SelectElement(elements1, property1, table1, type1, restraints1, result1);
// 							System.out.println("pic_list.jsp count:"+count1);
							//System.out.println("count:"+count1); 
							int j = 0;
		
							for(;j<result1.size();j=j+count1){
								//String results[] = result.get(i).split(" ");
								//System.out.println(result.get(i));
			
			%>
			
			<div class="row"><% 
								for(int k = 0;k<3&&j<result1.size();k++,j=j+count1){
									
								
								String globalalbumname = result1.get(j+1).trim();
								String photocreatetime = result1.get(j+3).trim();
								String discription = result1.get(j+2) .trim();
								String photoname = result1.get(j+4).trim(); 
// 								System.out.println("pic_list photoname:"+photoname);
							%>
			
				<div class="col-md-4">
					<div class="thumbnail">

						
							<img alt="" src="../Snapost3/upload/<%=photoname%>"  width="190" height="160">
							<div class="caption">
<!-- 								<h4> -->
<!-- 									<%=photoname %> -->
<!-- 								</h4> -->
								<p>
									<%=discription %>
								</p>
								<p>
									<%request.getSession().setAttribute("jsporservlet", "jsp"); %>
 									<a class="btn" href="single_pic.jsp?globalalbumname=<%=albumname1%>&globalphotoname=<%=photoname%>&originphotoname=<%=photoname%>">
 										Process »
 									</a> 

								</p>
							</div>
						
					</div>
				</div>

					<%} %>
				</div>
				<%
					j = j-count1;
				} %>
				</div>
			</div>
		</div>
			
		
		
		<div class="col-md-2 column">
		<h3>
				Album_Pic Page
			</h3>
			 <a id="modal-820181" href="#modal-container-820181" role="button" class="btn btn-block btn-info btn-lg" data-toggle="modal">
			 Upload My Pic
			 </a>
			
			<div class="modal fade" id="modal-container-820181" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Upload My Pic
							</h4>
						</div>
						<div class="modal-body">
						<form action="SnapostnewUpload" enctype="multipart/form-data" method="post" role="form" name="add_picture">
							<div class="form-group">
								 <label >Choose the album</label>
								 <select name="albumlist" onchange="select()">
								 <%		
								 
									String[] elements = {name};
									String[] property = {"USERNAME"};
									String table = "ALBUM";
									String[] type = {"char"};
									String[] restraints = {"="};
									ArrayList<String> result = new ArrayList<String>();
									int count = Select.SelectElement(elements, property, table, type, restraints, result); 
									int i = 1;
									for(;i<result.size();i=i+5){
										//String results[] = result.get(i).split(" ");
										//System.out.println(result.get(i));
										
										  String albumname = result.get(i).trim();
										
										%>
										<option value ='<%=albumname%>'><%=albumname %></option>
										
									<%}%>
								</select>  
							</div>
							
							<div class="form-group">
								 <label for="exampleInputFile">Choose the picture to upload</label>
								 <input name="filename" type="file" id="exampleInputFile">
								<p class="help-block">
									only allow .jpg or .png
								</p>
							</div>
							<div class="form-group">
								<label for="exampleInputFile">Discription</label>
								<input type="text" class="form-control" name="discription" id="discription">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
					
				</div>
				
			</div>
			 	</div>
			 <a href="main_page2.jsp" class="btn btn-warning btn-block btn-lg" type="button">Back to Homepage</a>
		</div>
	</div>
</div>
 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="docs.min.js"></script>
</body>
</html>
