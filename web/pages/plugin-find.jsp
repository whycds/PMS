<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/22
  Time: 18:28
  To change this template use File | Settings | File Templates.
  插件查找页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找插件</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin-find.css">
</head>
<body>
<div class="findBox">
    <div class="text">
        <a>插件名:</a>
    </div>
    <div class="main">
        <form action="${pageContext.request.contextPath}/PluginServlet?method=find" method="post">
            <label>
                <input type="text" name="name" required>
            </label>
            <button class="btn1">
                查找
                <span></span>
            </button>
        </form>
    </div>
    <div class="btn2">
        <%@include file="back.jsp" %>
    </div>
</div>
</body>
</html>
