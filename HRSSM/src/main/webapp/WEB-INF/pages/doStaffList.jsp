<%@ page import="com.show.model.Staff" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 23:57
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
<%
    List<Staff> staff= (List<Staff>) request.getAttribute("staff");
    int state= (int) request.getAttribute("state");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>员工账号</th>
        <th>基本信息</th>
        <th>薪资</th>
        <th>培训</th>
        <th>考勤</th>
        <%if (state!=3){%>
        <th>换岗</th>
        <th>离职</th>
        <%}%>
    </tr>
    <%
        for (Staff staff1: staff) {
    %>
    <tr>
        <td><%=staff1.getName()%></td>
        <td>
            <form action="sDetailByM" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="查看">
            </form>
        </td>
        <td>
            <form action="" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="查看">
            </form>
        </td>
        <td>
            <form action="toSTrainByM" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="查看">
            </form>
        </td>
        <td>
            <form action="toSAttendanceByM" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="查看">
            </form>
        </td>
        <%if (state!=3){%>
        <td>
            <form action="" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="办理">
            </form>
        </td>
        <td>
            <form action="toLeave" method="post">
                <input type="hidden" name="id" value="<%=staff1.getId()%>">
                <input type="submit" value="办理">
            </form>
        </td>
        <%}%>
    </tr>
    <%
        }
    %>
</table>

<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回员工管理"/>
</form>
</body>
</html>
