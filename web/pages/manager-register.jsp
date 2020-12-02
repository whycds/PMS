<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/22
  Time: 18:26
  To change this template use File | Settings | File Templates.
  管理员申请页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员申请</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager-register.css">
</head>
<body>
<div class="register">
    <div>
        <h2>管理员申请</h2>
    </div>
    <form action="${pageContext.request.contextPath}/ManagerLoginServlet?method=register" method="post">
        <div class="item">
            <button class="btn1">申请</button>
        </div>
    </form>
</div>
<div>
    <%@include file="back.jsp" %>
</div>
</body>
</html>
