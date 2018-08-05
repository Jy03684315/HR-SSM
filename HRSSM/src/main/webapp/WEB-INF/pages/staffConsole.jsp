<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/4
  Time: 0:49
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
        h1{
            background-color: lightskyblue;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<h1>员工控制台</h1>
<form action="onTime" method="post">
    <input type="submit" value="上班打卡"/>
</form>
${isOn}
${sOn}
<form action="offTime" method="post">
    <input type="submit" value="下班打卡"/>
</form>
${noOn}
${sOff}
<a href="toUpdateSDetail">个人信息查询及修改</a>
<a href="dpsForS">查看部门职位员工</a><br/>
<a href="trainNotice">培训通知</a><br/>
<a href="rewardInS">查询奖惩信息</a><br/>
<a href="attendanceInS">查询考勤</a><br/>
<form action="ret" method="post">
    <input type="submit" name="返回" value="注销"/>
</form>
</body>
</html>
