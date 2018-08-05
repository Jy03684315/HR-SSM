<%@ page import="com.show.model.Staff" %>
<%@ page import="com.show.utils.DoSState" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/6
  Time: 1:20
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
<%Staff staff= (Staff) request.getAttribute("s");%>
<h1>员工基本信息</h1>
    账号：<input type="text" disabled='disabled' value="<%=staff.getName()%>"/><br/>
    姓名：<input type="text" disabled='disabled' value="<%=staff.getsName()%>"/><br/>
    性别：<input type="text" disabled='disabled' value="<%=staff.getSex()%>"/><br/>
    身份证：<input type="text" disabled='disabled' value="<%=staff.getIdCard()%>"/><br/>
    生日：<input type="text" disabled='disabled' value="<%=staff.getBirth()%>"/><br/>
    毕业院校：<input type="text" disabled='disabled' value="<%=staff.getGraduation()%>"/><br/>
    学历：<input type="text" disabled='disabled' value="<%=staff.getEducation()%>"/><br/>
    相关证书：<input type="text" disabled='disabled' value="<%=staff.getCertificate()%>"/><br/>

<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回员工管理"/>
</form>
</body>
</html>
