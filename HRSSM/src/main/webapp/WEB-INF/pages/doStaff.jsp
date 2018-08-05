<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/5
  Time: 17:22
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
                    url:"sPositionsInD",
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
<%
    List<Department> departments= (List<Department>) request.getAttribute("departments");
%>
<h1>部门职位</h1>
<%int state= (int) request.getAttribute("state");%>
<%if (state==1){%>
<form action="doProbation">
<%}%>
<%if (state==2){%>
<form action="doOnJob">
<%}%>
<%if (state==3){%>
<form action="doLeaveJob">
<%}%>
    请选择部门和职位：
    <select id="selectD" name="selectD">
        <option value="0">请选择</option>
        <%for (Department department:departments){%>
            <option value="<%=department.getId()%>" ><%=department.getName()%></option>
        <%}%>
    </select>
    <select id="selectP" name="selectP">
        <option value="0">请选择</option>
    </select><br/>
    <input type="submit" value="查询员工">
</form>
<form action="staffManage" method="post">
    <input type="submit" name="返回" value="返回员工管理"/>
</form>
</body>
</html>
