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
		<div class="col-md-8 column">
		<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>ID</th>
						<th>Name</th>					
						<th>Signature</th>
						<th>Check user's Pic</th>
					</tr>
				</thead>
				<tbody>
					<%ArrayList<String> result = new ArrayList<String>();
					int count = Select.SelectAll("Member", result);
					int j;
					if(result != null) {
						for(int i = 0; i < result.size(); i = i + count) {
							j = i;
							out.print("<tr class='success'>");
						//	out.print("<tr>");
							out.print("<td>" + (i/count+1) + "</td>");
							out.print("<td>" + result.get(j+6) + "</td>");
					    	out.print("<td>" + result.get(j) + "</td>");
					    	out.print("<td>" + result.get(j+5) + "</td>");
					    	out.print("<td><a href=ad_check_upic.jsp?userId="+ result.get(j + 6) +
			"> Open </a></td>");
					    	out.print("</tr>");
					    }	
				 		out.flush(); 
				 	}%>
				</tbody>
			</table>
			
		
		</div>
		<div class="col-md-2 column">
			<h3>
				user list Page
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
