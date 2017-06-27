<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%
    ArticleTypeDao articleTypeDao = new ArticleTypeDaoImpl();
    ArticleDao articleDao = new ArticleDaoImpl();
    DiscussDao discussDao = new DiscussDaoImpl();
    int articleTypeId = -1;
    articleTypeId = Integer.parseInt(request.getAttribute("artTypeId").toString());
    int articleId = -1;

    ArticleTypeBean articleTypeBean = null;


%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

<s:if test="artLt.isEmpty==false">
    <s:iterator value="artLt" var="artDto">
        <%
            articleId = Integer.parseInt(request.getAttribute(
                    "articleId").toString());
        %>

        <div class="post">
            <h2 class="title">
                <a href="#" target="_blank">
                    <s:if test="#artDto.articleTop==1">
                        [顶]
                    </s:if>${artDto.articleName}
                </a>
            </h2>
            <%
                articleTypeBean = articleTypeDao.selectById(articleTypeId);
            %>
            <p class="meta"></p>
            分类：<a href=""><%=articleTypeBean.getArtTypeName()%>
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
                ${art.articleCount}人围观&nbsp;&nbsp;&nbsp;&nbsp;<%=discussDao.getArtCount(articleId)%>条评论&nbsp;&nbsp;&nbsp;&nbsp;<%=articleDao.selectById(articleId).getArticleTime()%>
            <div class="entry">
                <p>
                    <font color="red">内容概要：</font>
                    <%
                        if (articleDao.selectById(articleId).getArticle().length() > 30) {
                    %><%=articleDao.selectById(articleId).getArticle()
                        .substring(0, 30)%>
                    <%
                    } else {
                    %><%=articleDao.selectById(articleId).getArticle()%>
                    <%
                        }
                    %>
                </p>
                <p>
                    <a href="" target="_blank">查看更多</a>
                </p>
            </div>
        </div>


    </s:iterator>

</s:if>
</body>
</html>
