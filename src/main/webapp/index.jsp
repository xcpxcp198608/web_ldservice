<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>$Title$</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />  
  <meta name="apple-mobile-web-app-capable" content="yes" />  
  <meta name="format-detection" content="telephone=no" />
  <link rel="shortcut icon" href="Resource/img/btv.ico">
  <link rel="stylesheet" type="text/css" href="Resource/css/base.css">
  <script type="application/javascript" language="JavaScript" src="Resource/js/base.js"/>

</head>

<body>

  <form action="/ldservice/login" method="post">

  </form>

</body>
</html>
