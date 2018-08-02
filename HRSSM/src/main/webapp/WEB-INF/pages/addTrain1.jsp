<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 14:45
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
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<%
    List<Department> departments= (List<Department>) request.getAttribute("departments");
%>
<h3>部门培训</h3>
<table border="1" cellspacing="0">
    <tr>
        <th>部门名称</th>
        <th>选择</th>
    </tr>

<%
    for (int i=0;i<departments.size();i++){
%>
    <tr>
        <td><%=departments.get(i).getName()%></td>
        <td>
            <form action="addTrainD" method="get">
                <input type="hidden" name="id" value="<%=departments.get(i).getId()%>">
                <input type="submit" value="选择">
            </form>
        </td>
    </tr>
<%
    }
%>
</table>
<h3>新入职员工培训</h3>
<form action="addTrainS">
    <input type="submit" value="下一步">
</form>
</body>
</html>
