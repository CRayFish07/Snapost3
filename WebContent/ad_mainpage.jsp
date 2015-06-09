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
<style> 
    #masonry 
    { 
        padding: 0; 
        min-height: 450px; 
        margin: 0 auto; 
    } 
    #masonry .thumbnail 
    { 
        width: 330px; 
        margin: 20px; 
        padding: 0; 
        border-width: 1px; 
        -webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175); 
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175); 
    } 
    #masonry .thumbnail .imgs 
    { 
        padding: 10px; 
    } 
    #masonry .thumbnail .imgs img 
    { 
        margin-bottom: 5px; 
    } 
    #masonry .thumbnail .caption 
    { 
        background-color: #fff; 
        padding-top: 0; 
        font-size: 13px; 
    } 
    #masonry .thumbnail .caption .title 
    { 
        font-size: 13px; 
        font-weight: bold; 
        margin: 5px 0; 
        text-align: left; 
    } 
    #masonry .thumbnail .caption .author 
    { 
        font-size: 11px; 
        text-align: right; 
    } 
    
</style>
  </head>

<body data-spy="scroll" data-target=".navbar-example">
<div class="container">
<div class="row clearfix">
	<img src="http://nvidia.njuftp.org/images/f3db0c94-d57c-4b50-b516-412b041dfd71.png" width="100%" height="220px"/>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
			<img src="img/ad.jpg" class="img-rounded" width="150" height="150">
			<h3>
				Name: admin
			</h3>
			<p>
				I am the administor. Don't you dare offend me!! haha~
			</p>
			<p></p>
			<p>
				<a class="btn" href="login_in.jsp">Logout »</a>
			</p>
		</div>
		<div class="col-md-7 column">
		<ul class="nav nav-tabs">
				<li class="active">
					<a href="#panel-1" data-toggle="tab">News</a>
				</li>
				
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="ad_mainpage.jsp">Refresh</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="tab-content">
			<div class="tab-pane active" id="panel-1">
			<% 
				ArrayList<String> selection = new ArrayList<String>();
				int count = Select.SelectAll("PHOTO", selection);
				int num = selection.size()/count;
				for(int i = 0;i<selection.size();i=i+count){
			%>
			<div class="row">
			<%
					for(int j = 0;j<3&&i<selection.size();i=i+count,j++){
						String photoname = selection.get(i+4);
						String discription = selection.get(i+2);
						String headtitle = selection.get(i);
			%>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="" src="../Snapost3/upload/<%=photoname%>"  width="190" height="160">
						<div class="caption">
							<h4>
								<%=headtitle %>
							</h4>
							<p>
								<%=discription %>
							</p>
						</div>
					</div>
				</div>
				<%
					}
					
				%>
			</div>
				<% 
					i = i-count;
				}%>
				
			</div>
			</div>

		</div>
		
		<div class="col-md-3 column">
			<h2>
				Annocement:
			</h2>
			<p>
				annocement content	
			</p>
			<p>
				<a class="btn" href="ad_history.jsp">Open history box »</a>
			</p> <a href="ad_check_user.jsp" class="btn btn-warning btn-lg btn-block" type="button">Check user</a> 
			<a href="ad_announce.jsp" class="btn btn-lg btn-primary btn-block" type="button">Announce</a> 
		</div>
		
		</div>
		

		
	</div>
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
