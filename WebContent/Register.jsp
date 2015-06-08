<%@ page language = "java" contentType = "text/html; charset = GB2312" %>
<%@ page import = "java.util.*" %>
<%@ page import = "Database.*" %>
<html>
<head>
<title>IPIC: user register</title>
<style type="text/css">
<!--
body {
    font-family: Arial, Helvetica, sans-serif;
    font-size:12px;
    color:#666666;
    background:#fff;
    text-align:center;

}

* {
    margin:0;
    padding:0;
}

a {
    color:#1E7ACE;
    text-decoration:none;    
}

a:hover {
    color:#000;
    text-decoration:underline;
}
h3 {
    font-size:14px;
    font-weight:bold;
}

pre,p {
    color:#1E7ACE;
    margin:4px;
}
input, select,textarea {
    padding:1px;
    margin:2px;
    font-size:11px;
}
.buttom{
    padding:1px 10px;
    font-size:12px;
    border:1px #1E7ACE solid;
    background:#D0F0FF;
}
#formwrapper {
    width:450px;
    margin:15px auto;
    padding:20px;
    text-align:left;
    border:0px #1E7ACE solid;
}

fieldset {
    padding:10px;
    margin-top:5px;
    border:1px solid #1E7ACE;
    background:#fff;
}

fieldset legend {
    color:#1E7ACE;
    font-weight:bold;
    padding:3px 20px 3px 20px;
    border:1px solid #1E7ACE;    
    background:#fff;
}

fieldset label {
    float:left;
    width:120px;
    text-align:right;
    padding:4px;
    margin:1px;
}

fieldset div {
    clear:left;
    margin-bottom:2px;
}

.enter{ text-align:center;}
.clear {
    clear:both;
}

-->
</style>
</head>
<body>
<br>
<br>

<img border="0" src="./img/22.png" align="left" style="margin-right:20px; auto; margin-top:50px;"/>
<div id="formwrapper"; style="margin-right:200px; auto; margin-top:10px;">
	<form name = "form" action = "newRegister" method = "post" >
	<fieldset>
        <legend>New User Register</legend>
        <p><strong>*:cannot be empty</strong></p>
        <div>
        <label>user name</label>
        <input type="text" name="logname" size="20" maxlength="30" /> 
        *(less than 30 character)<br />    
    </div>
    	<div>
        <label>enter your password</label>
        <input type="password" name="password" size="20" maxlength="30" /> 
        *<br />    
    </div>
    	<div>
        <label>enter your password again</label>
        <input type="password" name="repassword" size="20" maxlength="30" /> 
        *<br />    
    </div>
    	<div>
        <label>sex</label>
        <Input type = radio name = "sex" value = "male">male
		<Input type = radio name = "sex" value = "female">female<br />    
    </div>
        <div>
        <label>Birth date</label>
        <input type="text" name="age" size="20" maxlength="30" /> 
        <br />    
    </div>
       <div>
        <label>Email</label>
        <input type="text" name="email" size="20" maxlength="30" /> 
        <br />    
    </div>
      
    	<div>
        <label>Signature</label>
        <TextArea name = "message" Rows = "6" Cols = "30"></TextArea>
        <br />    
    </div>
     <div class="enter">
        <input type="submit" value="OK" onClick="return check();"/>
        <Input type = reset value = "reset">
    </div>
    </div>
    </fieldset>
	</form>
	
	<%int count = 0;
	if(request.getParameter("logname") != null)
	{
		String name = new String(request.getParameter("logname").getBytes("iso8859_1"));
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
    		var c = <%=count%>;
          if(form.logname.value == "" || form.password.value == "" || form.repassword.value == "")
          {
               window.alert("cannot be empty!");
               return false;
          }
          else if(form.password.value != form.repassword.value)
          {
          	   window.alert("enter wrong!");
               return false;
          }
          else if(form.email.value != "")
          {
	          var temp = document.getElementById("email");
	           //对电子邮件的验证
	           var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	           if(!myreg.test(temp.value))
	           {
	                alert("E-mail invaild");
	                //myreg.focus();
	                return false;
	           }
         }
         else if(c > 0)
         {
         	alert("Already exist!");
	       	return false;
         }
       }
    </script>
  </head>
	
</body>
</html>