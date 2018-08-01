<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 3:21
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
<h3>职位修改</h3>
<form action="updatePosition" method="post">
    职位名称：<input type="text" name="name" value="${p.name}">
    基本薪水：<input type="text" name="salary" value="${p.salary}">
    <input type="hidden" name="id" value="${p.id}">
    <input type="submit" value="提交修改">
</form>
</body>
</html>
