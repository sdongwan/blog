<%@ page import="com.sdongwan.blog.bean.DiscussBean" %>
<%@ page import="com.sdongwan.blog.bean.VisitorBean" %>
<%@ page import="com.sdongwan.blog.dao.ArticleDao" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.VisitorDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.ArticleDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.VisitorDaoImpl" %>
<%@ page import="com.sdongwan.blog.util.MethodUtil" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<div id="content">


    <div class="post">
        <h3 align="center">
            <span class="postdate clearfix">${articleBean.articleName}</span>
        </h3>
        <p align="right">发表时间：${articleBean.articleTime}&nbsp;&nbsp;&nbsp;&nbsp;访问次数:${articleBean.articleCount}</p>

        <div class="entry">
            ${articleBean.article}

            <%
                int articleId = 0;
                articleId = Integer.parseInt(request.getParameter("articleId"));
                ArticleDao artDaoNext = new ArticleDaoImpl();
                ArticleDao artDaoPre = new ArticleDaoImpl();
                DiscussDao disDao = new DiscussDaoImpl();
                VisitorBean visitor = new VisitorBean();
                VisitorDao visitDao = new VisitorDaoImpl();
                List<DiscussBean> disLt = null;
                disLt = disDao.selectByArtId(articleId);
            %>

        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <caption>
                <font color="red"> 评论列表</font>
            </caption>
            <%
                for (DiscussBean disDto : disLt) {
            %>
            <tr>
                <%
                    visitor = visitDao.selectById(disDto.getVisitorId());
                %>
                <td><a
                        href="">
                    <%=visitor.getVisitorName()%>
                </a>在<%=disDto.getDiscussTime()%>说： <%=disDto.getDiscuss()%>
                </td>
            </tr>
            <tr>
                <td>
                    <%
                        if (disDto.getDiscussR() != null) {
                    %><font color="red">博主</font>在<%=disDto.getDiscussTimeR()%>回复<a
                        href="">
                    <%=visitor.getVisitorName()%>
                </a>：<%=disDto.getDiscussR()%>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>

        <form method="post" name="form1"
              action=""
              id="form1">
            <input name="visitDto.visitorIp"
                   value="<%=MethodUtil.getIPAddr(request)%>" type="hidden">
            <p>
                <input name="visitDto.visitorName" maxlength="49" size="22"
                       type="text" id="nickName"> <label for="nickName">
                <small>昵称(必填)</small>
            </label>
            </p>
            <p>
                <input name="visitDto.visitorEmail" maxlength="128" size="22"
                       type="text" id="email"> <label for="email">
                <small>邮件地址
                    (必填)
                </small>
            </label>
            </p>
            <p>
                <textarea name="disDto.discuss" id="comment" rows="6" cols="25"></textarea>
            </p>
            <p>
                <input id="comment_submit" value="发表评论" type="button"
                       onclick="check();">
            </p>
        </form>
    </div>

    <div align="center">
        <input type="button" name="Submit" value="返回"
               onclick="javascript:window.history.back();"/>
        <input type="button"
               name="Submit" value="关闭"
               onclick="javascript:window.close();"/>
    </div>
</div>
</body>
</html>
