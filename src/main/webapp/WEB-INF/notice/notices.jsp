<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:36
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
<table width="70%" border="1" align="center">
    <tr>
        <th width="10%">公告名称</th>
        <th>公告内容</th>
        <th width="10%">发布时间</th>
        <th width="20%">操作</th>
    </tr>
    <s:iterator value="noticeBeans" var="nDtoT">
        <tr>
            <%--<%--%>
                <%--String notice = request.getAttribute("notice").toString();--%>
                <%--int noticeId = Integer.parseInt(request.getAttribute("noticeId").toString());--%>
                <%--if (notice.length() > 40) {--%>
                    <%--notice = notice.substring(0, 40) + ">><a href='notice/showNotice.action?noticeId='" + noticeId + "'>更多</a>";--%>
                <%--}--%>
            <%--%>--%>

            <td>${nDtoT.noticeName}</td>
            <td>${nDtoT.notice}</td>
            <td>${nDtoT.noticeTime}</td>
            <td><a href="notice/toUpNotice.action?noticeId=${nDtoT.noticeId}">修改</a>
                |<a href="notice/showNotice.action?noticeId=${nDtoT.noticeId}">查看详细</a>
                |<a href="notice/delNotice.action?noticeId=${nDtoT.noticeId}" onclick="return confirm('是否确认删除？')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
