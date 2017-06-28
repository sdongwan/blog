<%@ page import="com.sdongwan.blog.bean.PicBean" %>
<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.PicDao" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:05
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
<form action="/pic/upPic.action" method="post">
    <%
        int picId = Integer.parseInt(request.getParameter("picId"));
        PicDao picDao = new PicDaoImpl();
        PicBean picDto = null;
        picDto = picDao.selectById(picId);
    %>
    <input type="hidden" name="picBean.picCount" id="picId" value="<%=picDto.getPicCount()%>">
    <input type="hidden" name="picBean.picId" id="picId" value="<%=picDto.getPicId()%>">
    <input type="hidden" name="picBean.picPath" id="picPath" value="<%=picDto.getPicPath()%>">
    <p align="center">修改图片名称：<input type="text" name="picBean.picName" id="picName"
                                    value="<%=picDto.getPicName()%>"><br>
        修改图片描述：<input type="text" name="picBean.picDes" id="picDes" value="<%=picDto.getPicDes()%>"><br>
        修改图片类型：<%
            List<PicTypeBean> picTypeLt = new ArrayList<PicTypeBean>();
            PicTypeDao picTypeDao = new PicTypeDaoImpl();
            picTypeLt = picTypeDao.selectAll();
        %>
        <select id="selArtType" name="picBean.picTypeId">
            <%for (PicTypeBean picTypeDto : picTypeLt) {%>
            <option value="<%=picTypeDto.getPicTypeId()%>"><%=picTypeDto.getPicTypeName()%>
            </option>
            <%}%></select>
        <input type="submit" value="修改"></p>
</form>
</body>
</html>
