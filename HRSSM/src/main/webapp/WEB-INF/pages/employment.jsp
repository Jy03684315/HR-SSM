<%@ page import="com.show.model.Interview" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/1
  Time: 0:52
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
<h1>待录用面试申请</h1>
<%
    List<Interview> interviews= (List<Interview>) request.getAttribute("interviews");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<table border="1" cellspacing="0">
    <tr>
        <th>应聘部门</th>
        <th>应聘职位</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
        <th>学历</th>
        <th>详细信息</th>
        <th>批准录用</th>
    </tr>
    <%
        for (Interview interview : interviews) {
    %>
    <tr>
        <td><%=interview.getRecruit().getPosition().getDepartment().getName()%></td>
        <td><%=interview.getRecruit().getPosition().getName()%></td>
        <td><%=interview.getCv().getuName()%></td>
        <td><%=interview.getCv().getSex()%></td>
        <td><%=interview.getCv().getBirth()%></td>
        <td><%=interview.getCv().getEducation()%></td>
        <td>
            <form action="itvDetail" method="get">
                <input type="hidden" name="id" value="<%=interview.getId()%>">
                <input type="submit" value="查看">
            </form>
        </td>
        <td>
            <form action="" method="post">
                <input type="hidden" name="id" value="<%=interview.getId()%>">
                <input type="submit" value="录用">
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
<a href="employment?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
