<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 2:12
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
<h3>添加职位</h3>
<form action="addPosition" method="post">
    职位名：<input id="name" type="text" name="name"/><br/>
    基本薪资：<input id="salary" type="text" name="salary"/><br/>
    <input type="hidden" name="did" value="${p.department.id}">
    <input type="submit" value="添加">
</form>
${failAddP}
<form action="doDepartment" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
