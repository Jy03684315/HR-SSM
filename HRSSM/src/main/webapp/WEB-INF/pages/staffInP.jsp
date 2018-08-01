<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/1
  Time: 22:48
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
        th{
            width: 100px;
            height: 15px;
        }
        td{
            width: 100px;
            height: 15px;
        }
        h1{
            background-color: lightskyblue;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<%
    List<Staff> staff= (List<Staff>) request.getAttribute("s");
%>
<h1>职员列表</h1>
<table border="1" cellspacing="0">
    <tr>
        <th>员工姓名</th>
        <th>入职日期</th>
        <th>性别</th>
        <th>生日</th>
        <th>学历</th>
        <th>毕业院校</th>
    </tr>
    <%
        for (int i = 0; i < staff.size(); i++) {
    %>
    <tr>
        <td><%=staff.get(i).getsName()%></td>
        <td><%=staff.get(i).getDate()%></td>
        <td><%=staff.get(i).getSex()%></td>
        <td><%=staff.get(i).getBirth()%></td>
        <td><%=staff.get(i).getEducation()%></td>
        <td><%=staff.get(i).getGraduation()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
