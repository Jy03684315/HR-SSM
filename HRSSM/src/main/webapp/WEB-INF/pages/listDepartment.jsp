<%@ page import="java.util.List" %>
<%@ page import="com.show.model.Department" %>
<%@ page import="com.show.model.Position" %><%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/8/1
  Time: 15:35
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
        th{
            width: 100px;
            height: 15px;
        }
        td{
            width: 100px;
            height: 15px;
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
            $("#cd").change(function () {
                var department={id:$("#cd option:selected").val()};
                $.ajax({
                    type:"post",
                    url:"positionsInD",
                    data:department,
                    success:function (data) {
                        $("#t1").empty();
                        $(data).each(function () {
                            $("#t1").append("<tr>"+"<td>"+this.name+"</td>"+"<td>"+this.salary+"</td>"+
                                "<td>"+"<form action='staffInP'>"+"<input type='hidden' name='id' value='"+this.id+"'>"+"<input type='submit' value='查看职员'>"+"</form>"+"</td>"+"</tr>")
                        })
                    }
                })
            });
        })
    </script>
</head>
<body>
<h1>部门职位管理</h1>
<h3>添加部门</h3>
<form action="addDepartment" method="post">
    部门名称：<input id="name" type="text" name="name"/><br/>
    ${fail}
    <input type="submit" value="添加">
</form>
<a href="doDepartment">部门删改及职位添加</a><br/>
<a href="doPosition">职位删改</a><br/>
<%
    List<Department> departments= (List<Department>) session.getAttribute("departments");
%>
选择部门：<select id="cd">
<%
    for (int i=0;i<departments.size();i++) {
%>
    <option value="<%=departments.get(i).getId()%>"><%=departments.get(i).getName()%></option>
<%
    }
%>
</select>
<table border="1" cellspacing="0">
    <tr>
        <th>职位名</th>
        <th>薪资</th>
        <th>查看职员</th>
    </tr>
</table>
<table id="t1" border="1" cellspacing="0"></table>
<form action="mConsole" method="post">
    <input type="submit" name="返回" value="返回上一页"/>
</form>
</body>
</html>
