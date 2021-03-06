<%@ page import="com.show.model.Train" %>
<%@ page import="java.util.List" %>
<%@ page import="com.show.utils.DoTState" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/6
  Time: 1:49
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
<h1>员工培训</h1>
<%
    List<Train> trains= (List<Train>) request.getAttribute("trains");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>培训主题</th>
        <th>培训内容</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>发布时间</th>
        <th>发布状态</th>
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
        <td><%=DoTState.getTState(train.getState())%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="sTrainByM?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回员工管理"/>
</form>
</body>
</html>
