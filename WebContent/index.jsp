<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lin.util.JDBCUtil" %>
<%@ page import="com.lin.service.impl.ProductServiceImpl" %>
<%@page import="java.util.Map" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>主页</title>
<script type="text/javascript">
<%-- 编写一个js方法 ，要求传入一个currentpage（当前页面）--%>
	function gotopage(currentpage){
	window.location.href = '${pageContext.request.contextPath}/ProductServlet?currentpage='+currentpage;
	}
</script>
</head>
<body style="text-align:center;">
<!-- 页头 -->
<%@ include file="/jsp/top.jsp" %>

	<h1 style="text-align:center;">用户信息列表</h1>
	<table border="1" cellspacing="0" style="text-align:center"
		align="center" width="50%">
		<%--循环给table赋值
	${pagebean.list}：---->用el表达得到request域中的pagebean.list属性
	 --%>
		<c:forEach var="c" items="${pagebean.list}">
			<tr>
				<td width="50px" height="20px">${c.pro_Num }</td>
				<td width="150px" height="20px">${c.pro_Name }</td>
				<td width="150px" height="20px">${c.pro_Price }</td>
				<td width="150px" height="20px">${c.imgPath }</td>
				<td width="150px" height="20px">${c.pro_Desc }</td>
				
			</tr>
		</c:forEach>

	</table>

	<p>共【${pagebean.totalrecord }】条记录,每页【${pagebean.pagesize
		}】条,共【${pagebean.totalpage
		}】页,当前第【${pagebean.currentpage}】页&nbsp;&nbsp;&nbsp;</p>
	<p>
		<a href="javascript:" onclick="gotopage(1)">首页</a>&nbsp;&nbsp;&nbsp; <a
			href="javascript:" onclick="gotopage(${pagebean.previouspage})">上一页</a>&nbsp;&nbsp;&nbsp;
		<c:forEach var="pagenum" items="${pagebean.pagebar }">
			<%--如果是当前页面，则不以超连接显示，并且字体修改成红色--%>
			<c:if test="${pagenum==pagebean.currentpage }">
				<font color="red">${pagenum}</font>
			</c:if>
			<c:if test="${pagenum!=pagebean.currentpage }">
				<a href="javascript:" onclick="gotopage(${pagenum})">${pagenum }</a>
			</c:if>
		</c:forEach>
		&nbsp;&nbsp;&nbsp; <a href="javascript:"
			onclick="gotopage(${pagebean.nextpage})">下一页</a>&nbsp;&nbsp;&nbsp; <a
			href="javascript:" onclick="gotopage(${pagebean.totalpage})">尾页</a>
	</p>
<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>