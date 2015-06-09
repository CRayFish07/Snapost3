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
						<th>ID</th>
						<th>Name</th>					
						<th>Signature</th>
						<th>Warning?</th>
						<th>Closure?</th>
					
					</tr>
				</thead>
				<%=request.getParameter("userId") %>
				<tbody>
					<%ArrayList<String> result = new ArrayList<String>();
					String[] elements = {request.getParameter("userId")};
					String[] property = {"ID"}; 
					String table = "Member"; 
					String[] type = {"int"}; 
					String[] restraints = {"="};
					Select.SelectElement(elements, property, table, type, restraints, result);
					out.print("<tr class='warning'>");
					out.print("<td>" + result.get(6) + "</td>");
					out.print("<td>" + result.get(0) + "</td>");
					out.print("<td>" + result.get(5) + "</td>");
					%>
					<td>
						<a id="modal-1" href="#modal-container-1" role="button" data-toggle="modal">
						Warning</a>
					</td>
					<td>
						 <a id="modal-2" href="#modal-container-2" role="button" data-toggle="modal">
						Closure</a>
					</td>
					<%
					out.print("</tr>");	
				 	out.flush();%>
				</tbody>
			</table>
			<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Warning User?
							</h4>
						</div>
						<div class="modal-body">
						<form role="form" name="add_friend" action = "SnapostWarnUser" method = "post">
							<div class="form-group">
								 <label for="inputID1" class="col-sm-2 control-label">User name:<%=result.get(0) %></label>
							</div>
							<div class="modal-footer">
							 	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							 	<button type="submit"  name="Username" value = "<%=result.get(0) %>"
							 	class="btn btn-primary">Yes</button>
							</div>
						</form>
						</div>
					</div>
				</div>
		</div>
		<div class="modal fade" id="modal-container-2" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Closure User?
							</h4>
						</div>
						<div class="modal-body">
						<form role="form" name="add_friend" action = "SnapostCloseUser" method = "post">
							<div class="form-group">
								 <label for="inputID1" class="col-sm-8 control-label">User name:<%=result.get(0) %><br></label>
									<label for="inputLevel1" class="col-sm-8 control-label">Choose the closure time</label>
									
									<div class="col-sm-10">
										<input type="radio" value = "day" name="closure_time" id="closure_time" >1 day
										&nbsp &nbsp &nbsp &nbsp
										<input type="radio" value = "week" name="closure_time" id="closure_time" >1 week
									</div>
							</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							 <button type="submit" class="btn btn-primary" name="Username" value = "<%=result.get(0) %>">Submit</button>
						</div>
						</form>
						</div>
					</div>
					
				</div>
		</div>
			<div class="tab-content">
			<div class="tab-pane active" id="panel-1">
			<% 
				String[] photoelements = {result.get(0)};
				String[] photoproperty = {"USERNAME"};
				String phototable = "PHOTO";
				String[] phototype = {"char"};
				String[] photorestraints = {"="};
				ArrayList<String> photoresult = new ArrayList<String>();
				int count = Select.SelectElement(photoelements, photoproperty, phototable, phototype, photorestraints, photoresult);
				int num = photoresult.size();
				for(int i = 0;i<photoresult.size();i=i+count){
			%>
			<div class="row">
			<%
					for(int j = 0;j<3&&i<photoresult.size();i=i+count,j++){
						String photoname = photoresult.get(i+4);
						String discription = photoresult.get(i+2);
			%>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="" src="../Snapost3/upload/<%=photoname%>"  width="190" height="160">
						<div class="caption">
							<h4>
								<%=photoname %>
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
		<div class="col-md-2 column">
			<h3>
				user pic Page
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
