<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>center</title>
   <link rel="stylesheet" href="static/css/bootstrap-4.3.1.min.css">
<link rel="stylesheet" href="admin/common/common.css">
<link rel="stylesheet" href="admin/center/center.css">
  </head>
  
  <body>
   
<div class="admin">
		<div class="admin-left">
		<%@include file="../common/left.jsp" %>
		</div>

		<div class="admin-right">
		<%@include file="../common/rightHeader.jsp" %>
		</div>
		<div class="con">
		con
		</div>
	</div>
	</div>

	<script src="static/js/jquery-3.3.1.min.js"></script>
	<script src="static/js/bootstrap-4.3.1.min.js"></script>
	<script src="admin/common/common.js"></script>
	<script src="admin/center/center.js"></script>

  </body>
</html>
