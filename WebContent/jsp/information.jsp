<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写订单信息</title>
</head>
<body>
<%@ include file="/jsp/top.jsp"%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
           
        </div>
        <div class="panel-body">

            <form action="/ShopMall/AddInformationServlet" class="form-horizontal" role="form" method="post">
                <div class="form-group">
                    <label  class="col-sm-1 control-label" name="a">收件人：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-1 control-label" name="a">地址：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="address" required>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-1 control-label" name="a">电话：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="phone" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-lg-4">
                        <button type="submit" class="btn btn-success btn-lg btn-block">提交信息</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>