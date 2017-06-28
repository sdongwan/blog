<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleTypeDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:06
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
<table width="100%" border="1">
    <tr>
        <td>文章类型</td>
        <td>文章名称</td>
        <td>发表时间</td>
        <td>是否置顶</td>
        <td>访问数量</td>
        <td>评论数量</td>
        <td width="15%">操作</td>
    </tr>
    <s:iterator value="articleBeans" var="articleDto">
        <tr>
            <%
                ArticleTypeBean artTDto = null;
                ArticleTypeDao artTypeDao = new ArticleTypeDaoImpl();
                int artTypleId = -1;
                int articleId = Integer.parseInt(request.getAttribute("articleId").toString());
                DiscussDao disDao = new DiscussDaoImpl();
                artTypleId = Integer.parseInt(request.getAttribute("artTypeId").toString());
                artTDto = artTypeDao.selectById(artTypleId);
            %>
            <td><%=artTDto.getArtTypeName() %>
            </td>
            <td>${articleDto.articleName}</td>
            <td>${articleDto.articleTime}</td>
            <td><s:if test="#articleDto.articleTop==1">置顶</s:if> <s:else>不置顶</s:else>
            </td>
            <td>${articleDto.articleCount}</td>
            <td>
                <a href="<%=basePath%>">
                    <%=disDao.getArtCount(articleId) %>
                </a>
            </td>
            <td><a href="<%=basePath%>article/upMyArt.action?articleId=${articleDto.articleId}">编辑</a> |
                <a href=<%=basePath%>article/delArt.action?articleId=${articleDto.articleId}" onclick="return confirm('是否确认删除？')">删除</a> |
                <a href="<%=basePath%>article/showArt.action?articleId=${articleDto.articleId}" >查看文章</a>
            </td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
