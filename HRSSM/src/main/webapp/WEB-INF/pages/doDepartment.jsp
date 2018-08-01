<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/1
  Time: 23:39
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
<h1>部门列表</h1>
<%
    List<Department> departments= (List<Department>) request.getAttribute("departments");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>部门名称</th>
        <th>创建时间</th>
        <th>部门修改</th>
        <th>部门删除</th>
        <th>在该部门下添加职位</th>
    </tr>
    <%
        for (int i = 0; i < departments.size(); i++) {
    %>
    <tr>
        <td><%=departments.get(i).getName()%></td>
        <td><%=departments.get(i).getDate()%></td>
        <td>
            <form action="toUpdateDepartment" method="post">
                <input type="hidden" name="id" value="<%=departments.get(i).getId()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="deleteDepartment" method="post">
                <input type="hidden" name="id" value="<%=departments.get(i).getId()%>">
                <input type="submit" value="删除">
            </form>
        </td>
        <td>
            <form action="toAddPosition" method="post">
                <input type="hidden" name="id" value="<%=departments.get(i).getId()%>">
                <input type="submit" value="添加">
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
${fail}
<form action="listDepartment" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
