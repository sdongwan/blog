<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 17:58
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
<form name="formSearch" method="post" action="#" id="formSearch">
    文章名字
    <input type="text" name="searchArt.articleName" id="articleName">

    文章类型
    <%
        List<ArticleTypeBean> artTypeLt = new ArrayList<ArticleTypeBean>();
        ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
        artTypeLt = artTypeDao.selectAll();
    %>
    <select id="selArtType" name="searchArt.artTypeId">
        <option selected="selected" value="-1">不限</option>
        <%for (ArticleTypeBean articleTypeDto : artTypeLt) {%>
        <option value="<%=articleTypeDto.getArtTypeId()%>"><%=articleTypeDto.getArtTypeName()%>
        </option>
        <%}%></select>
    <input name=searchArt.articleTop type="radio" id="0" value="0"/>
    <label for="0">不置顶</label>
    <input type="radio" name="searchArt.articleTop" id="1" value="1"/>
    <label for="1">置顶</label>
    <input type="submit" name="Submit4" value="搜索">
</form>
</body>
</html>
