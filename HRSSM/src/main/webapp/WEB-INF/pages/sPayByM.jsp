<%@ page import="com.show.model.Pay" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/7
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
<%
    List<Pay> pays= (List<Pay>) request.getAttribute("pays");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<h1>薪资记录</h1>
<table border="1" cellspacing="0">
    <tr>
        <th>日期</th>
        <th>基本工资</th>
        <th>绩效奖金</th>
        <th>加班费</th>
        <th>奖惩</th>
        <th>社保</th>
        <th>复议</th>
    </tr>
    <tr>
        <%
            for (Pay pay:pays){
        %>
        <td><%=pay.getYear()%>年<%=pay.getMonth()%>月</td>
        <td><%=pay.getBase()%></td>
        <td><%=pay.getBonus()%></td>
        <td><%=pay.getOv()%></td>
        <td><%=pay.getRew()%></td>
        <td><%=pay.getSs()%></td>
        <%if (pay.getIntro()==null){%>
        <td>无</td>
        <%}else {%>
        <td>
            <%=pay.getIntro()%>
        </td>
        <%}%>
        <%
            }
        %>
    </tr>
</table>
<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="sPayByM?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回员工管理"/>
</form>
</body>
</html>
