<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Database.*" %>
<%@ page import="Servlet.*" %>
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
			<div class="row clearfix">
				<div class="col-md-10 column">
				  	 <% session=request.getSession(); 
				  	 	String albumname = "";
				  	 	String photoname = "";
				  	 	String originphotoname = "";
				  	 	String tempname = "";

				  	 		
// 						String filesrc=(String)(session.getAttribute("photoPath")); 
						if(((String)(session.getAttribute("jsporservlet"))).equals("jsp")==true){
							albumname = request.getParameter("globalalbumname"); 
							photoname = request.getParameter("globalphotoname");
							originphotoname = request.getParameter("originphotoname");  						
						}else{
							albumname = (String)(session.getAttribute("globalalbumname")); 
							photoname = (String)(session.getAttribute("globalphotoname")); 
							originphotoname = (String)(session.getAttribute("originphotoname"));  
						}
						
 						System.out.println("single_pic originphotoname:"+originphotoname);
     				 %>
					<img  width="600px" src="..\iPic\upload\<%=photoname%>" class="img-thumbnail" align="left" height="600px"/>
				</div>
				<div class="col-md-2 column">
					 <a href="./picProcess?picNum=<%="1" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-info btn-sm" type="button">BlackAndWhite</a>
					 <a href="./picProcess?picNum=<%="2" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-warning btn-sm " type="button">Slope</a> 
					 <a href="./picProcess?picNum=<%="3" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-sm btn-success" type="button">Center</a>
					 <a href="./picProcess?picNum=<%="4" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-danger btn-sm " type="button">Image</a>
					 
					 <a href="./picProcess?picNum=<%="5" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-warning btn-sm " type="button">Diagram</a> 
					 <a href="./picProcess?picNum=<%="6" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-sm btn-success" type="button">RotateLeft</a>
					 <a href="./picProcess?picNum=<%="7" %>&globalalbumname=<%=albumname %>&originphotoname=<%=originphotoname %>" class="btn btn-danger btn-sm " type="button">RotateRight</a>
				
				</div>
			</div>
		</div>
		<div class="col-md-2 column">
			<h3>
				Pic Page
			</h3>
<!-- 			 <a id="modal-820181" href="#modal-container-820181" role="button" class="btn btn-block btn-info btn-lg" data-toggle="modal"> -->
<!-- 			 Upload My Pic -->
<!-- 			 </a> -->
			
			
			 <a  class="btn btn-warning btn-block btn-lg" type="button" onClick = "return check();">Back to Homepage</a>
<!-- 			<br><br><br>		 -->
			<head>
				<script type="text/javascript">
				var txt=""
				function check()
				{
					try
   					{
   						adddlert("Are you sure to leave without saving?")
   					}
					catch(err)
   					{
     				/*	txt+="点击“确定”继续查看本页，\n"
					     txt+="点击“取消”返回首页。\n\n"*/
					     txt="Are you sure to leave without saving?\n\n"
					     
					     if(confirm(txt))
					     {
					         document.location.href="main_page2.jsp"
					     }
					}
				}
				</script>
			</head>			

			
 			<a href="./saveNewPic?globalalbumname=<%=albumname %>&globalphotoname=<%=photoname %>" class="btn btn-danger btn-block btn-lg" type="button">Save the Change</a>

			<form action="SnapostdeletePhoto"  method="post" role="form" name="delete_picture">
 				<input type="hidden" name="galbumname" value=<%=albumname %>> 
 				<input type="hidden" name="gphotoname" value=<%=photoname %>> 
 				<input type="hidden" name="goriginphoto" value=<%=originphotoname %>>
 				<button class="btn btn-info btn-block btn-lg" type="submit">Delete the Picture</button>
			</form>
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
