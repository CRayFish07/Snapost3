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
				if(sex.replaceAll(" ", "").equals("female")){
			  %>
				<img src="img/nv.jpg" class="img-rounded" width="150" height="150">
			<%	}
				else {%>
				<img src="img/nan.jpg" class="img-rounded" width="150" height="150">
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
			<div>
						<p>
							<form name = "set" action = "SnapotSetting" method = "post" class="form-horizontal" role="form">
							 <%
							  	String[] elements = {name};
								String[] property = {"MNAME"};
								String table = "Member";
								String[] type = {"char"};
								String[] restraints = {"="};
								ArrayList<String> result = new ArrayList<String>();
								int count = Select.SelectElement(elements, property, table, type, restraints, result);
								if(result != null) {
							   %>
								<div class="form-group">
									 <label for="inputname2" class="col-sm-2 control-label">User name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputname2" value="<%=new String(name).replaceAll(" ", "") %>">
									</div>
								</div>
								
								<div class="form-group">
									 <label for="inputsex2" class="col-sm-2 control-label">Sex</label>
									 <div>
									 <%if(new String(result.get(2)).replaceAll(" ", "").equals("female")) {%>
										<input type="radio" value="female" checked name="inputsex2" id="inputsex2">female
										&nbsp &nbsp &nbsp &nbsp
										<input type="radio" value="male" name="inputsex2" id="inputsex2">male
									<%}
									else { %>
										<input type="radio" value="female" name="inputsex2" id="inputsex2">female
										&nbsp &nbsp &nbsp &nbsp
										<input type="radio" value="male" checked name="inputsex2" id="inputsex2">male
									<%} %>
									</div>
								</div>
								<div class="form-group">
									 <label for="inputbirth2" class="col-sm-2 control-label">Birth date</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputbirth2" value="<%=new String(result.get(3)).replaceAll(" ", "") %>">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputEmail2" id="email" value="<%=result.get(4).replaceAll(" ","") %>">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputSig2" class="col-sm-2 control-label">Signature</label>
									 <div class="col-sm-10">
        							<input type="text" class="form-control" name="inputSig2" value="<%=result.get(5).replaceAll(" ","") %>">
									</div>
									
								</div>
								<%} %>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button type="submit" class="btn btn-info" onClick = "return check();">Submit</button>
									</div>
								</div>
							</form>
							<%int count2 = 0;
							if(request.getParameter("inputname2") != null)
							{
								String name2 = request.getParameter("inputname2");
								String[] elements2 = {name};
								String[] property2 = {"MNAME"};
								String table2 = "Member";
								String[] type2 = {"char"};
								String[] restraints2 = {"="};
								ArrayList<String> result2 = new ArrayList<String>();
								count2 = Select.SelectElement(elements2, property2, table2, type2, restraints2, result2);
								if(name2.equals(name))		//如果没修改名称
									count2 = 0;	
							 }%>
						<head>
						<script type="text/javascript">
							function check(){
					          if(set.inputEmail2.value != "")
					          {
						          var temp = document.getElementById("email");
						           //对电子邮件的验证
						           var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
						           if(!myreg.test(temp.value))
						           {
						                window.alert("请输入有效的E-mail！");
						                //myreg.focus();
						                return false;
						           }
					         }
					       }
					    </script>
					  </head>
						</p>
					</div>
		</div>
		<div class="col-md-2 column">
			<h3>
				Setting Page
			</h3>
			<a href="setting_password.jsp" class="btn btn-info btn-block btn-lg" type="button">Change password</a>
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
