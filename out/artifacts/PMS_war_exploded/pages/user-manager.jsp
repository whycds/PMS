<%@ page import="java.util.List" %>
<%@ page import="sym.common.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: whywy
  Date: 2020/11/23
  Time: 19:06
  To change this template use File | Settings | File Templates.
  用户管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<%
    List<User> users = (List<User>) application.getAttribute("users");
%>
<tr>
    <td>用户名</td>
    <td>密码</td>
    <td>性别</td>
    <td>电话</td>
    <td>生日</td>
    <td>年龄</td>
</tr>
<%
    for (int i = 0; i < users.size(); i++) {
%>
<tr>
    <%
        User user = users.get(i);
    %>
    <td><%=user.getUsername()%>
    </td>
    <td><%=user.getPassword()%>
    </td>
    <td><%=user.getSex()%>
    </td>
    <td><%=user.getPhone()%>
    </td>
    <td><%=user.getBirthday()%>
    </td>
    <td><%=user.getAge()%>
    </td>
</tr>
<%
    }
    ;
%>
<div>
    <%@include file="back.jsp" %>
</div>
</body>
</html>
