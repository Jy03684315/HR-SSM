<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/28
  Time: 15:43
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
</head>
<body>
${noCv}
<h3>添加简历</h3>
<form action="addCv" method="post">
    简历名称：<input type="text" name="cName"/><br/>
    姓名：<input type="text" name="uName"/><br/>
    性别：<input type="radio" name="sex" value="男" checked="checked">男
    <input type="radio" name="sex" value="女">女<br>
    生日：<input type="date" name="birthday"/><br/>
    身份证：<input type="text" name="idCard"/><br/>
    民族：<input type="text" name="nation"/><br/>
    政治面貌：<input type="text" name="ps"/><br/>
    身高：<input type="text" name="height"/><br/>
    毕业院校：<input type="text" name="graduation"/><br/>
    学历：<input type="text" name="education"/><br/>
    离职前所在公司：<input type="text" name="company"/><br/>
    相关证书：<input type="text" name="certificate"/><br/>
    自我评价：<input type="text" name="evaluation"/><br/>
    <input id="addCv" type="submit" value="添加">
</form>
<form action="ret" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
