<%@ page import="com.show.model.Reward" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/3
  Time: 16:39
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
<h1>奖惩记录</h1>
<%
    List<Reward> rewards= (List<Reward>) request.getAttribute("rewards");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>员工账号</th>
        <th>金额</th>
        <th>原因</th>
        <th>时间</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <%
        for (Reward reward : rewards) {
    %>
    <tr>
        <td><%=reward.getStaff().getName()%></td>
        <td><%=reward.getMoney()%></td>
        <td><%=reward.getExplain()%></td>
        <td><%=reward.getDate()%></td>
        <td>
            <form action="toUpdateReward" method="post">
                <input type="hidden" name="id" value="<%=reward.getId()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="deleteReward" method="post">
                <input type="hidden" name="id" value="<%=reward.getId()%>">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="getReward?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="rewardManage" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
