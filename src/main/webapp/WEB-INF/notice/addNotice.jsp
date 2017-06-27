<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:42
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
<form action="notice/addNotice.action" method="post">
    公告名称：<input type="text" name="noticeBean.noticeName"> <br>
    公告内容：<textarea id="content" name="noticeBean.notice"></textarea>
    <input type="submit" value="保存" id="save"/>
</form>
</body>
</html>
