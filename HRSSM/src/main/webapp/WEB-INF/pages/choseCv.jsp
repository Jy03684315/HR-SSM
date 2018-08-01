<%@ page import="com.show.model.Recruit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Cv" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/28
  Time: 10:55
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
<h1>选择简历</h1>
<%
    List<Cv> cvs= (List<Cv>) request.getAttribute("cvs");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>简历名称</th>
        <th>简历详情</th>
        <th>简历投递</th>
    </tr>
    <%
        for (int i = 0; i < cvs.size(); i++) {
    %>
    <tr>
        <td><%=cvs.get(i).getcName()%></td>
        <td>
            <form action="cvDetail" method="get">
                <input type="hidden" name="id" value="<%=cvs.get(i).getId()%>">
                <input type="submit" value="简历详情">
            </form>
        </td>
        <td>
            <form action="addInterview" method="post">
            <input type="hidden" name="id" value="<%=cvs.get(i).getId()%>">
            <input type="submit" value="选择">
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
<a href="deliverCv?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="ret" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
