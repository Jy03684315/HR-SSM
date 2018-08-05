<%@ page import="com.show.model.Attendance" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 16:58
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
<h1>考勤记录</h1>
<form action="attendanceInS">
    请输入需要查询的月份<input type="number" name="month">
    <input type="submit" value="提交">
</form>
<%
    List<Attendance> attendances= (List<Attendance>) request.getAttribute("attendances");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>考勤日期</th>
        <th>上班时间</th>
        <th>下班时间</th>
    </tr>
    <%
        for (Attendance attendance : attendances) {
    %>
    <tr>
        <td><%=attendance.getMonth()%>月<%=attendance.getDay()%>日</td>
        <td><%=attendance.getOnTime()%></td>
        <%
            if (attendance.getOffTime()==null){
        %>
        <td>未打卡</td>
        <%
            }else {
        %>
        <td><%=attendance.getOffTime()%></td>
        <%
            }
        %>
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
