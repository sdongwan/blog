<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    System.out.println("basepath " + basePath);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>博客后台管理系统</title>
</head>

<%--<frameset colns="200,10,*" framespacing="0" border="false" frameborder="0" id="frameset">--%>
    <%--<frame src="<%=basePath%>admin/left.action" id="left" name="left" scrolling="yes"/>--%>
    <%--<frame src="<%=basePath%>admin/leftFrame.action" id="leftFrame" name="leftFrame" scrolling="no" noresize/>--%>
    <%--<frameset id="mm" name="mm" rows="0,10,*" framespacing="0" border="0" frameborder="NO">--%>
        <%--<frame src="<%=basePath%>admin/top.action" id="top" name="top" scrolling="no" noresize/>--%>
        <%--<frame src="<%=basePath%>admin/top.action" id="topFrame" name="topFrame" scrolling="no" noresize/>--%>
        <%--<frame src="<%=basePath%>admin/main.action" id="main" name="right" scrolling="yes" marginwidth="0"--%>
               <%--marginheight="0"/>--%>
    <%--</frameset>--%>
<%--</frameset>--%>


<frameset framespacing="0" id="frameset" border="false" cols="200,10,*" frameborder="0">
    <frame src="<%=basePath%>admin/left.action" id="left" name="left" scrolling="yes">
    <frame src="<%=basePath%>admin/leftFrame.action" name="leftFrame" id="leftFrame" scrolling="no" noresize>
    <frameset name=mm id=mm rows="0,10,*" frameborder="NO" border="0" framespacing="0">
        <frame src="<%=basePath%>admin/top.action" id="top" name="top" scrolling="no" noresize>
        <frame src="<%=basePath%>admin/top.action" name="topFrame" id="topFrame" scrolling="no" noresize>
        <frame src="<%=basePath%>admin/main.action" name="right" id="main" scrolling="yes" marginwidth="0"
               marginheight="0">
    </frameset>
</frameset>

<noframes>
    <body>
    你的浏览器不兼容frame

    </body>
</noframes>

<noframes>
    <body bgcolor="#efefef" topmargin="0" leftmargin="0">
    <p>This page uses frames, but your browser doesn't support them.</p>
    </body>
</noframes>
</html>
