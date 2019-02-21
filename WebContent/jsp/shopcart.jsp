<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script>
    function clearCar(){
        var b = window.confirm("确定清空购物车？");
        if(b) {
            return true;
        }else{
            return false;
        }
    }
</script>
</head>
<%-- 菜单头--%>
<%@ include file="/jsp/top.jsp"%>
<body>

<%-- 主体--%>
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><a href="/ShopMall/jsp/index.jsp">&lt;继续购买</a></h3>
        </div>
        <div class="panel-body">

<%--empty函数是判断集合中有没有元素--%>
<%--如果购物车是没有任何购物项的--%>
<c:if test="${empty(cart.productMap)}">
    <h1>您还没有购买过任何商品！<a href="/ShopMall/jsp/index.jsp">去购买</a></h1>
</c:if>

<%--如果购物车有购物项，就应该把购物项的信息显示给用户--%>
<c:if test="${!empty(cart.productMap)}">

    <table  class="table">
        <tr>
            <td>商品图片</td>
            <td>名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${cart.productMap}" var="me">
            <tr>
                <td><img src="${me.value.product.imgPath}" width="100" height="100"></td>
                <td>${me.value.product.pro_Name}</td>
                <td>${me.value.quantity}</td>
                <td>${me.value.product.pro_Price}</td>
                <td><a href="${pageContext.request.contextPath}/DeleteProductServlet?product_id=${me.key}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/ClearCartServlet" onclick="return clearCar()">清空购物车</a></td>

            <td colspan="2">合计：</td>
            <td>${cart.total}</td>
        </tr>

    </table>
	  <a href="/ShopMall/AddInformationServlet" class="btn btn-warning">结算</a>
</c:if>
        </div>
    </div>
   
</div>


</body>
<%-- 页脚--%>
<%@ include file="/jsp/bottom.jsp"%>
</html>