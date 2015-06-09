<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "Database.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
		<div class="carousel slide" id="carousel-271150">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-271150">
					</li>
					<li data-slide-to="1" data-target="#carousel-271150">
					</li>
					<li data-slide-to="2" data-target="#carousel-271150">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="http://lorempixel.com/1600/500/sports/1">
						<div class="carousel-caption">
							<h4>
								First
							</h4>
							<p>Le vrai bonheur serait de se souvenir du présent.</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="http://lorempixel.com/1600/500/sports/2">
						<div class="carousel-caption">
							<h4>
								Second
							</h4>
							<p>Le vrai bonheur serait de se souvenir du présent.</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="http://lorempixel.com/1600/500/sports/3">
						<div class="carousel-caption">
							<h4>
								Third 
							</h4>
							<p>Le vrai bonheur serait de se souvenir du présent.</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-271150" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-271150" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="page-header">
				<h1>
					IPIC<br>
					<small><font class=2>Le vrai bonheur serait de se souvenir du présent.</font></small>
				</h1>
			</div>
			
			<div class="tabbable" id="tabs-970709">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-38686" data-toggle="tab">Login</a>
					</li>
					<li>
						<a href="#panel-880039" data-toggle="tab">Register</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-38686">
						<p>
							<form name = "f1" action = "SnapostLogin" method = "post" class="form-horizontal" role="form">
								<div class="form-group">
									 <label for="inputID1" class="col-sm-2 control-label">User name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputname1">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputPassword1" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" name="inputPassword1">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											 <label><input type="checkbox"> Remember me????</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button type="submit" class="btn btn-default" onClick = "return check2();">Login in</button>
									</div>
								</div>
							</form>
							
						</p>
					</div>
					<div class="tab-pane" id="panel-880039">
						<p>
							<form name = "form" action = "SnapostnewRegister" method = "post" class="form-horizontal" role="form">
								<div class="form-group">
									 <label for="inputname2" class="col-sm-2 control-label">User name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputname2" id="inputname2">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputPassword2" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" name="inputPassword2">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputPassword2_1" class="col-sm-2 control-label">Re Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" name="inputPassword2_1">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputsex2" class="col-sm-2 control-label">Sex</label>
									 <div>
										<input type="radio" value="female" name="inputsex2" id="inputsex2" checked="checked">female
										&nbsp &nbsp &nbsp &nbsp
										<input type="radio" value="male" name="inputsex2" id="inputsex2">male
									</div>
								</div>
								<div class="form-group">
									 <label for="inputbirth2" class="col-sm-2 control-label">Birth date</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputbirth2">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="inputEmail2" id = "email">
									</div>
								</div>
								<div class="form-group">
									 <label for="inputSig2" class="col-sm-2 control-label">Signature</label>
									 <div class="col-sm-10">
        							<input type="text" class="form-control" name="inputSig2">
									</div>
									
								</div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											 <label><input type="checkbox"> Remember me</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										 <button type="submit" class="btn btn-default" onClick = "return check();">Sign in</button>
									</div>
								</div>
							</form>
							<%int count = 0;
							if(request.getParameter("inputname2") != null)
							{
								String name = request.getParameter("inputname2");
								String[] elements = {name};
								String[] property = {"MNAME"};
								String table = "Member";
								String[] type = {"char"};
								String[] restraints = {"="};
								ArrayList<String> result = new ArrayList<String>();
								count = Select.SelectElement(elements, property, table, type, restraints, result);	
							 }%>
							<head>
							<script type="text/javascript">
							
						    //检查输入的用户是否合法，不为空则合法
						    function check(){
						          if(form.inputname2.value == "")
						          {
						               window.alert("Username cannot null!");
						               return false;
						          }
						          if(form.inputPassword2.value == "")
						          {
						          	   window.alert("Password cannot null!");
						               return false;
						          }
						          if(form.inputPassword2_1.value == "")
						          {
						          	window.alert("Password cannot null!");
						               return false;
						          }
						          if(form.inputPassword2.value != form.inputPassword2_1.value)
						          {
						          	window.alert("Password Incorrect!");
						               return false;
						          }
						          //用正则表达式匹配，不能是全数字
						          //window.alert(form.inputname2.value);
						          if(form.inputname2.value != "")
						          {						      
						          	if(form.inputname2.value == "admin")
							           {
							           		window.alert("Invalid username, please try another");
							           		return false;
							           }
						          		var temp = document.getElementById("inputname2");
							           //对电子邮件的验证
							          // window.alert(temp.value);
							           var myreg = new RegExp("^[0-9]*$");
							           if(myreg.test(temp.value))
							           {
							                window.alert("Invaild username(can't be all numbers)");
							                //myreg.focus();
							                return false;
							           }
						          }
						          if(form.inputEmail2.value != "")
						          {
							          var temp = document.getElementById("email");
							           //对电子邮件的验证
							           var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
							           if(!myreg.test(temp.value))
							           {
							                window.alert("E-mail invaild");
							                //myreg.focus();
							                return false;
							           }
						         }
						         if(c > 0)
						         {
						         	window.alert("Already exist!");
							       	return false;
						         }
						       }
						       //检查输入的用户是否合法，不为空则合法
							    function check2(){
							          if(f1.inputname1.value == "")
							          {
							               window.alert("Username cannot be null!");
							               return false;
							          }
							          else if(f1.inputPassword1.value == "")
							          {
							          	   window.alert("Password cannot be null!");
							               return false;
							          }
							       }
						    </script>
						  </head>
						</p>
					</div>
				</div>
			</div>
			
			
		</div>
		<div class="col-md-4 column">
			<div class="jumbotron">
				<h1>
					Hello, world!
				</h1>
				<p>This is a login in interface,which can help you to log on to the website IPIC, of course, 
				if there is no account, you need to register first.
				 If necessary,you can also infer to the navigation interface. More help ? "Learn more".</p>
				<p>
					<a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
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
