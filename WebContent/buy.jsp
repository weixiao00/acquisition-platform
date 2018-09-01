<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当网-可爱的鼠小弟</title>
<link href="css/page_03.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div id="wrapper">
  =<!-- header 部分 -->
  <div id="header">
    <!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >${user.username }</a> <a href="ExitServlet" class="exit">[退出登录]</a>
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 -->
  
  <div id="content_01"></div>
 
  <!-- content_02 部分 -->

   
     
      <form name="formname"  method="post" action="">      
    <table align="center" border=1>
   
      <tr>
        <td align="center"  width="248">商品名称</td>
        <td align="center"  width="183">购买数量</td>
        <td align="center"  width="199">当当价</td>
        <td align="center"  width="190">数量</td>
        <td align="center"  width="134">操作</td>
      </tr>
         <c:forEach items="${list }" var="shopcar" >
      <tr>
       <td align="center"><img  src="${shopcar.cover }">${shopcar.bookName }</td>
       <td align="center">${shopcar.account }</td>
       <td align="center">${shopcar.dprice }</td>
       <td align="center">
	<select  name="">
	<option value="">1</option>
	<option value="">2</option>
	<option value="">3</option>
	</select>
	   <!--购买数量 --></td>                               
       <td align="center"> <a href="DeleteServlet?bid=${shopcar.bid }">删除</a></td>
      </tr>
		</c:forEach> 
    </table>
 
<p align="right">
         <!-- 商品金额总计 -->
    	<span >商品金额总计￥：${account }</span>
        
    </p>
  

   
    <!-- 继续购物 -->
    <div id="goBuy">
    	<div align="right"><a href="QueryServlet"><img src="images/Page_03_03_buy.jpg" alt=""  border="0"/></a> </div>
    </div>
    
     <div align="right">
       <!-- 结算按钮 -->
      <a href="submit.jsp?uid=${user.uid }"><img src="images/Page_03_solve.jpg" alt=""  border="0"/></a>    
    </div> 
  <!-- content_03 部分 -->
  <div id="content_03"></div>
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</form> 
</body>
</html>