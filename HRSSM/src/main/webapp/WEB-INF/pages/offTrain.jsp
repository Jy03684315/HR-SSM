<%@ page import="com.show.model.Train" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/2
  Time: 23:40
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
<h1>未发布培训信息</h1>
<%
    List<Train> trains= (List<Train>) request.getAttribute("trains");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>主题</th>
        <th>内容</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>发布时间</th>
        <th>发布</th>
        <th>修改</th>
    </tr>
    <%
        for (Train train : trains) {
    %>
    <tr>
        <td><%=train.getTheme()%></td>
        <td><%=train.getContent()%></td>
        <td><%=train.getBegin()%></td>
        <td><%=train.getEnd()%></td>
        <td><%=train.getTime()%></td>
        <td>
            <form action="deliverT" method="post">
                <input type="hidden" name="id" value="<%=train.getId()%>">
                <input type="submit" value="发布">
            </form>
        </td>
        <td>
            <form action="toUpdateT" method="post">
                <input type="hidden" name="id" value="<%=train.getId()%>">
                <input type="submit" value="修改">
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
