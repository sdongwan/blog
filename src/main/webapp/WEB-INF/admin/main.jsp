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
    <title>main.jsp</title>
</head>
<body>
<% if (request.getSession().getAttribute("BlogAdmin") != null) {
    if (request.getSession().getAttribute("admin").equals("blogAdmin")) {
        out.print("<script language=javascript>alert('登录成功！')</script>");%>

<h1 align="center">欢迎博客管理员<%=session.getAttribute("BlogAdmin") %>登录</h1>
<p align="center"><br>
    尊敬的管理员，您可以进行文章管理、相册管理、公告管理
    、友情链接管理和访客管理等功能。</p>
<p align="center">(注：如果您非系统管理员，请勿进行操作！) </p>
<%
    }
} else {
    response.setHeader("refresh", "0.3;URL=/admin/adminLogin.jsp");
%>
<h1>您还未登录，请先登录！！！</h1>
<% } %>

</body>
</html>
