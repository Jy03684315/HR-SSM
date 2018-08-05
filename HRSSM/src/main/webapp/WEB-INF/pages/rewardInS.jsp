<%@ page import="com.show.model.Reward" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 2:24
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
<h1>奖惩信息</h1>
<form action="rewardInS">
    请输入需要查询的月份<input type="number" name="month">
    <input type="submit" value="提交">
</form>
<%
    List<Reward> rewards= (List<Reward>) request.getAttribute("rewards");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>奖惩时间</th>
        <th>奖惩金额</th>
        <th>奖惩原因</th>
    </tr>
    <%
        for (Reward reward : rewards) {
    %>
    <tr>
        <td><%=reward.getDate()%></td>
        <td><%=reward.getMoney()%></td>
        <td><%=reward.getExplain()%></td>
    </tr>
    <%
        }
    %>
</table>
<form action="toStaffConsole" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
