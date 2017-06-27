<%@ page import="com.sdongwan.blog.bean.NoticeBean" %>
<%@ page import="com.sdongwan.blog.dao.NoticeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.NoticeDaoImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%
    NoticeDao noticeDao = new NoticeDaoImpl();
    NoticeBean noticeBean = noticeDao.selectById(Integer.parseInt(request.getParameter("noticeId")));
    request.setAttribute("noticeBean", noticeBean);
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="notice/upNotice.action" method="post">&nbsp;
    <input type="hidden" name="noticeBean.noticeId" value="${noticeBean.noticeId }">
    公告名称：<input type="text" name="noticeBean.noticeName" value="${noticeBean.noticeName }"> <br>
    公告内容：<textarea id="content" name="noticeBean.notice">${noticeBean.notice }</textarea>
    <input type="submit" value="保存" id="save"/>
</form>
</body>
</html>
