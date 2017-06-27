<%@ page import="com.sdongwan.blog.bean.LinkBean" %>
<%@ page import="com.sdongwan.blog.dao.LinkDao" %>
<%@ page import="com.sdongwan.blog.dao.impl.LinkDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    int linkId = Integer.parseInt(request.getParameter("linkId"));
    System.out.println("linkId " + linkId);
    LinkDao linkDao = new LinkDaoImpl();
    LinkBean linkBean = linkDao.selectById(linkId);
    request.setAttribute("linkBean", linkBean);

%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

<form id="form1" name="form1" method="post" action="link/upLink.action">
    <input type="hidden" value="${linkBean.linkId}" name="linkBean.linkId">
    <table width="400" border="0" align="center">
        <tr>
            <td width="123">友情链接名字：</td>
            <td colspan="3"><label for="linkBean.linkName"></label>
                <input width="120px" type="text" name="linkBean.linkName" id="linkBean.linkName"
                       value="${linkBean.linkName}"/></td>
        </tr>
        <tr>
            <td width="123">友情链接地址：</td>
            <td colspan="3"><label for="linkBean.linkUrl"></label>
                <input width="122px" type="text" name="linkBean.linkUrl" id="linkBean.linkUrl"
                       value="${linkBean.linkUrl}"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="reset" name="rest" value="重置">
                <input type="submit" name="Submit2" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
