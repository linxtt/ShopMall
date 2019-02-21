<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lin.util.JDBCUtil" %>
<%@ page import="com.lin.service.impl.ProductServiceImpl" %>
<%@page import="java.util.Map" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>主页</title>
</head>
<body>
<!-- 页头 -->
<%@ include file="top.jsp" %>
<%
    ProductServiceImpl psi = new ProductServiceImpl();
    Map products = psi.getAllProduct();
    request.setAttribute("products", products);
%>
<%--Servlet传递过来的是一个Map对象，要显示所有的书籍，就需要遍历Map集合（EL表达式和JSTL标签合用）--%>
<table border="1px">
   

    <c:forEach items="${products}" var="pd">
    	<div class='col-sm-4 col-md-3'>
                <div class='thumbnail'>
                    <img src="${pd.value.imgPath}">
                    <div class='caption'>
                        <h3>${pd.value.pro_Name}</h3>
                        <p>￥${pd.value.pro_Price}</p>
                        <p>${pd.value.pro_Desc}</p>
                        <p><a href="/ShopMall/ShopCartServlet?pro_id=${pd.value.pro_Id}">放入购物车</a></p>
                    </div>
                </div>
            </div>
    </c:forEach>

</table>
<%@ include file="bottom.jsp"%>
</body>
</html>