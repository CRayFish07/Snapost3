<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<div class="col-md-2 column">
			<img alt="140x140" src="http://lorempixel.com/140/140/" class="img-rounded">
			<h2>
				Name: coco
			</h2>
			<p>
				ID: 001
			</p>
			<p>
				Signature~~~~~
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
				<li>
					<a href="#panel-2" data-toggle="tab">My History</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">Refresh</a>
						</li>
						<li>
							<a href="#">Bottom</a>
						</li>
						
						<li class="divider">
						</li>
						<li>
							<a href="#">Separated link</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="panel-1">
					<div class="navbar-example">
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/140/140/" class="img-rounded" alt="" align="" width="150" height="150"></a>
								<div class="media-body">
									<h4 class="media-heading">
										Nested media heading
									</h4> Cras sit amet nibh libero, 
									<div class="media">
						 				<div class="media-body">
											<label for="input">Your comments: </label>
						
											<input type="text" class="form-control" id="input">
								
											<button type="submit" class="btn btn-default btn-xs">Submit</button>
										</div>
									</div>
								</div>
								
							</div>
						</ul><ul></ul>
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/140/140/" class="img-rounded" alt="" align="" width="150" height="150"></a>
								<div class="media-body">
									<h4 class="media-heading">
										Nested media heading
									</h4> Cras sit amet nibh libero, 
									<div class="media">
						 				<div class="media-body">
											<label for="input">Your comments: </label>
						
											<input type="text" class="form-control" id="input">
								
											<button type="submit" class="btn btn-default btn-xs">Submit</button>
										</div>
									</div>
								</div>
								
							</div>
						</ul><ul></ul>
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/140/140/" class="img-rounded" alt="" align="" width="150" height="150"></a>
								<div class="media-body">
									<h4 class="media-heading">
										Nested media heading
									</h4> Cras sit amet nibh libero, 
									<div class="media">
						 				<div class="media-body">
											<label for="input">Your comments: </label>
						
											<input type="text" class="form-control" id="input">
								
											<button type="submit" class="btn btn-default btn-xs">Submit</button>
										</div>
									</div>
								</div>
								
							</div>
						</ul><ul></ul>
					</div>
					</div>
				<div class="tab-pane" id="panel-2">
					<div class="navbar-example">
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
								<div class="media-body">
									<h4 class="media-heading">
										History
									</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
									
								</div>
							</div>
						</ul>
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
								<div class="media-body">
									<h4 class="media-heading">
										History
									</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
									
								</div>
							</div>
						</ul>
						<ul class="nav nav-tabs">
							<div class="media">
							 	<a href="#" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
								<div class="media-body">
									<h4 class="media-heading">
										History
									</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
									
								</div>
							</div>
						</ul>
					</div>
				</div>
			</div>
			<ul class="pagination">
				<li>
					<a href="#">Prev</a>
				</li>
				<li>
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li>
					<a href="#">Next</a>
				</li>
			</ul>
		</div>
		<div class="col-md-3 column">
			<h2>
				Annocement:
			</h2>
			<p>
				annocement content	
			</p>
			<p>
				<a class="btn" href="#">Open mailbox »</a>
			</p> <a href="#" class="btn btn-warning btn-lg btn-block" type="button">Upload My Pic</a> 
			<a href="#" class="btn btn-lg btn-primary btn-block" type="button">Check My Album</a> 
			<a href="#" class="btn btn-lg btn-block btn-info" type="button">Check My Friends</a> 
			<a href="#" class="btn btn-warning btn-lg btn-block" type="button">Individual Setting</a>
			<a href="#" class="btn btn-success btn-lg btn-block" type="button">Help</a>
		</div>
	</div>
</div>
 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <script src="http://getbootstrap.com/assets/js/docs.min.js"></script>
</body>
</html>
