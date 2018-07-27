<%@ page import="com.show.model.Recruit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %>
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
        #div1{
            width: 800px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
        }
        td{
            width: 200px;
            height: 30px;
            text-align: center;
        }
        h1{
            background-color: red;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<%
    List<Recruit> recruits= (List<Recruit>) request.getAttribute("recruits");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>薪资</th>
        <th>人数</th>
        <th>描述</th>
        <th>发布时间</th>
    </tr>
    <%
        for (int i = 0; i < recruits.size(); i++) {
    %>
    <tr>
        <td><%=recruits.get(i).getPosition().getDepartment().getName()%></td>
        <td><%=recruits.get(i).getPosition().getName()%></td>
        <td><%=recruits.get(i).getSalary()%></td>
        <td><%=recruits.get(i).getNumber()%></td>
        <td><%=recruits.get(i).getDescription()%></td>
        <td><%=recruits.get(i).getDate()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
