<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/3
  Time: 16:51
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
<h3>奖惩信息修改</h3>
<form action="updateReward" method="post">
    金额：<input type="text" name="money" value="${r.money}">
    原因：<input type="text" name="explain" value="${r.explain}">
    <input type="hidden" name="id" value="${r.id}">
    <input type="submit" value="提交修改">
</form>
</body>
</html>
