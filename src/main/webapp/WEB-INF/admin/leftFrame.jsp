<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<table border="0" style="height: 100%;" cellspacing="0" cellpadding="0">
    <tr>
        <td valign="middle" bgcolor="#000" id="menuSwitch" style="cursor:hand"></td>
    </tr>
</table>

</body>
</html>
