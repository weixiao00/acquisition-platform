<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登陆页</title>
<link href="css/login.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header"></div>
  
  <!-- content 部分 -->
  <div id="content">
  	<div id="login">
    	<form action="LoginServlet" method="post">
        	<br />
        	<label for="name">账户名:</label>
            <input type="text" class="input_name" id="name" name="username"/>
            <br />
            <br />
            <label for="password">密　码:</label>
            <input type="password" class="input_password" id="password" name="pass"/>
            <br />
            <br />
            <input type="submit" value="登 陆"  class="input_submit" />
            <span><a href="###">忘记密码？</a></span>
        </form>
        <a href="register.jsp" target="_blank" ><img src="images/login_register.jpg" class="register" alt="" /></a>
    </div>
  </div>
  
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>

</body>
</html>