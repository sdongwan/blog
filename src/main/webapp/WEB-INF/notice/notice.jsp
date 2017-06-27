<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>notice.jsp</title>
</head>
<body>
<strong>公告名称：</strong>${noticeBean.noticeName}<br>
<strong>公告发布时间:</strong>${noticeBean.noticeTime}<br>
<strong>公告内容:</strong>${noticeBean.notice}
<input type="button" name="Submit" value="返回" onclick="javascript:window.history.back();"/>
</body>
</html>
