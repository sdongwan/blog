<%@ page language="java" import="com.blog.dao.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.blog.daoImpl.*" %>
<%@ page import="com.blog.dto.*" %>
<%@ page import="com.blog.util.*" %>
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
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <base href="<%=basePath%>"/>
    <title>我的博客</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>

</head>
<body>
<%
    PageDao ipage = new PageDaoImpl<>();
    Page<ArticleBean> pages = new Page<ArticleBean>();
    int num = 1;
    ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
    String pageSize = request.getParameter("pageSize");
    if (pageSize != null && !"".equals(pageSize)) {
        num = Integer.parseInt(pageSize);
    }
    List<ArticleBean> artLt = null;
    ArticleDao artDao = new ArticleDaoImpl();
    artLt = artDao.selectAll(num);
    ArticleTypeBean artTypeDto = null;

    pages = ipage.getArticle(num);
    request.setAttribute("pagerList", pages);

%>
<div id="content">
    <%
        for (ArticleBean artDto : artLt) {
            int artTypeId = artDto.getArtTypeId();
            artTypeDto = artTypeDao.selectById(artTypeId);
            DiscussDao disDao = new DiscussDaoImpl();
    %>
    <div class="post">
        <h2 class="title"><a href="article/showArt.action?articleId=<%=artDto.getArticleId()%>"
                             target="_blank"><%if (artDto.getArticleTop() == 1) {%>
            [顶]<%} else { %><%} %><%=artDto.getArticleName() %>
        </a></h2>
        <p class="meta"></p>分类：<a
            href="article/showArtByType.action?artTypeId=<%=artDto.getArtTypeId()%>"><%=artTypeDto.getArtTypeName() %>
    </a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%=artDto.getArticleCount() %>人围观&nbsp;&nbsp;&nbsp;&nbsp;<%=disDao.getArtCount(artDto.getArticleId()) %>条评论&nbsp;&nbsp;&nbsp;&nbsp;<%=artDto.getArticleTime() %>
        <div class="entry">
            <p>
                <font color="red">内容概要：</font><%if (artDto.getArticle().length() > 30) {%><%=artDto.getArticle().substring(0, 30)%><%} else { %><%=artDto.getArticle()%><%} %>
            </p>
            <p><a href="article/showArt.action?articleId=<%=artDto.getArticleId()%>" target="_blank"
                  style="color: grey;size: 20px">查看更多</a></p>
        </div>
    </div>
    <%}%>
    <c:choose>
        <c:when
                test="${pagerList.pageIndex <= 0 ||pagerList.pageIndex > pagerList.pageMax}">
            <c:catch></c:catch>
        </c:when>
        <c:otherwise>
            <form name="form1" method="post" action="articles.jsp">
                <table width="90%" border="0">

                    <tr>
                        <td><a href="articles.jsp?pageSize=1">第一页</a></td>
                        <c:choose>
                            <c:when
                                    test="${pagerList.pageIndex <= pagerList.pageMax  && pagerList.pageIndex > 1}">
                                <c:catch>
                                    <td><a href="articles.jsp?pageSize=${pagerList.pageIndex -1}">上一页</a></td>
                                </c:catch>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                        <td><c:forEach begin="1" end="${pagerList.pageMax}" step="1"
                                       var="toPage">
                            <c:choose>
                                <c:when test="${pagerList.pageIndex == toPage}">
                                    <c:catch>${toPage}</c:catch>
                                </c:when>
                                <c:otherwise>
                                    <a href="articles.jsp?pageSize=${toPage}">${toPage}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach></td>
                        <c:choose>
                            <c:when
                                    test="${pagerList.pageIndex < pagerList.pageMax && pagerList.pageIndex >0}">
                                <c:catch>
                                    <td><a href="articles.jsp?pageSize=${pagerList.pageIndex + 1}">下一页</a></td>
                                </c:catch>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                        <td><a href="articles.jsp?pageSize=${pagerList.pageMax}">最后一页</a>
                        </td>
                        <td><select name="pageSize"
                                    id="pageSize">
                            <c:forEach begin="1" end="${pagerList.pageMax}" step="1"
                                       var="toPage">
                                <c:choose>
                                    <c:when test="${pagerList.pageIndex == toPage}">
                                        <c:catch>
                                            <option selected="selected">${pagerList.pageIndex}</option>
                                        </c:catch>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${toPage}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select></td>
                        <td><input type="submit" name="button" id="button" value="跳转"></td>
                    </tr>
                </table>
            </form>
        </c:otherwise>
    </c:choose>
    <p>有${pagerList.dateCount}篇文章,${pagerList.pageIndex}/${pagerList.pageMax},本页${pagerList.pageCount}篇文章</p>
</div>
</body>
</html>
