<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当网-名社新书大PK</title>
<link href="css/page_04.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
    <!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >新用户</a> <a href="###" class="exit">[退出登录]</a>
        <!-- 搜索 -->
        <div class="search">
        <input class="searchInput" type="text" /><input type="button" class="searchBtn" />
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 -->
  
  <!-- content 部分 -->
  <div id="content">
    <!-- 注册信息 -->
  	<form id="form" action="RegisterServlet">
    <p><span>Email地址：</span><input type="text" class="textInput" name="username"/></p>
    <p><span>登录密码：</span><input type="text"  class="textInput" name="pass"/></p>
    <p><span>确认密码：</span><input type="text"  class="textInput" name="pass1"/></p>
    <p><span>&nbsp;&nbsp;&nbsp;&nbsp;验证码：</span><input type="text" class="textInput" /></p>
    <p><img src="images/Page_04_yzm.png" alt="" /><span class="grey">看不清？</span><a href="###">换张图</a></p>
    <p><input type="button" value="" class="btn" onclick="document.getElementById('form').submit();"/></p>
    <p><input name="" type="checkbox" value="" /> 我已阅读并同意《当当网交易条款》和《当当网社区条款》</p>
    </form>
  </div>
  
</div>
</body>
</html>
    