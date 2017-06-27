<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:23
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
    <title>Title</title>
</head>
<body>
<p align="center"> 访客管理</p>
<table width="70%" border="1" align="center">
    <tr>
        <td width="15%" align="center">访客昵称</td>
        <td align="center">Ip</td>
        <td align="center">邮箱</td>
        <td align="center">评论数</td>
        <td width="15%" align="center">操作</td>
    </tr>
    <s:iterator value="visitorBeans" var="visitDto">
        <tr>
            <%
                String visitorIdStr = request.getAttribute("visitorId").toString();
                int visitorId = Integer.parseInt(visitorIdStr);
                DiscussDao disDao = new DiscussDaoImpl();
            %>
            <td><a href="visitor/showVisitor.action?visitorId=${visitDto.visitorId}">${visitDto.visitorName}</a></td>
            <td>${visitDto.visitorIp}</td>
            <td>${visitDto.visitorEmail}</td>
            <td><a href="visitor/showVisitor.action?visitorId=${visitDto.visitorId}"><%= disDao.getCount(visitorId)%>
            </a></td>
            <td><a href="visitor/showVisitor.action?visitorId=${visitDto.visitorId}">查看详细</a>&nbsp;&nbsp;
                <a href="visitor/delVisitor.action?visitorId=${visitDto.visitorId}" onclick="confirm('是否确认删除？')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
