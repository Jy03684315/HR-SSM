<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/6
  Time: 2:57
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
<h3>输入员工离职原因</h3>
<form action="leave">
    <input type="text" name="explain">
    <input type="hidden" name="id" value="${s.id}">
    <input type="submit" value="提交">
</form>
</body>
</html>
