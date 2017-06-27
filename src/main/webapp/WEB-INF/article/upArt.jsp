<%@ page import="com.sdongwan.blog.bean.ArticleBean" %>
<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:11
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
<%
    int articleId = Integer.parseInt(request.getParameter("articleId"));
    System.out.println("this id " + articleId);
    ArticleBean articleBean = new ArticleBean();
    ArticleDao artDao = new ArticleDaoImpl();
    articleBean = artDao.selectById(articleId);

%>
<form id="detailForm" method="post" action="article/upArt.action">
    <input name="articleBean.articleId" type="hidden" value="<%=articleBean.getArticleId() %>">
    <input name="articleBean.articleCount" type="hidden" value="<%=articleBean.getArticleCount() %>">
    文章标题：<input name="articleBean.articleName" type="text" value="<%=articleBean.getArticleName() %>"><br>
    文章类型：
    <%
        List<ArticleTypeBean> artTypeLt = new ArrayList<ArticleTypeBean>();
        ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
        artTypeLt = artTypeDao.selectAll();
    %>
    <select id="selArtType" name="articleBean.artTypeId">
        <%for (ArticleTypeBean articleTypeDto : artTypeLt) {%>
        <option value="<%=articleTypeDto.getArtTypeId()%>"><%=articleTypeDto.getArtTypeName()%>
        </option>
        <%}%></select>
    <br>
    置顶：<input name="articleBean.articleTop" type="radio" id="0" value="0" checked="CHECKED"/>
    <label for="0">不置顶</label>
    <input type="radio" name="artDto.articleTop" id="1" value="1"/>
    <label for="1">置顶</label> <br>
    文章内容：<br>
    <textarea id="content" name="articleBean.article"><%=articleBean.getArticle()%></textarea>
    <input type="submit" value="保存" id="save"/>

</form>
</body>
</html>
