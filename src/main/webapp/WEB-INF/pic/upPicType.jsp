<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:07
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
<form action="pic/upPicType.action" method="post">
    <%
        int picTypeId = Integer.parseInt(request.getParameter("picTypeId"));
        PicTypeDao ptDao = new PicTypeDaoImpl();
        PicTypeBean ptDto = null;
        ptDto = ptDao.selectById(picTypeId);
    %>

    <input type="hidden" name="picTypeBean.picTypeId" id="picTypeId" value="<%=ptDto.getPicTypeId()%>">
    <p align="center">修改图片类型：
        <input type="text" name="picTypeBean.picTypeName" id="picTypeName" value="<%=ptDto.getPicTypeName()%>">
        <input type="submit" value="修改"></p>
</form>

</body>
</html>
