<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/23
  Time: 17:43
  To change this template use File | Settings | File Templates.
  插件删除页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除插件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/PluginServlet?method=drop" method="post">
    <input type="text" name="name">
    <button>删除插件</button>
</form>
<div>
    <%@include file="back.jsp"%>
</div>
</body>
</html>
