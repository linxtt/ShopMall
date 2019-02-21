<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<script type="text/javascript">
$(document).ready(function(){
    //记住密码功能
    var str = getCookie("loginInfo");
    str = str.substring(1,str.length-1);
    var username = str.split(",")[0];
    var password = str.split(",")[1];
    //自动填充用户名和密码
    $("#userName").val(username);
    $("#password").val(password);
    if(str!=null && str!=""){
        $("input[type='checkbox']").attr("checked", true);
    }
});
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//记住密码功能
function remember(){
    var remFlag = $("input[type='checkbox']").is(':checked');
    if(remFlag==true){ //如果选中设置remFlag为1
        //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
        var conFlag = confirm("");
        if(conFlag){ //确认标志
            $("#remFlag").val(true);
        }else{
            $("input[type='checkbox']").removeAttr('checked');
            $("#remFlag").val(false);
        }
    }else{ //如果没选中设置remFlag为false
        $("#remFlag").val(false);
    }
}
</script>
</head>
<body>
<!-- 页头 -->
<%@ include file="/jsp/top.jsp" %>
<!-- 页中 -->
<div class="container">
<div class="row">
        <div class="col-sm-6">
            <img src="/ShopMall/images/login_bg.jpg" class="img-responsive">
        </div>
    <div class="col-sm-6">
        <br><br><br>
        <form class="form-horizontal"  action="/ShopMall/LoginServlet" method="post">
            <div class="form-group">
                <label for="firstname" class="col-sm-3 control-label">账号：</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="username" name="username" value="${username }"
                           placeholder="请输入账号">
                </div>
                <div class="col-sm-3"></div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-3 control-label">密码：</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="password" name="password" value="${password }"
                           placeholder="请输入密码">
                </div>
                <div class="col-sm-3"></div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="remember" onclick="remember()"> 请记住我
                        </label>
                        &nbsp;&nbsp;&nbsp;&nbsp;<a href="/ShopMall/jsp/regist.jsp">无账号？点击注册</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-7">
                    <button type="submit" class="btn btn-primary btn-block">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<%-- 页脚--%>
<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>