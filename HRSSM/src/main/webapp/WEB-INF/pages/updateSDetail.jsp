<%@ page import="com.show.utils.DoSState" %>
<%@ page import="com.show.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 15:18
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
<%Staff staff= (Staff) session.getAttribute("s");%>
<h1>个人信息</h1>
<form action="updateSDetail" method="post">
    账号：<input type="text" disabled='disabled' value="${sessionScope.get("s").getName()}"/><br/>
    状态：<input type="text" name="state" disabled='disabled' value="<%=DoSState.getState(staff.getState())%>"/><br/>
    部门：<input type="text" disabled='disabled' value="<%=staff.getPosition().getDepartment().getName()%>"/><br/>
    职位：<input type="text" disabled='disabled' value="<%=staff.getPosition().getName()%>"/><br/>
    姓名：<input type="text" name="sName" value="<%=staff.getsName()%>"/><br/>
    性别：<input type="text" name="sex" value="<%=staff.getSex()%>"/><br/>
    身份证：<input type="text" name="idCard" value="<%=staff.getIdCard()%>"/><br/>
    生日：<input type="date" name="sBirth" value="<%=staff.getBirth()%>"/><br/>
    毕业院校：<input type="text" name="graduation" value="<%=staff.getGraduation()%>"/><br/>
    学历：<input type="text" name="education" value="<%=staff.getEducation()%>"/><br/>
    相关证书：<input type="text" name="certificate" value="<%=staff.getCertificate()%>"/><br/>
    <input type="hidden" name="id" value="<%=staff.getId()%>">
    <input type="submit" value="提交修改">
</form>
<form action="toStaffConsole" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
