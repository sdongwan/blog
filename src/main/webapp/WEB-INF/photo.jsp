<%@ page import="com.sdongwan.blog.bean.Page" %>
<%@ page import="com.sdongwan.blog.bean.PicBean" %>
<%@ page import="com.sdongwan.blog.bean.PicTypeBean" %>
<%@ page import="com.sdongwan.blog.dao.DiscussDao" %>
<%@ page import="com.sdongwan.blog.dao.PageDao" %>
<%@ page import="com.sdongwan.blog.dao.PicDao" %>
<%@ page import="com.sdongwan.blog.dao.PicTypeDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.DiscussDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PageDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicDaoImpl" %>
<%@ page import="com.sdongwan.blog.dao.impl.PicTypeDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:28
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
    PageDao ipage = new PageDaoImpl<>();
    Page<PicBean> pages = new Page<PicBean>();
    int num = 1;
    PicTypeDao picTypeDao = new PicTypeDaoImpl();
    String pageSize = request.getParameter("pageSize");
    if (pageSize != null && !"".equals(pageSize)) {
        num = Integer.parseInt(pageSize);
    }
    List<PicBean> picLt = null;
    PicDao picDao = new PicDaoImpl();
    picLt = picDao.selectAll(num);
    PicTypeBean picTypeDto = null;

    pages = ipage.getPic(num);
    request.setAttribute("pagerList", pages);

%>

<div id="content">
    <%
        for (PicBean picDto : picLt) {
            int picTypeId = picDto.getPicTypeId();
            picTypeDto = picTypeDao.selectById(picTypeId);
            DiscussDao disDao = new DiscussDaoImpl();
    %>
    <%
        String imgPath = basePath + "upload";

    %>
    <div class="post">
        <h2 class="title"><a href="/blog/Pic/showPic.action?picId=<%=picDto.getPicId()%>"
                             target="_blank"><%=picDto.getPicName() %>
        </a></h2>
        <p class="meta"></p>分类：<a
            href="/blog/Pic/showSortPics.action?picTypeId=<%=picDto.getPicTypeId()%>"><%=picTypeDto.getPicTypeName() %>
    </a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%=picDto.getPicCount() %>人喜欢&nbsp;&nbsp;&nbsp;&nbsp;<%=picDto.getPicTime() %>
        <div class="entry">
            <p>
                <img src="<%=imgPath%>/<%=picDto.getPicPath()%>" width="100" height="100"
                     alt="<%=picDto.getPicDes() %>"/>
            </p>

        </div>
    </div>
    <%}%>
    <c:choose>
        <c:when
                test="${pagerList.pageIndex <= 0 ||pagerList.pageIndex > pagerList.pageMax}">
            <c:catch></c:catch>
        </c:when>
        <c:otherwise>
            <form name="form1" method="post" action="photos.jsp">
                <table width="90%" border="0">
                    <tr>
                        <td><a href="photos.jsp?pageSize=1">第一页</a></td>
                        <c:choose>
                            <c:when
                                    test="${pagerList.pageIndex <= pagerList.pageMax  && pagerList.pageIndex > 1}">
                                <c:catch>
                                    <td><a href="photos.jsp?pageSize=${pagerList.pageIndex -1}">上一页</a></td>
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
                                    <a href="photos.jsp?pageSize=${toPage}">${toPage}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach></td>
                        <c:choose>
                            <c:when
                                    test="${pagerList.pageIndex < pagerList.pageMax && pagerList.pageIndex >0}">
                                <c:catch>
                                    <td><a href="photos.jsp?pageSize=${pagerList.pageIndex + 1}">下一页</a></td>
                                </c:catch>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                        <td><a href="photos.jsp?pageSize=${pagerList.pageMax}">最后一页</a>
                        </td>
                        <td><label for="select"></label> <select name="pageSize"
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
                        <td>
                            <input type="submit" name="button" id="button" value="跳转"></td>
                    </tr>
                </table>
            </form>
        </c:otherwise>
    </c:choose>
    <p>有${pagerList.dateCount}张图片,${pagerList.pageIndex}/${pagerList.pageMax},本页${pagerList.pageCount}张图片</p>
</div>
</body>
</html>
