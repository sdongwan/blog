<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:15
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
<!-- start header -->
<div id="contmain">
    <div id="left1">
        <div id="right1">
            <jsp:include page="/WEB-INF/head.jsp" flush="true"/>
            <!-- start page -->
            <div id="page">
                <jsp:include page="art.jsp" flush="true"/>
                <jsp:include page="/WEB-INF/right.jsp" flush="true"/>
                <div id="bottom" style="clear: both;"></div>
            </div><!-- end page -->
            <!-- start footer -->
            <jsp:include page="/WEB-INF/footer.jsp" flush="true"/>
        </div>
    </div>
</div>
<!-- end footer -->
</body>
</html>
