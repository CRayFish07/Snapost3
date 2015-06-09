<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "Database.*" %>
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
	<img src="ad_title5.png" width="100%" height="220px"/>
	</div>
	<%ArrayList<String> result = new ArrayList<String>();
    if(request.getParameter("announceId") != null)
    {
	    String[] elements = {request.getParameter("announceId")};
		String[] property = {"TOD"};
		String table = "Announce";
		String[] type = {"char"};
		String[] restraints = {"="};
		int count = Select.SelectElement(elements, property, table, type, restraints, result);
	}
     %>
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
		<div class="col-md-8 column">
		<br><br>
			<div class="form-group">
				<label for="mailfrom" >From: Administrator</label>
			</div>
			<div class="form-group">
				<label for="mailto" >Title: <%=result.get(2) %></label>
			</div>
			<div class="form-group">
				<label for="maildate" >Time: <%=result.get(3) %></label>
			</div>
			<div class="form-group">
				<label for="mailcontent" >Content:</label>
			</div>
			<div class="form-group">
				<label for="mailcontent2" ><%=result.get(1) %></label>
			</div>
		</div>
		<div class="col-md-2 column">
			<h3>
				Announce Page
			</h3>
			 <a href="ad_mainpage.jsp" class="btn btn-warning btn-block btn-lg" type="button">Back to Homepage</a>
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
