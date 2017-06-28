<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:18
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
<table border="1" width="60%" align="center">
    <tr>
        <td><font color="red">文章类型名称</font></td>
        <td width="10%">删除</td>
        <td width="10%">编辑</td>
    </tr>
    <s:iterator value="articleTypeBeans" var="artTypeBeanItem">
        <tr>
            <s:if test="#articleTypeBean.artTypeId==1">
                <td>${artTypeBeanItem.artTypeName}</td>
                <td>删除</td>
                <td>编辑</td>
            </s:if>
        </tr>
        <s:else>
            <tr>
                <td>${artTypeBeanItem.artTypeName}</td>
                <td><a href="<%=basePath%>article/delArtType.action?articleTypeId=${artTypeBeanItem.artTypeId}"
                       onclick="return confirm('是否确认删除？')">删除</a></td>
                <td><a href="<%=basePath%>article/upMyArtType.action?articleTypeId=${artTypeBeanItem.artTypeId}">编辑</a>
                </td>
            </tr>
        </s:else>
    </s:iterator>
</table>

<form action="<%=basePath%>article/addArtType.action" method="post">
    <p align="center">添加文章类型：
        <input type="text" name="articleTypeBean.artTypeName" id="artTypeName">
        <input type="submit"/>
    </p>
</form>

</body>
</html>
