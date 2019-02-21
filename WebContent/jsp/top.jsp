<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顶部标签栏</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 100%; height: 22px; background-color: #eeeeee;color: red; text-align: left">
    <%
    if(session.getAttribute("username")==null){
    %>
    <a href="/ShopMall/jsp/login.jsp" style="text-decoration:none;">请先登陆~</a>
    <%
    }else{
    %>
    欢迎：<%=session.getAttribute("username")%>&nbsp;进入商城
    <%}%>
</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <img src="/ShopMall/images/logo.gif">
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">标签栏</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/ShopMall/jsp/index.jsp">主页</a></li>
                <li><a href="#">彩妆</a></li>
                <li><a href="#">身体护理</a></li>
                <li><a href="#">礼盒套装</a></li>
                <li><a href="#">母婴专区</a></li>
                <li><a href="/ShopMall/jsp/shoppingCard.jsp">购物车</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>