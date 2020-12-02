<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/19
  Time: 17:13
  To change this template use File | Settings | File Templates.
  管理人员界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理插件</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
</head>
<body>
<div class="welcomeTop">
    <h1>plugin-manager-system</h1>
</div>
<div class="welcomeBox">
    <ul class="main">
        <li>
            <img src="${pageContext.request.contextPath}/images/manage.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/plugin-add.jsp'">
            <div class="flag">增加插件</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/update.png"
                 onclick="window.location='${pageContext.request.contextPath}/PluginServlet?method=find2'"
                 method="post">
            <div class="flag">更新插件</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/find.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/plugin-drop.jsp'">
            <div class="flag">删除插件</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/user.png"
                 onclick="window.location='${pageContext.request.contextPath}/LoginServlet?method=showAll'"
                 method="post">
            <div class="flag">管理用户</div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/logout.png"
                 onclick="window.location='${pageContext.request.contextPath}/pages/welcome.jsp'">
            <div class="flag">退出</div>
        </li>
    </ul>
</div>
</body>
</html>
