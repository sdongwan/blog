<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 18:57
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
<div>当前文件为：${picDto.picName }<br>描述：${picDto.picDes }<br>共有${picDto.picCount }人喜欢</div>
<div>
    <form action="#" name = "form1" id = "form1" method="post">
        <input type = "hidden" value ="${picDto.picName }" name = "addPicCount.picName">
        <input type = "hidden" value ="${picDto.picId }" name = "addPicCount.picId">
        <input type = "hidden" value ="${picDto.picTypeId }" name = "addPicCount.picTypeId">
        <input type = "hidden" value ="${picDto.picPath }" name = "addPicCount.picPath">
        <input type = "hidden" value ="${picDto.picDes }" name = "addPicCount.picDes">
        <input type = "hidden" value ="${picDto.picCount }" name = "addPicCount.picCount">
        <input type = "hidden" value ="${picDto.picTime }" name = "addPicCount.picTime">
        <input type = "submit" value="喜欢" >
    </form>

    <img src="<%=imgPath%>/${picDto.picPath}" width="700" height="300"/>
    <div align ="left"><input type="button" name="Submit" value="返回" onclick="javascript:window.history.back();"/>
        <input type="button" name="Submit" value="关闭" onclick="javascript:window.close();"/></div>

</div>

</body>
</html>
