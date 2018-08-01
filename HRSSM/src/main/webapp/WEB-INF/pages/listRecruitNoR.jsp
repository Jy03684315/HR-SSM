<%@ page import="com.show.model.Recruit" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/30
  Time: 13:07
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
<h1>未发布招聘信息</h1>
<%
    List<Recruit> recruits= (List<Recruit>) request.getAttribute("recruits");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>薪资</th>
        <th>人数</th>
        <th>描述</th>
        <th>发布时间</th>
        <th>发布</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <%
        for (Recruit recruit : recruits) {
    %>
    <tr>
        <td><%=recruit.getPosition().getDepartment().getName()%></td>
        <td><%=recruit.getPosition().getName()%></td>
        <td><%=recruit.getSalary()%></td>
        <td><%=recruit.getNumber()%></td>
        <td><%=recruit.getDescription()%></td>
        <td><%=recruit.getDate()%></td>
        <td>
            <form action="changeState" method="post">
                <input type="hidden" name="id" value="<%=recruit.getId()%>">
                <input type="submit" value="发布">
            </form>
        </td>
        <td>
            <form action="toUpdateRecruit" method="post">
                <input type="hidden" name="id" value="<%=recruit.getId()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="deleteRecruit" method="post">
                <input type="hidden" name="id" value="<%=recruit.getId()%>">
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
<a href="noRelease?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
