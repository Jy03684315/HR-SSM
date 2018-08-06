<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 13:30
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
    <style>
        td{
            width: 200px;
            height: 30px;
            text-align: center;
        }
        h1{
            background-color: lightskyblue;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<h1>员工管理</h1>
<a href="probation">查看试用期员工</a>
<a href="onJob">查看在职员工</a>
<a href="leaveJob">查看离职员工</a><br/>
<h3>员工培训</h3>
<a href="addTrain">新增培训</a>
<a href="offTrain">查看未发布培训</a>
<a href="onTrain">查看已发布培训</a><br/>
${fail}
${failBeFull}
${failChanging}
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
