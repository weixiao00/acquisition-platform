<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当网-名社新书大PK</title>
<link href="css/page_01.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
  	<!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >${user.username }</a> <a href="ExitServlet" class="exit">[退出登录]</a>
        <!-- 搜索 -->
        <div class="search">
        <form id="form1" action="SearchServlet" method="post">
      <input class="searchInput" type="text" name="temp"/><input type="button" class="searchBtn" onclick="document.getElementById('form1').submit();"/>
        </form>
      
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END-->
  </div><!-- header END -->
  
  <div id="banner"></div>
  
  <!-- content 部分 -->
  <div id="content">
  	<!-- 图书商品分类 -->

  	<div class="content-left">
    	<ul>
    	<c:forEach items="${tlist }" var="booktype">
        	<li><a href="QueryServlet1?tid=${booktype.tid }">${booktype.tname }</a><span>（1213）</span></li>
        </c:forEach>
        </ul>
    </div>
    <!-- 图书商品分类 END -->
    <div class="content-right">
        <!-- 排序条件（评分、价格等） -->
    	<div class="row01">
          <p class="px">
            <a href="###"><img src="images/xl.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/pf.jpg"  /></a>&nbsp;
            <a href="SortByPriceSerlvet?currentPage=${currentPage }&pageSize=${pageSize }"><img src="images/jg.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/zk.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/cbsj.jpg"  /></a>
         </p>
        </div><!-- 排序条件（评分、价格等） END -->      
        <!-- 循环内容 -->
        <c:forEach items="${slist }" var="book">
        <div class="row02">
        	<a href="BuyServlet?bid=${book.bid }"><img src="${book.cover }" /></a>
        	<h2><a href="BuyServlet?bid=${book.bid }">${book.bookName }</a></h2>
            <p>
            （日）<a href="BuyServlet?bid=${book.bid }">${book.author }</a> 文，（日）<a href="#">上野麂子</a> 绘，
            <a href="BuyServlet?bid=${book.bid }">${book.author }</a>，<a href="BuyServlet?bid=${book.bid }">文纪子</a> 译/2009年08月/<a href="BuyServlet?bid=${book.bid }">${book.publish }</a>
            </p>
            <p>
           ${book.introduce }
            </p>
            <form id="${book.bid }" action="JudgeServlet" method="get">
            <p class="p02">
            <span class="red">￥<fmt:formatNumber type="number" value="${book.price*book.discount }" maxFractionDigits="1"></fmt:formatNumber></span> &nbsp;&nbsp;<span class="line-through">￥${book.price }</span> &nbsp;&nbsp;折扣：${book.discount }

            <input type="hidden" name="bid" value="${book.bid }" />
            <input type="hidden" name="cover" value="${book.cover }"/>
            <input type="hidden" name="price1" value="${book.price*book.discount }"/>
            <input type="hidden" name="bookname" value="${book.bookName }"/>
            <input type="hidden" name="account" value="1"/>
            <input type="button" class="buy" onclick="document.getElementById('${book.bid }').submit();"/>
            </p>
            </form>
        </div>
        </c:forEach>
        
      
        
        <!-- 分页 -->
        <div class="row04">
        <a href="QueryServlet?currentPage=${currentPage-1 }">上一页</a> <a href="QueryServlet?currentPage=${1 }"> 1 </a> <a href="QueryServlet?currentPage=${2 }"> 2</a> <a href="QueryServlet?currentPage=${3 }"> 3 </a> <a href="QueryServlet?currentPage=${currentPage+1 }">下一页</a>
        &nbsp;&nbsp;共<span>${pageCount }</span>页 到第<input type="text" class="inputPage" name="currentPage"/>页
        </div><!-- 分页 END -->
    </div><!-- content-right部分 END -->
  </div><!-- content部分 END -->
 
  
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</body>
</html>