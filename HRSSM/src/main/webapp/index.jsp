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
<%
    List<> userDetails = (List<>) request.getAttribute("");
    User user= (User) session.getAttribute("u");
%>
<table>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (:) {
    %>
    <tr>
        <td><%=%></td>
        <td><%=%></td>
        <td><%=%></td>
        <td><%=%></td>

        <td>
            <form action=">
                <input name="" type="hidden" value="<%=%>">
                <input type="submit" value="">
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
