<%@ page import="sym.common.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/24
  Time: 12:18
  To change this template use File | Settings | File Templates.
  更改用户信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改用户信息</title>
</head>
<body>
<%
    User user = (User) application.getAttribute("user");
%>
<div class="settingBox">
    <form action="${pageContext.request.contextPath}/LoginServlet?method=change" method="post">
        <div class="item2">
            <a>密码:</a>
            <input name="password" value="<%=user.getUsername()%>">
        </div>
        <div class="item3">
            <a>性别:</a>
            <input name="sex" value="<%=user.getSex()%>">
        </div>
        <div class="item3">
            <a>年龄:</a>
            <input name="age" value="<%=user.getAge()%>">
        </div>
        <div class="item3">
            <a>生日:</a>
            <input name="birthday" value="<%=user.getBirthday()%>">
        </div>
        <div class="item3">
            <a>手机:</a>
            <input name="phone" value="<%=user.getPhone()%>">
        </div>
        <div class="btn">
            <button>确认更改</button>
        </div>
    </form>
</div>
</body>
</html>
