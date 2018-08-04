<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/4
  Time: 0:43
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
<h3>员工登录</h3>
<form action="sLogin" method="post">
    账号：<input id="name" type="text" name="name"/><br/>
    密码：<input id="pass" type="password" name="pass"/><br/>
    <input id="mLogin" type="submit" value="登录">
</form>
${failSL}
<form action="ret" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
