<%@ page import="com.show.model.Position" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/30
  Time: 14:52
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
<%
    List<Position> positions= (List<Position>) request.getAttribute("p");
%>
<h3>添加招聘信息</h3>
<form action="addRecruit" method="post">
    选择职位：<br/>
    <%for (Position position :positions ) {%>
    <input type="radio" name="pid" value="<%=position.getId()%>"><%=position.getName()%><br/>
    <%}%>
    薪资：<input type="text" name="salary"/><br/>
    人数：<input type="text" name="number"/><br/>
    描述：<input type="text" name="description"/><br/>
    发布时间：<input type="date" name="dateR"/><br/>
    <input id="addRecruit" type="submit" value="添加">
</form>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
