<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/19
  Time: 17:19
  To change this template use File | Settings | File Templates.
  用户注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<div class="registerBox">
    <h2>账户注册</h2>
    <form action="${pageContext.request.contextPath}/LoginServlet?method=register" method="post">
        <div class="item">
            <input type="text" name="username" required>
            <label>用户名:</label>
        </div>
        <div class="item">
            <input type="password" name="password" required>
            <label>密码:</label>
        </div>
        <div class="item">
            <input type="password" required>
            <label>确认密码:</label>
        </div>
        <div class="item">
            <input type="tel" name="phone" required>
            <label>电话:</label>
        </div>
        <div class="item2">
            <label>性别:</label>
            <label id="boy">男<input type="radio" name="sex" value="男"></label>
            <label id="girl">女<input type="radio" name="sex" value="女"></label>
        </div>
        <div class="item3">
            <label>生日:</label>
            <input id="year" name="year" type="date">
        </div>
        <div class="item3">
            <label>年龄:</label>
            <input id="age" name="age" type="number">
        </div>
        <button class="btn">
            注册
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </button>
    </form>
</div>
</body>
</html>
