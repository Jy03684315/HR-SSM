<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/1
  Time: 14:53
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
<h3>员工录用</h3>
<form action="addStaff" method="post">
    账号：<input id="name" type="text" name="name"/><br/>
    密码：<input id="pass" type="password" name="pass"/><br/>
    <input id="addStaff" type="submit" value="设定员工账号密码">
</form>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
