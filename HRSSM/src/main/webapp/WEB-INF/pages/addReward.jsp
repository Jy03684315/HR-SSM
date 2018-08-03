<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/3
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<h3>新增奖惩</h3>
<form action="addReward1" method="post">
    奖惩金额：<input  type="number" name="money"/><br/>
    原因：<input  type="text" name="explain"/><br/>
    <input type="submit" value="新增">
</form>
<form action="rewardManage" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
