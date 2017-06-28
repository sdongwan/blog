<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:57
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
<div>当前文件为：${picBean.picName }<br>描述：${picBean.picDes }<br>共有${picBean.picCount }人喜欢</div>
<div>
    <form action="/pic/UpPicCount.action" name="form1" id="form1" method="post">
        <input type="hidden" value="${picBean.picName }" name="picBean.picName">
        <input type="hidden" value="${picBean.picId }" name="picBean.picId">
        <input type="hidden" value="${picBean.picTypeId }" name="picBean.picTypeId">
        <input type="hidden" value="${picBean.picPath }" name="picBean.picPath">
        <input type="hidden" value="${picBean.picDes }" name="picBean.picDes">
        <input type="hidden" value="${picBean.picCount }" name="picBean.picCount">
        <input type="hidden" value="${picBean.picTime }" name="picBean.picTime">
        <input type="submit" value="喜欢">
    </form>

    <img src="/upload/${picBean.picName}" width="700" height="300"/>
    <div align="left"><input type="button" name="Submit" value="返回" onclick="javascript:window.history.back();"/>
        <input type="button" name="Submit" value="关闭" onclick="javascript:window.close();"/></div>

</div>

</body>
</html>
