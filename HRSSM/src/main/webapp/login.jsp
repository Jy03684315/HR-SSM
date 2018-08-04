<%@ page import="com.show.model.Recruit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %>
<%@ page import="com.show.model.User" %>
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
            background-color: lightskyblue;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<h1>招聘信息</h1>
<%
    List<Recruit> recruits= (List<Recruit>) request.getAttribute("recruits");
    int totalPages= (int) request.getAttribute("totalPages");
    User user= (User) session.getAttribute("u");
%>
<% if (user==null){ %>
<form action="toLogin" method="post" style="margin:0;display:inline;">
    <input id="login" type="submit" value="游客登录">
</form>
<form action="toRegister" style="margin:0;display:inline;">
    <input id="register" type="submit" value="注册">
</form>
<form action="toMLogin" method="post" style="margin:0;display:inline;">
    <input id="mLogin" type="submit" value="管理员登录">
</form>
<form action="toSLogin" method="post" style="margin:0;display:inline;">
    <input id="sLogin" type="submit" value="员工登录">
</form>
<% }else{ %>
<span>欢迎${sessionScope.get("u").getName()}</span>
<form action="CvList" style="margin:0;display:inline;">
    <input type="submit" value="浏览简历">
</form>
<form action="checkItv" style="margin:0;display:inline;">
    <input type="submit" value="查看面试邀请">
</form>
<form action="logout" style="margin:0;display:inline;">
    <input type="submit" value="注销用户">
</form>
<% } %>
<table border="1" cellspacing="0">
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>薪资</th>
        <th>人数</th>
        <th>描述</th>
        <th>发布时间</th>
        <% if (user!=null){ %>
        <th>投递</th>
        <% } %>
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
        <% if (user!=null){ %>
        <td>
            <form action="deliverCv" method="post">
                <input type="hidden" name="id" value="<%=recruits.get(i).getId()%>">
                <input type="submit" value="投递">
            </form>
        </td>
        <% } %>
    </tr>
    <%
        }
    %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
</body>
</html>
