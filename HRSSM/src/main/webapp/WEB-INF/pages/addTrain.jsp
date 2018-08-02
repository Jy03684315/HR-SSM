<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 14:31
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
<h3>新增培训</h3>
<h4>添加培训信息</h4>
<form action="addTrain1" method="post">
    主题：<input type="text" name="theme"/><br/>
    内容：<input type="text" name="content"/><br/>
    开始时间：<input type="date" name="beginT"/><br/>
    结束时间：<input type="date" name="endT"/><br/>
    <input type="submit" value="下一步">
</form>
<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
${fail}
</body>
</html>
