<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:03
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
<table border="1" align="center">
    <tr>
        <td><font color="red">&nbsp;图片类型名称</font></td>
        <td width="10%"><font color="red">删除</font></td>
        <td width="10%"><font color="red">编辑</font></td>
    </tr>
    <s:iterator value="picTypeBeans" var="ptDto">
        <tr>
                <%--<s:if test="#ptDto.picTypeId==1">--%>
            <td>${ptDto.picTypeName}</td>
            <td><a href="pic/delPicType.action?picTypeId=${ptDto.picTypeId}">删除</a></td>
            <td><a href="pic/upPhotoType.action?picTypeId=${ptDto.picTypeId}">编辑</a></td>
                <%--</s:if>--%>
        </tr>

        <%--<s:else>--%>
        <%--<tr>--%>
        <%--<td>${ptDto.picTypeName}</td>--%>
        <%--<td><a href="#">删除</a></td>--%>
        <%--<td><a href="#">编辑</a></td>--%>
        <%--</tr>--%>
        <%--</s:else>--%>
    </s:iterator>
</table>

<form action="pic/addPicType.action" method="post">
    <p align="center">添加图片类型：<input type="text" name="picTypeBean.picTypeName" id="picTypeName">
        <input type="submit" value="添加">
    </p>
</form>

</body>
</html>
