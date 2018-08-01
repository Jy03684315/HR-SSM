<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/30
  Time: 18:12
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
<h2>投递成功！</h2>
<form action="ret" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
