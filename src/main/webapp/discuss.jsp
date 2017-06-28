<%@ page import="com.sdongwan.blog.bean.ArticleBean" %>
<%@ page import="com.sdongwan.blog.bean.DiscussBean" %>
<%@ page import="com.sdongwan.blog.bean.VisitorBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.VisitorDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.VisitorDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%
    int articleId = 0;
    articleId = Integer.parseInt(request.getParameter("articleId"));
    DiscussDao disDao = new DiscussDaoImpl();
    VisitorBean visitor = new VisitorBean();
    VisitorDao visitDao = new VisitorDaoImpl();
    ArticleBean article = null;
    ArticleDao artDao = new ArticleDaoImpl();
    article = artDao.selectById(articleId);
    List<DiscussBean> disLt = null;
    disLt = disDao.selectByArtId(articleId);
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<table width="100%" border="1" cellspacing="0" cellpadding="0" rules="rows" frame="hsides">
    <caption><font color="red"> 文章[<a
            href="Article/showArt.action?articleId=<%=articleId%>"><%=article.getArticleName() %>
    </a>]的评论列表</font></caption>
    <%for (DiscussBean disDto : disLt) { %>
    <tr><%visitor = visitDao.selectById(disDto.getVisitorId()); %>
        <td><a href="Visitor/showVisitor.action?visitorId=<%=visitor.getVisitorId() %>"><%=visitor.getVisitorName() %>
        </a>在<%=disDto.getDiscussTime()%>说：<%=disDto.getDiscuss() %>
        </td>
        <td><%if (disDto.getDiscussR() != null) {%><font color="red">博主</font>在<%=disDto.getDiscussTimeR()%>
            回复：<%=disDto.getDiscussR() %><%} else {%>
            <form action="Discuss/upDiscuss.action" method="post" name="discussR">
                <input type="text" name="disDtoUp.discussR">
                <input type="hidden" name="disDtoUp.visitorId" value="<%=disDto.getVisitorId() %>">
                <input type="hidden" name="disDtoUp.discussId" value="<%=disDto.getDiscussId() %>">
                <input type="hidden" name="disDtoUp.discuss" value="<%=disDto.getDiscuss() %>">
                <input type="hidden" name="disDtoUp.discussTime" value="<%=disDto.getDiscussTime() %>">
                <input type="hidden" name="disDtoUp.articleId" value="<%=disDto.getArticleId() %>">
                <input type="submit" value="回复"><%} %>
            </form><!-- <a href="#">回复</a> --></td>
        <td><a href="Discuss/delDiscuss.action?discussId=<%=disDto.getDiscussId() %>"
               onclick="confirm('是否确认删除?')">删除</a></td>
    </tr>
    <%} %>
</table>
</body>
</html>
