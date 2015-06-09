<%@ page language="java" contentType = "text/html; charset = GB2312"%>
<html>
  <head>
    <title>false</title>
 <style type="text/css">
<!--
body {
    font-family: Arial, Helvetica, sans-serif;
    font-size:18px;
    color:#666666;
    background:#fff;
    text-align:center;

}-->
</style>
  </head>
  <body>
  <meta http-equiv="refresh" content="2; url=<%=request.getSession().getAttribute("back") %>">
  <br>
 <h2><%=request.getSession().getAttribute("wrongType")%></h2>
 </body>
</html>
