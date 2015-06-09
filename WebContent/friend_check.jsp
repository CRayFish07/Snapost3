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
				if(sex != null){
					if(sex.replaceAll(" ", "").equals("female")){
			%>
						<img src="img/nv.jpg" class="img-rounded" width="150" height="150">
			<%		}
					else {%>
						<img src="img/nan.jpg" class="img-rounded" width="150" height="150">
			<%		} 
				}%>
			<h3>
				Name: <%=name %>
			</h3>
			<p>
				ID: <%=id %>
			</p>
			<p>
				Signature: <%=signature %>
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
						<th>Level</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					
					<%ArrayList<String> result = new ArrayList<String>();
					Select.SelectAll(name, result);
					if(result != null) {
						for(int i = 0; i < result.size(); i = i + 1) {
							String[] elements = {result.get(i)};
							String[] property = {"MNAME"};
							String table = "Member";
							String[] type = {"char"};
							String[] restraints = {"="};
							ArrayList<String> selection = new ArrayList<String>();
							Select.SelectElement(elements, property, table, type, restraints, selection);
							out.print("<tr class='success'>");
						//	out.print("<tr>");
							out.print("<td>" + (i+1) + "</td>");
							out.print("<td>" + selection.get(6) + "</td>");
					    	out.print("<td>" + selection.get(0) + "</td>");
					    	out.print("<td>" + selection.get(5) + "</td>");
					    	//去寻找对方的好友列表中是否有自己来判断level为多少
					    	ArrayList<String> temp = new ArrayList<String>();
					    	Select.SelectAll(selection.get(0), temp);
					    	int mark = 0;
					    	for(int k = 0; k < temp.size(); k = k + 1){
					    	//	out.print("temp.get(k) = " + temp.get(k));
					    	//	out.print("result.get(i) = " + result.get(i));
					    	//	out.print("name = " + name);
					    		if(temp.get(k) != null){
					    			if(temp.get(k).replaceAll(" ", "").equals(name.replaceAll(" ", ""))){
					    				out.print("<td>2</td>");
					    				mark = 1;
					    			}
					    		}
					    	}
					    	//out.print("mark = " + mark);
					    	if(mark == 0)
					    		out.print("<td>1</td>");
					    	%>
					    	<form action="SnapostDeleteFriend" method = "post" name = "">
					    	<td>
						    	<input type = "hidden" name="friendName" value = "<%=selection.get(0) %>">
						    	<input type = "submit" value="Delete"  name="msg_delete" onClick = "return check();">
					    	</td>
					    	</form>
					    	<%out.print("</tr>");
					    }	
				 		out.flush(); 
				 	}%>
				</tbody>
			</table>
		</div>
		
		<head>
			<script type="text/javascript">
		    //检查输入的用户是否合法，不为空则合法
		    function check(){
		        var result;
				result = window.confirm("Are you sure to delete?");
				if(result)
				{
				    return true;
				}
				else
				{
				    return false;
				}
		       }
		 
		    </script>
		</head>
		
		<div class="col-md-2 column">
		<h3>
				Friend_list Page
			</h3>
			 <a id="modal-820181" href="#modal-container-2" role="button" class="btn btn-block btn-info btn-lg" data-toggle="modal">
			 Add New Friend
			 </a>
			
			<div class="modal fade" id="modal-container-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Add New Friend
							</h4>
						</div>
						<div class="modal-body">
						<form name = "add" action = "SnapostAddFriend" method = "post" role="form" name="add_friend">
							<div class="form-group">
								 <label for="inputID1" class="col-sm-2 control-label">Enter the ID/User name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="input_friend" name = "input">
									</div>
									<br>
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
