<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>我的博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body>
<!-- start header -->
<div id="contmain">
<div id="left1">
	<div id="right1">
<jsp:include page="head.jsp" flush="true" /> 
<!-- start page -->
<div id="page">
<jsp:include page="Article.jsp" flush="true" />
<jsp:include page="right.jsp" flush="true" /> 
	<div id="bottom" style="clear: both;"></div>
</div><!-- end page -->
<!-- start footer -->
<jsp:include page="footer.jsp" flush="true" />
</div>
</div>
</div>
<!-- end footer -->
</body>
</html>
  