<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:14
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
<form action="article/upArtType.action" method="post">
    <%
        int artTypeId = Integer.parseInt((String) request.getParameter("articleTypeId"));
        ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
        ArticleTypeBean articleTypeBean = null;
        articleTypeBean = artTypeDao.selectById(artTypeId);
    %>
    <input type="hidden" name="articleTypeBean.artTypeId" value="<%=articleTypeBean.getArtTypeId()%>">
    <p align="center"><input type="text" name="articleTypeBean.artTypeName" id="artTypeName"
                             value="<%=articleTypeBean.getArtTypeName()%>"><input type="submit" value="修改"></p>

</form>
</body>
</html>
