<%@ page import="com.sdongwan.blog.bean.ArticleBean" %>
<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.bean.Page" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.PageDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PageDaoImpl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%

    PageDao pageDao = new PageDaoImpl<>();
    Page<ArticleBean> articleBeanPage = new Page<>();
    int num = 1;
    ArticleTypeDao articleTypeDao = new ArticleTypeDaoImpl();

    String pageSize = request.getParameter("pageSize");
    if (pageSize != null && !"".equals(pageSize)) {
        num = Integer.parseInt(pageSize);
    }

    ArticleDao articleDao = new ArticleDaoImpl();
    List<ArticleBean> articleBeans = null;
    try {
        articleBeans = articleDao.selectAll(num);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    articleBeanPage = pageDao.getArticle(num);
    request.setAttribute("pageList", articleBeanPage);
    ArticleTypeBean articleTypeBean = null;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<%
    for (ArticleBean articleBean : articleBeans) {
        int artTypeId = articleBean.getArtTypeId();
        DiscussDao discussDao = null;
        try {
            articleTypeBean = articleTypeDao.selectById(artTypeId);
            discussDao = new DiscussDaoImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
%>

<a href="#" target="_blank">
    <%
        if (articleBean.getArticleTop() == 1) {
    %>
    [顶]
    <%
    } else {
    %>
    ><
    <%
        }
    %>
    <%=articleBean.getArticleName()%>

</a>
<p>

</p>
分类:<a href="#"><%=articleTypeBean.getArtTypeName()%>
</a>
<%=articleBean.getArticleCount()%>人围观
<%=discussDao.getArtCount(articleBean.getArticleId())%>条评论
<%=articleBean.getArticleTime()%>
内容概要
<% if (articleBean.getArticleName().length() > 30) {


%>
<%=articleBean.getArticleName().substring(0, 30)%>
<%
} else {
%>
<%=articleBean.getArticleName()%>
<%
    }
%>
<p><a>查看更多</a></p>
<%
    }
%>

<p>有${pageList.dataCount}篇文章,${pageList.pageIndex}/${pageList.pageMax},本页有${pageList.pageCount}篇文章</p>
</body>
</html>
