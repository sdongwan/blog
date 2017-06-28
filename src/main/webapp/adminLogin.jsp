<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    System.out.println("basepath " + basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>博客管理员登录</title>
</head>
<body>
<form action="/admin/adminLogin.action" method="post" name="form1" id="form1">

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="424" height="95">&nbsp;</td>
            <td width="183">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="21%" height="30">
                            <div align="center">
                                <span>用户</span>
                            </div>
                        </td>
                        <td width="79%" height="30">
                            <input type="text" name="blogAdminBean.loginName" id="username">
                        </td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">
                                <span>密码</span>
                            </div>
                        </td>
                        <td height="30">
                            <input type="password" name="blogAdminBean.loginPwd"
                                   oncopy="return false" ; oncut="return false" ;
                                   onpaste="return false" id="userpwd">
                        </td>
                    </tr>

                    <tr>
                        <td height="30">&nbsp;</td>
                        <td height="30">
                            <label>
                                <input type="submit" name="login" value="登录">
                            </label>
                            <label>
                                <input type="reset" name="reset" value="重置">
                            </label>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="255">&nbsp;</td>
        </tr>
    </table>

</form>

</body>
</html>
