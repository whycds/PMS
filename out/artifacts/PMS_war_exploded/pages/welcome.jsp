<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/19
  Time: 17:13
  To change this template use File | Settings | File Templates.
  欢迎页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PMS</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
</head>
<body>
<div class="welcomeTop">
    <h1>plugin-manager-system</h1>
</div>
<div class="welcomeBox">
    <ul class="main">
        <li>
            <img src="${pageContext.request.contextPath}/images/all.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/plugin-find.jsp'">
            <div class="flag">查找插件</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/type.png"
                 onclick="window.location='${pageContext.request.contextPath}/PluginServlet?method=showAll'">
            <div class="flag">全部插件</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/download.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/manager-register.jsp'">
            <div class="flag">管理员申请</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/login.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/manager-login.jsp'">
            <div class="flag">管理员登录</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/register.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/setting.jsp'">
            <div class="flag">用户设置</div>
        </li>
    </ul>
</div>
</body>
</html>
