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
    <meta name="author" content="Wang huiyan, Song yiping, Si xuemin, Qin ke">

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
	<script language="javascript">
	function select(){ 
		var a = document.getElementsByName("gtype").value;
		//这里取下拉框gtype的值
		window.location.href="/WebModule1/" + a; 
	}
	
	function row
	</script>
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
		<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Name
						</th>
						<th>
							Date
						</th>
						<th>
							Description
						</th>
						<th>
							Pictures
						</th>
						<th>
							Action
						</th>
						<th>
							Action
						</th>
					</tr>
				</thead>
				<tbody>
					
					
					<%		
						String[] elements1 = {name};
						String[] property1 = {"USERNAME"};
						String table1 = "ALBUM";
						String[] type1 = {"char"};
						String[] restraints1 = {"="};
						ArrayList<String> result1 = new ArrayList<String>();
						int count1 = Select.SelectElement(elements1, property1, table1, type1, restraints1, result1);
// 						System.out.println("count:"+count1); 
						int j = 1;
						int num = 1;
						request.getSession().setAttribute("jsporservlet", "jsp");
						for(;j<result1.size();j=j+5,num++){
							//String results[] = result.get(i).split(" ");
							//System.out.println(result.get(i));
							String albumname1 = result1.get(j).trim();
							String date1 = result1.get(j+1).trim();
							String discription1 = result1.get(j+2).trim();
							String number1 = result1.get(j+3).trim();
					%>
						<tr class="success" >
							<td>
								<%=num %>
							</td>
							<td>
								<%=albumname1 %>
							</td>
							<td>
								<%=date1 %>
							</td>
							<td>
								<%=discription1 %>
							</td>
							<td>
								<%=number1 %>
							</td>
							<td>
								
								<a href="pic_list.jsp?globalalbumname=<%=albumname1 %>">Open</a>
							</td>
 							<td> 
								<a href="./deleteAlbum?globalalbumname=<%=albumname1%>" method = post>Delete</a> 
							</td> 
						</tr>
										
					<%}%>
					
					
				</tbody>
			</table>
		</div>
		<div class="col-md-2 column">
		<h3>
				Album_list Page
			</h3>
			<a id="modal-2" href="#modal-container-2" role="button" class="btn btn-block btn-success btn-lg" data-toggle="modal">
			 Add New Album
			 </a>
				<div class="modal fade" id="modal-container-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Create New Album
							</h4>
						</div>
						<div class="modal-body">
						<form action="newAlbum" method="post" role="form" name="add_album">
							<div class="form-group">
								 <label for="input_albumname" class="col-sm-5 control-label">Enter the name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="albumname" id="input_albumname">
										
									</div>
									
							</div>
							<div class="form-group">
								 <label for="input_des" class="col-sm-5 control-label">Enter the description:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="input_des" name="albumdiscription">
									</div>
									
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
						<form action="newUpload" enctype="multipart/form-data" method="post" role="form" name="add_picture">
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
// 										System.out.println(result.get(i));
										
										  String albumname = result.get(i).trim();
										
										%>
										<option value ='<%=albumname%>'><%=albumname %></option>
										
									<%}%>
								</select>  
							</div>
							<% %>
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

