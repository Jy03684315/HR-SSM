<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2018/7/29
  Time: 16:01
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
<h3>修改简历</h3>
<form action="updateCv" method="post">
    简历名称：<input type="text" name="cName" value="${cv.cName}"/><br/>
    姓名：<input type="text" name="uName" value="${cv.uName}"/><br/>
    性别：<input type="radio" name="sex" value="男" checked="checked">男
    <input type="radio" name="sex" value="女">女<br>
    生日：<input type="date" name="birthday" value="${cv.birth}"/><br/>
    身份证：<input type="text" name="idCard" value="${cv.idCard}"/><br/>
    民族：<input type="text" name="nation" value="${cv.nation}"/><br/>
    政治面貌：<input type="text" name="ps" value="${cv.ps}"/><br/>
    身高：<input type="text" name="height" value="${cv.height}"/><br/>
    毕业院校：<input type="text" name="graduation" value="${cv.graduation}"/><br/>
    学历：<input type="text" name="education" value="${cv.education}"/><br/>
    离职前所在公司：<input type="text" name="company" value="${cv.company}"/><br/>
    相关证书：<input type="text" name="certificate" value="${cv.certificate}"/><br/>
    自我评价：<input type="text" name="evaluation" value="${cv.evaluation}"/><br/>
    <input type="hidden" name="id" value="${cv.id}">
    <input id="updateCv" type="submit" value="提交修改">
</form>
<form action="ret" method="post">
    <input type="submit" name="返回" value="返回首页"/>
</form>
</body>
</html>
