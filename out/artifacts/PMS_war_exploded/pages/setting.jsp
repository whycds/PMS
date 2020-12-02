<%@ page import="sym.common.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/21
  Time: 13:00
  To change this template use File | Settings | File Templates.
  用户信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
</head>
<body>
<%
    User user = (User) application.getAttribute("user");
%>
<div class="settingBox">
    <div class="item1">
        <img class="icon" src="${pageContext.request.contextPath}/images/head.jpeg">
    </div>
    <div class="item2">
        <a><%=user.getUsername()%>
        </a>
    </div>
    <div class="item3">
        <a>性别:</a>
        <%=user.getSex()%>
    </div>
    <div class="item3">
        <a>年龄:</a>
        <%=user.getAge()%>
    </div>
    <div class="item3">
        <a>生日:</a>
        <%=user.getBirthday()%>
    </div>
    <div class="item3">
        <a>手机:</a>
        <%=user.getPhone()%>
    </div>
    <div class="item4">
        <button class="btn" onclick="window.location='${pageContext.request.contextPath}/pages/user-change.jsp'">
            更改账户
        </button>
        <button class="btn" onclick="window.location='${pageContext.request.contextPath}/LoginServlet?method=drop'">
            注销账户
        </button>
        <button class="btn" onclick="window.location='${pageContext.request.contextPath}/pages/login.jsp'">
            退出登录
        </button>
    </div>
</div>
<div>
    <%@include file="back.jsp" %>
</div>
</body>
</html>
