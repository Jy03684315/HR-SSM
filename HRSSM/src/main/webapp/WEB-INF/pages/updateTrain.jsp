<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/3
  Time: 0:24
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
<h3>培训信息修改</h3>
<form action="updateT" method="post">
    主题：<input type="text" name="theme" value="${t.theme}"><br/>
    内容：<input type="text" name="content" value="${t.content}"><br/>
    开始时间：<input type="date" name="beginT"/><br/>
    结束时间：<input type="date" name="endT"/><br/>
    <input type="hidden" name="id" value="${t.id}">
    <input type="submit" value="提交修改">
</form>
<form action="offTrain" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
