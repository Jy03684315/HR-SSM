<%@ page import="com.show.model.Position" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 3:03
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
<h1>职位列表</h1>
<%
    List<Position> positions= (List<Position>) request.getAttribute("positions");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>职位名称</th>
        <th>基本薪资</th>
        <th>所属部门</th>
        <th>职位修改</th>
        <th>职位删除</th>
    </tr>
    <%
        for (int i = 0; i < positions.size(); i++) {
    %>
    <tr>
        <td><%=positions.get(i).getName()%></td>
        <td><%=positions.get(i).getSalary()%></td>
        <td><%=positions.get(i).getDepartment().getName()%></td>
        <td>
            <form action="toUpdatePosition" method="post">
                <input type="hidden" name="id" value="<%=positions.get(i).getId()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="deletePosition" method="post">
                <input type="hidden" name="id" value="<%=positions.get(i).getId()%>">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<form action="listDepartment" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
