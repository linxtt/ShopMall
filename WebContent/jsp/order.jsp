<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单界面</title>
<script>
    function clearOrder(){
        var b = window.confirm("确定清空订单？");
        if(b) {
            return true;
        }else{
            return false;
        }
    }
</script>
</head>
<body>
<%@ include file="/jsp/top.jsp"%>
<div class="container">

    <div class="panel panel-warning">
        
    <div class="panel-body">

      		<c:if test="${empty(cart.productMap)}">
                <h1>您还没有购买过任何的商品！<a href="index.jsp">去购买</a></h1>
            </c:if>
            <c:if test="${!empty(cart.productMap)}">
                <h1>下单成功</h1>
                联系人：${name}<br>
                电话：${phone}<br>
                地址：${address}<br>
                订单编号：${orderNumber}<br>
                <table  class="table">

                    <c:forEach items="${cart.productMap}" var="me">
                        <tr>
                            <td><img src="${me.value.product.imgPath}" width="100" height="100"></td>
                            <td>${me.value.product.pro_Name}</td>
                            <td>${me.value.product.pro_Desc}</td>
                            <td>${me.value.product.pro_Price}</td>
                        </tr>
                    </c:forEach>
					<tr>
                    <tr>
                     <td colspan="2"><a href="/ShopMall/OrderServlet">返回</a></td>
                        <td colspan="2"></td>
                        <td >合计：</td>
                        <td>${cart.total}元</td>
                    </tr>

                </table>

            </c:if>
        </div>
    </div>
</div>

<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>