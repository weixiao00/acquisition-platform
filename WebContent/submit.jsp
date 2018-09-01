<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当网-名社新书大PK</title>
<link href="css/page_05.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
    <!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >${user.username }</a> <a href="ExitServlet" class="exit">[退出登录]</a>
        
        <div class="search">
        <input class="searchInput" type="text" /><input type="button" class="searchBtn" />
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 END -->
  
  
  <!-- content 部分 -->
  <div id="content">
    <!-- 购买详细信息 -->
  	<form action="InformationServlet" method="post">
    <p><span>&nbsp;&nbsp;&nbsp;&nbsp;姓名：</span><input type="text" class="name" name="realname"/></p>
    <p><span>&nbsp;&nbsp;&nbsp;地址：</span>
       <select name="address" id="">
         <option value="" selected="selected">请选择</option>
         <option value="辽宁省">辽宁省</option>
         <option value="黑龙江省">黑龙江省</option>
         <option value="吉林省">吉林省</option>
       </select>		
       <select name="address" id="">
         <option value="" selected="selected">请选择</option>
         <option value="绥化">绥化市</option>
         <option value="哈尔滨市">哈尔滨市</option>
         <option value="北京市">北京市</option>
         
       </select>
    </p>
    <p><span>详细地址：</span><input type="text"  class="textInput" name="detailaddr"/></p>
    <p><span>联系电话：</span><input type="text" class="textInput" name="phone"/></p>
    <p>
    	<input type="submit" value="确 认" class="btn" /> 
        <input type="reset" value="重 置" class="reset" /></p>  
    </form>
  </div>
  
</div>
</body>
</html>