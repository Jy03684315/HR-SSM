<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/30
  Time: 11:16
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
<h1>管理员控制台</h1>
<a href="toAddRecruit">添加招聘信息</a>
<a href="noRelease">未发布招聘信息</a>
<a href="isRelease">已发布招聘信息</a>
<a href="unRead">未读面试申请</a>
<a href="isRead">已读面试申请</a>
<a href="forReply">待回复面试申请</a>
<a href="employment">待录用面试申请</a><br>
<a href="listDepartment">部门职位管理</a>
<a href="staffManage">员工管理</a>
<a href="rewardManage">奖惩管理</a>
<form action="ret" method="post">
    <input type="submit" name="返回" value="注销"/>
</form>
</body>
</html>
