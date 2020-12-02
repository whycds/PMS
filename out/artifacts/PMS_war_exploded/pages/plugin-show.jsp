<%@ page import="plugin.common.bean.plugin" %>
<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/23
  Time: 13:13
  To change this template use File | Settings | File Templates.
  查找结果页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找结果</title>
</head>
<body>
<%
    plugin plugin = (plugin) application.getAttribute("plugin");
%>
<div>
    <%=plugin.getName()%>
    <%=plugin.getType()%>
    <%=plugin.getUpdate()%>
    <%=plugin.getPrice()%>
    <%=plugin.getAuthor()%>
</div>
<%@include file="back.jsp"%>
</body>
</html>
