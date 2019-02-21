<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
<%-- 菜单头--%>
<%@ include file="/jsp/top.jsp" %>
<%-- 主体--%>

<div class="col-sm-8">
    <form class="form-horizontal" role="form" action="/ShopMall/RegServlet" method="post">

        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">用户名：</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="firstname" name="username"
                       placeholder="请输入用户名" title="4到16位（字母，数字，下划线，减号）的用户名" pattern="^[a-zA-Z0-9_-]{4,16}$" required>
            </div>
        </div>

        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">密码：</label>
            <div class="col-sm-7">
                <input type="password" class="form-control" id="pwd" name="password"
                       placeholder="请输入密码" title="密码长度为6~16，不能包含特殊字符" pattern="^[a-zA-Z0-9]{6,16}$" required>
            </div>
        </div>

        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">姓名：</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="Rpwd" name="name" 
                       placeholder="请输入姓名" title="请输入2~4位的中文姓名" pattern="[\u4E00-\u9FA5]{2,4}" required>
            </div>
        </div>

        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">手机号码：</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="phone" name="phone" 
                       placeholder="请输入11位手机号码" title = "请输入正确格式的11位手机号码" pattern ="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$" required>
            </div>

        </div>

        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">地址：</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="email" name="address"
                       placeholder="请输入地址" required>
            </div>

        </div>


        <div class="form-group">
            <label for="firstname" class="col-sm-5 control-label">邮箱：</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="day" name="email"
                       placeholder="格式为：xxx.com" title="请输入正确的邮箱格式" pattern="^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$" required>
            </div>

        </div>
       
      
        <div class="form-group">
            <label for="yqm" class="col-sm-5 control-label">验证码：</label>
            <div class="col-sm-5">
                <input  type="text" class="form-control" id="yqm" name="inputCode"
                       placeholder="请输入验证码">
            </div>
			<div class="col-sm-2">
                <img id="imgId" alt="找不到图片" src="/ShopMall/GenerateCode" onclick="show()">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-6 col-lg-4">
                <button type="submit" class="btn btn-success btn-lg btn-block">注册</button>
            </div>
        </div>
    </form>



</div>
<%-- 页脚--%>
<%@ include file="/jsp/bottom.jsp"%>
</body>
<script type="text/javascript">
function show(){
  var  img=document.getElementById("imgId")
  img.src="/ShopMall/GenerateCode?time="+new Date().getTime();
}
</script>
</html>