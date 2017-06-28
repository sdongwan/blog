<%@ page import="com.sdongwan.blog.bean.ArticleTypeBean" %>
<%@ page import="com.sdongwan.blog.bean.LinkBean" %>
<%@ page import="com.sdongwan.blog.bean.NoticeBean" %>
<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.*" %>
<%@ page import="com.sdongwan.blog.dao.impl.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:31
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
    NoticeDao noticeDao = new NoticeDaoImpl();
    NoticeBean notice = noticeDao.selectNew();
    PicTypeDao picTDao = new PicTypeDaoImpl();
    List<PicTypeBean> picTypeLt = picTDao.selectAll();
    LinkDao linkDao = new LinkDaoImpl();
    List<LinkBean> linkLt = linkDao.showLink();
    PicDao picDao = new PicDaoImpl();
    ArticleTypeDao artTDao = new ArticleTypeDaoImpl();
    List<ArticleTypeBean> artTypeLt = artTDao.selectAll();
    ArticleDao artDao = new ArticleDaoImpl();
%>
<div id="sidebar2" class="sidebar">
    <ul>
        <li>
            <h2>博主信息</h2>
            <div class="info"><img src="" alt="somboy logo"/><br/>
                somboy
                <p><a href="#">给我留言</a>&nbsp;&nbsp;<a href="#">加入好友</a><br/>
                    <a href="#">发短消息</a>&nbsp;&nbsp;<a href="#">我的介绍</a><br/>
                    <a href="#">论坛资料</a>&nbsp;&nbsp;<a href="#">空间管理</a></p>
            </div>
        </li>
        <li>
            <h2>公告:<%=notice.getNoticeName()%>
            </h2>
            <ul>
                <li>发布时间：<%=notice.getNoticeTime() %>
                </li>
                <li><%=notice.getNotice() %>
                </li>
            </ul>
        </li>
        <li>
            <h2>文章分类</h2>
            <ul><%for (ArticleTypeBean artType : artTypeLt) { %>
                <li><a href="#"><%=artType.getArtTypeName() %>(<%=artDao.getCount(artType.getArtTypeId()) %>)</a></li>
                <%} %>
            </ul>
        </li>
        <li>
            <h2>相册分类</h2>
            <ul><%for (PicTypeBean picType : picTypeLt) { %>
                <li><a href="#"><%=picType.getPicTypeName() %>(<%=picDao.getCount(picType.getPicTypeId()) %>)</a></li>
                <%} %>
            </ul>
        </li>
        <li>
            <h2>日历</h2>
            <ul>
                <jsp:include page="rili.jsp" flush="true"/>
            </ul>
        </li>
        <li>
            <h2>友情链接 </h2>
            <ul>
                <%for (LinkBean link : linkLt) { %>
                <li><a href="<%=link.getLinkUrl()%>" target="_blank"><%=link.getLinkName() %>
                </a></li>
                <%} %>
            </ul>

        </li>
    </ul>
</div>
</body>
</html>
