<%@ page import="com.sdongwan.blog.bean.ArticleBean" %>
<%@ page import="com.sdongwan.blog.bean.DiscussBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%
    String visitorIdStr = request.getAttribute("visitorId").toString();
    int visitorId = Integer.parseInt(visitorIdStr);
    DiscussDao disDao = new DiscussDaoImpl();
    List<DiscussBean> disLt = null;
    disLt = disDao.selectByVisitorId(visitorId);
    ArticleBean article = null;
    ArticleDao artDao = new ArticleDaoImpl();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

<p align="center">有关<a href="Visitor/showVisitor.action?visitorId=${visitDto.visitorId}">${visitorBean.visitorName}</a>的评论内容,邮箱为${visitorBean.visitorEmail}
</p>
<table width="70%" border="1" align="center">
    <tr>
        <td>文章标题</td>
        <td>评论内容</td>
        <td width="15%">评论时间</td>
    </tr>
    <%for (DiscussBean discuss : disLt) { %>
    <tr>
        <td><%article = artDao.selectById(discuss.getArticleId()); %>
            <% if (request.getSession().getAttribute("BlogAdmin") != null) {
                if (request.getSession().getAttribute("admin").equals("blogAdmin")) {%>
            <a href="/blog/discuss.jsp?articleId=<%=discuss.getArticleId() %>"><%=article.getArticleName() %>
            </a>
            <%
                }
            } else {
            %><a href="/blog/Article/showArt.action?articleId=<%=discuss.getArticleId() %>"><%=article.getArticleName() %>
            </a><%} %>
        </td>
        <td><%=discuss.getDiscuss() %>
        </td>
        <td><%=discuss.getDiscussTime() %>
        </td>
    </tr>
    <%} %>
</table>
<input type="button" name="Submit" value="返回" onclick="javascript:window.history.back();"/>

</body>
</html>
