<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 0:22
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
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#selectD").change(function () {
                var department={id:$("#selectD option:selected").val()};
                $.ajax({
                    type:"post",
                    url:"positionsInD",
                    data:department,
                    success:function (data) {
                        $("#selectP").empty();
                        $(data).each(function () {
                            $("#selectP").append("<option value="+this.id+">"+this.name+"</option>")
                        })
                    }
                });
            });
        })
    </script>
</head>
<body>
<h1>查询部门职位员工</h1>
<form action="selectS1">
    请选择部门和职位：
    <select id="selectD" name="selectD">
        <option value="0">请选择</option>
        <c:forEach var="i" begin="0" end="${fn:length(requestScope.departments)-1}">
            <option value="${departments.get(i).id}" >${departments.get(i).name}</option>
        </c:forEach>
    </select>
    <select id="selectP" name="selectP">
        <option value="0">请选择</option>
    </select><br/>
    <input type="submit" value="查询员工">
</form>
<%
    if (session.getAttribute("staff")!=null){
%>
<table>
    <tr>
        <th>员工姓名</th>
        <th>员工性别</th>
        <th>员工生日</th>
        <th>员工身份证</th>
    </tr>
    <c:forEach var="i" begin="0" end="${fn:length(sessionScope.get('staff'))-1}">
        <tr>
            <td>${sessionScope.get("staff").get(i).getsName()}</td>
            <td>${sessionScope.get("staff").get(i).getSex()}</td>
            <td>${sessionScope.get("staff").get(i).getBirth()}</td>
            <td>${sessionScope.get("staff").get(i).getIdCard()}</td>
        </tr>
    </c:forEach>
</table>
<%
    }
%>
</body>
</html>
