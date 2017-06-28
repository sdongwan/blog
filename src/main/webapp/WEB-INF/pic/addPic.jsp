<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:43
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
<form action="pic/addPic.action" enctype="multipart/form-data" method="post">
    <p align="center"><font>只能上传图片文件，且大小不超过2M</font></p>
    <p>选择图片：<input type="file" name="photo"></p>
    <p>图片类型：
        <%
            List<PicTypeBean> ptLt = new ArrayList<PicTypeBean>();
            PicTypeDao ptDao = new PicTypeDaoImpl();
            ptLt = ptDao.selectAll();
        %>

        <select id="picTypeId" name="picBean.picTypeId">
            <%for (PicTypeBean ptDto : ptLt) {%>
            <option value="<%=ptDto.getPicTypeId()%>"><%=ptDto.getPicTypeName()%>
            </option>
            <%}%></select></p>
    图片描述：<input name="picBean.picDes" type="text" id="picDes">
    <input type="submit" value="添加">
</form>
</body>
</html>
