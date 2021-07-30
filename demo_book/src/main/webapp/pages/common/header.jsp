<%--
  Created by IntelliJ IDEA.
  User: wayan
  Date: 2021/7/26
  Time: 11:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setAttribute("req",request);%>
<base href="${req.scheme}://${ req.serverName }:${req.serverPort}${req.contextPath}/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
