<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 0:06
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
<%--<%if (request.getSession().getAttribute("BlogAdmin") == null) { %>--%>
<%--<script language=javascript>alert('您没有登录，请登录后操作！');--%>
<%--window.open("/blog/Admin_login.jsp", "_parent");</script>--%>
<%--;--%>
<%--<%} %>--%>
<table width="162" border="0" cellpadding="0" cellspacing="1">
    <tr>
        <td width="160" height=38 align=right class=font>
            <div align="center">
                <a href="#" target="right"></a>
            </div>
        </td>
    </tr>
    <tr>
        <td valign=tip>
            <table width="100%" border="0" align=center cellpadding="0" cellspacing="1">
                <tr>
                    <td height=27 background="" style="cursor:hand" onClick="">
                        <div align="center"><strong>文章管理</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a2>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">·<a href="<%=basePath%>article/showArtTypes.action"
                                                                        target="right" class="red">文章类型管理</a></td>
                                    </tr>
                                    <tr>
                                        <td height=23 class="amrow">·<a href="<%=basePath%>article/showArts.action"
                                                                        target="right"
                                                                        class="red">文章管理</a></td>
                                    </tr>
                                    <tr>
                                        <td height=23 class="amrow">·<a href="<%=basePath%>article/addArticle.action"
                                                                        target="right"
                                                                        class="red">添加文章</a></td>
                                    </tr>
                                    <!-- <tr><td height=23 class="amrow">·<a href="" target="right" class="red">文章评论管理</a></td></tr> -->
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height=27 style="cursor:hand" onClick="show(a3)">
                        <div align="center"><strong>相册管理</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a3>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">·<a href="pic/showPicTypes.action" target="right">相册类型管理</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height=23 class="amrow">·<a href="pic/addPhoto.action"
                                                                        target="right">添加相片</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height=23 class="amrow">·<a href="pic/showPics.action"
                                                                        target="right">相片管理</a></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height=27 style="cursor:hand" onClick="show(a4)">
                        <div align="center"><strong>公告管理</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a4>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">·<a href="notice/showNotices.action" target="right">公告管理</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height=23 class="amrow">·
                                            <a href="notice/addMyNotice.action" target="right">添加公告</a></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height=27 onClick="show(a8)">
                        <div align="center"><strong>友情链接管理</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a8>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">·
                                            <a href="link/showLinks.action" target="right">管理友情链接</a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height=27 style="cursor:hand" onClick="show(a5)">
                        <div align="center"><strong>访客管理</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a5>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">·<a href="visitor/showVisitors.action"
                                                                        target="right">访客管理</a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height=27 style="cursor:hand" onClick="show(a15)">
                        <div align="center"><strong>密码设置</strong></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <DIV id=a15>
                            <div align="left">
                                <table width="156" border="0" cellspacing="1" cellpadding="1" align="center">
                                    <tr>
                                        <td height=23 class="amrow">
                                            <a href="" target="right">密码修改</a></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>


                <tr>
                    <td height=27 onClick="show(a16)">
                        <div align="center"><strong>安全退出</strong></div>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">
                        <DIV id=a16>
                            <table width="156" border="0" cellspacing="1" cellpadding="1" align="center"
                                   bgcolor="#FFFFFF">
                                <tr>
                                    <td height=23 class="amrow">·<a style="cursor:hand"
                                                                    onClick="if (confirm('你确定要退出系统吗？')){window.open('/admin/out.jsp','_parent')}">安全退出</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td height=5 bgcolor="#FFFFFF"></td>
    </tr>
    <tr>
        <td height=60 bgcolor="#FFFFFF" class="amrow"><strong>
            <strong style="line-height:180%">&nbsp;当前登录管理员:<%=session.getAttribute("BlogAdmin")%>
            </strong><br>

        </strong></td>
    </tr>
    <tr>
        <td height=3 bgcolor="#FFFFFF">&nbsp;</td>
    </tr>
</table>
</body>
</html>
