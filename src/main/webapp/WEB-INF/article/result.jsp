<%@ page import="com.sdongwan.blog.bean.ArticleBean" %>
<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:16
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

<div id="content">
    <s:if test="artLt==null"><h2>没有满足该条件的文章</h2>
    </s:if>
    <s:else>
        <%
            List<ArticleBean> articleLt = null;
            articleLt = (List<ArticleBean>) request.getAttribute("artLt");

        %>
        <%
            for (ArticleBean artDto : articleLt) {
                int artTypeId = artDto.getArtTypeId();
                ArticleTypeBean artTypeDto = null;
                ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
                artTypeDto = artTypeDao.selectById(artTypeId);
                DiscussDao disDao = new DiscussDaoImpl();
        %>
        <div class="post">
            <h2 class="title"><a href="#"
                                 target="_blank"><%if (artDto.getArticleTop() == 1) {%>
                [顶]<%} else { %><%} %><%=artDto.getArticleName() %>
            </a></h2>
            <p class="meta"></p>分类：<a
                href="#"><%=artTypeDto.getArtTypeName() %>
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <%=artDto.getArticleCount() %>人围观&nbsp;&nbsp;&nbsp;&nbsp;<%=disDao.getArtCount(artDto.getArticleId()) %>条评论&nbsp;&nbsp;&nbsp;&nbsp;<%=artDto.getArticleTime() %>
            <div class="entry">
                <p>
                    <font color="red">内容概要：</font><%if (artDto.getArticle().length() > 30) {%><%=artDto.getArticle().substring(0, 30)%><%} else { %><%=artDto.getArticle()%><%} %>
                </p>
                <p><a href="#%>" target="_blank"
                      style="color: grey;size: 20px">查看更多</a></p>
            </div>
        </div>
        <%}%>
    </s:else>
</div>
</body>
</html>
