<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/31
  Time: 17:23
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
<h1>详细信息</h1>
<table border="1" cellspacing="0">
    <tr>
        <th>应聘部门</th>
        <th>应聘职位</th>
        <th>姓名</th>
    </tr>
    <tr>
        <td>${i.recruit.position.department.name}</td>
        <td>${i.recruit.position.name}</td>
        <td>${i.cv.uName}</td>
    </tr>
    <tr>
        <th>性别</th>
        <th>生日</th>
        <th>身份证</th>
    </tr>
    <tr>
        <td>${i.cv.sex}</td>
        <td>${i.cv.birth}</td>
        <td>${i.cv.idCard}</td>
    </tr>
    <tr>
        <th>民族</th>
        <th>政治面貌</th>
        <th>身高</th>
    </tr>
    <tr>
        <td>${i.cv.nation}</td>
        <td>${i.cv.ps}</td>
        <td>${i.cv.height}</td>
    </tr>
    <tr>
        <th>毕业院校</th>
        <th>学历</th>
        <th>证书</th>
    </tr>
    <tr>
        <td>${i.cv.graduation}</td>
        <td>${i.cv.education}</td>
        <td>${i.cv.certificate}</td>
    </tr>
    <tr>
        <th>离职前所在公司</th>
        <th colspan="2">自我评价</th>
    </tr>
    <tr>
        <td>${i.cv.company}</td>
        <td colspan="2">${i.cv.evaluation}</td>
    </tr>
</table>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
