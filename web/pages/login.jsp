<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2020/11/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
  登陆页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PMS登陆页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
</head>
<body>
<div class="loginBox">
    <h2>PMS登录</h2>
    <form action="${pageContext.request.contextPath}/LoginServlet?method=login" method="post">
        <div class="item">
            <input type="text" name="username" required>
            <label>用户名:</label>
        </div>
        <div class="item">
            <input type="password" name="password" required>
            <label>密码:</label>
        </div>
        <div class="btn1">
            <button class="btn">
                登录
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </form>
    <div class="btn2">
        <button class="btn" onclick="window.location='${pageContext.request.contextPath}/pages/register.jsp'">
            注册
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </button>
    </div>
</div>
</body>
</html>