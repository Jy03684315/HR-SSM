<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 0:01
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
<h3>部门修改</h3>
<form action="updateDepartment" method="post">
部门名称：<input type="text" name="name" value="${d.name}">
          <input type="hidden" name="id" value="${d.id}">
          <input type="hidden" name="date" value="${d.date}">
          <input type="submit" value="提交修改">
</form>
</body>
</html>
