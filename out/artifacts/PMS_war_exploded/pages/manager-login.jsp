<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/22
  Time: 13:36
  To change this template use File | Settings | File Templates.
  管理人员登录界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理人员登入</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
</head>
<body>
<div class="loginBox1">
    <h2>管理员入口</h2>
    <form action="${pageContext.request.contextPath}/ManagerLoginServlet?method=login" method="post">
        <div class="item">
            <input type="text" name="key" required>
            <label>密钥:</label>
        </div>
        <div class="btn3">
            <button class="btn">
                进入
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </form>
</div>
<div>
    <%@include file="back.jsp" %>
</div>
</body>
</html>
