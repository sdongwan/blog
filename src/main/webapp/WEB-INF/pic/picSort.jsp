<%@ page import="com.sdongwan.blog.bean.PicBean" %>
<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.PicDao" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<div id="content">
    <% PicTypeBean picTypeDto = null;
        PicTypeDao picTypeDao = new PicTypeDaoImpl();
        int picTypeId = -1;
        PicDao picDao = new PicDaoImpl();
        picTypeId = Integer.parseInt(request.getParameter("picTypeId"));
        List<PicBean> picLt = picDao.selectByTypeId(picTypeId);
        String imgPath = basePath + "upload";%>

    <%if (picLt.isEmpty() == false) { %>
    <s:iterator value="picLt" var="picDto">
        <div class="post">
            <h2 class="title"><a href="#" target="_blank">${picDto.picName}</a></h2>
            <%picTypeDto = picTypeDao.selectById(picTypeId); %>
            <p class="meta"></p>分类：<a
                href="#"><%=picTypeDto.getPicTypeName() %>
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
                ${picDto.picCount}人喜欢&nbsp;&nbsp;&nbsp;&nbsp;${picDto.picTime}
            <div class="entry">
                <img src="<%=imgPath%>/${picDto.picPath}" width="100" height="100" alt="${picDto.picDes }"/>
            </div>
        </div>
    </s:iterator>
    <%} else { %><h1>没有该类型的图片</h1><%} %>
</div>
</body>
</html>
