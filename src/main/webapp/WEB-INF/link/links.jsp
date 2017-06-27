<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:12
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
<p align="center"> 管理友情链接</p>
<table width="50%" border="1" align="center">
    <tr>
        <th width="10%">名称</th>
        <th align="center" width="30%">地址</th>
        <th width="10%">操作</th>
    </tr>
    <s:iterator value="linkBeans" var="link">
        <tr>
            <td>${link.linkName}</td>
            <td>${link.linkUrl}</td>
            <td><a href="link/upMyLink.action?linkId=${link.linkId}">修改</a>&nbsp;&nbsp;
                <a href="link/delLink.action?linkId=${link.linkId}" onclick="return confirm('是否确认删除？')">删除</a></td>
        </tr>
    </s:iterator>
</table>

<p align="center"> 添加友情链接</p>
<form id="form1" name="form1" method="post" action="link/addLink.action">
    <table width="400" border="0" align="center">
        <tr>
            <td width="123">友情链接名字：</td>
            <td colspan="3"><label for="linkBean.linkName"></label>
                <input width="120px" type="text" name="linkBean.linkName" id="linkBean.linkName"/></td>
        </tr>
        <tr>
            <td width="123">友情链接地址：</td>
            <td colspan="3"><label for="linkBean.linkUrl"></label>
                <input width="122px" type="text" name="linkBean.linkUrl" id="linkBean.linkUrl"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="reset" name="Submit" value="重置">
                <input type="submit" name="Submit2" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
