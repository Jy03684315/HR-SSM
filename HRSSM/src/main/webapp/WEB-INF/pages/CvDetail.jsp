<%@ page import="com.show.model.Cv" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/28
  Time: 17:32
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
<table border="1" cellspacing="0">
    <tr>
        <th colspan="3">简历名称</th>
    </tr>
    <tr>
        <th colspan="3">${cv.cName}</th>
    </tr>
    <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>出生日期</td>
    </tr>
    <tr>
        <td>${cv.uName}</td>
        <td>${cv.sex}</td>
        <td>${cv.birth}</td>
    </tr>
    <tr>
        <td colspan="3">身份证</td>
    </tr>
    <tr>
        <td colspan="3">${cv.idCard}</td>
    </tr>
    <tr>
        <td>民族</td>
        <td>政治面貌</td>
        <td>身高</td>
    </tr>
    <tr>
        <td>${cv.nation}</td>
        <td>${cv.ps}</td>
        <td>${cv.height}</td>
    </tr>
    <tr>
        <td colspan="2">毕业院校</td>
        <td>学历</td>
    </tr>
    <tr>
        <td colspan="2">${cv.graduation}</td>
        <td>${cv.education}</td>
    </tr>
    <tr>
        <td colspan="3">离职前所在公司</td>
    </tr>
    <tr>
        <td colspan="3">${cv.company}</td>
    </tr>
    <tr>
        <td colspan="3">相关证书</td>
    </tr>
    <tr>
        <td colspan="3">${cv.certificate}</td>
    </tr>
    <tr>
        <td colspan="3">自我评价</td>
    </tr>
    <tr>
        <td colspan="3">${cv.evaluation}</td>
    </tr>
</table>
<form action="CvList" method="post">
    <input type="submit" name="返回" value="返回简历列表"/>
</form>
</body>
</html>
