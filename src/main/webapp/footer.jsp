<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:27
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
<div id="footer">
    <p>Copyright &copy; 2009.All Rights Reserved
        <br/><a href="http://www.itzcn.com">汇智科技</a> 版权所有</p>
    <p align="center"><a href="/blog/Admin_login.jsp" target="_blank">后台登录</a></p>
</div>
</body>
</html>
