<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:28
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
<div id="header">
    <div id="logo">
        <h1><a href="#">寧靜緻遠</a></h1>
        <h2><a href="#" id="metamorph">路漫漫其修远兮，吾将上下而求索</a></h2>
    </div>
    <div id="menu">
        <ul>
            <li><a href="/blog/index.jsp">博客主页</a></li>
            <li><a href="/blog/articles.jsp">博文</a></li>
            <li><a href="/blog/photos.jsp">相册</a></li>
            <!-- <li><a href="#">关于</a></li> -->
        </ul>
    </div>
    <!-- end header -->
</body>
</html>
