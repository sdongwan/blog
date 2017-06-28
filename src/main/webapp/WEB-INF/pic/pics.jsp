<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.sdongwan.blog.bean.PicBean" %>
<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:59
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
<table width="100%" border="1">
    <tr>
        <td>图片名称</td>
        <td>图片类型</td>
        <td>上传时间</td>
        <td>路径</td>
        <td>描述</td>
        <td>喜欢度</td>
        <td width="15%">操作</td>
    </tr>
    <s:iterator value="picBeans" var="picDto">
        <tr>
            <%
                PicTypeBean ptDto = null;
                PicTypeDao ptDao = new PicTypeDaoImpl();
                int picTypleId = -1;
                picTypleId = ((PicBean) request.getAttribute("picDto")).getPicTypeId();
                ptDto = ptDao.selectById(picTypleId);
            %>
            <td>${picDto.picName}</td>
            <td><%=ptDto.getPicTypeName() %>
            </td>
            <td>${picDto.picTime}</td>
            <td>${picDto.picPath}</td>
            <td>${picDto.picDes}</td>
            <td>${picDto.picCount}</td>
            <td><a href="/pic/toUpPic.action?picId=${picDto.picId}">编辑</a>
                |<a href="/pic/delPic.action?picId=${picDto.picId}">删除</a>
                |<a href="/pic/showPic.action?picId=${picDto.picId}" onclick="return confirm('确定要删除吗？')">查看图片</a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
