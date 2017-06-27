<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 0:15
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

<div onClick="oa_tool1()" align="center" style="cursor:hand">
    <img id=frameshow1 src="" width="50" height="9" alt="显示图片管理">
</div>
<TABLE width="100%">
    <TBODY>
    <TR>
        <TD></TD>
        <TD align=middle><FONT style="FONT-SIZE: 10pt" color=#ffffff><B><A
                style="COLOR: #ffffff"
                href=""
                target="right">管理首页</A>　<A href="javascript:history.go(1)"><FONT
                color=#ffffff>前进</FONT></A>｜<A
                href="javascript:history.back()"><FONT
                color=#ffffff>后退</FONT></A>｜<A
                href="javascript:main.location.reload()" )><FONT
                color=#ffffff>刷新</FONT></A>｜<FONT color=#ffffff>帮助</FONT>
            ｜<A  style="COLOR: #ffffff"  href=""
                 target="_parent"><FONT  color=#ffffff>退出</FONT></A></B></FONT> </TD>
        <!--  <a style="cursor:hand" onClick="if (confirm('你确定要退出系统吗？')){window.open('admin/exit.action','_parent')}"> -->
    </TR>
    </TBODY>
</TABLE>
</body>
</html>
