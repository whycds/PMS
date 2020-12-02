<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/23
  Time: 17:43
  To change this template use File | Settings | File Templates.
  插件添加页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加插件</title>
</head>
<body>
<div class="wrap-box">
    <form action="${pageContext.request.contextPath}/PluginServlet?method=add" method="post">
        <div class="item">
            <label>插件名:</label>
            <input type="text" name="name">
        </div>
        <div class="item">
            <label>插件价格:</label>
            <input type="text" name="price">
        </div>
        <div class="item">
            <label>插件作者:</label>
            <input type="text" name="author">
        </div>
        <div class="item">
            <label>插件类型:</label>
            <select name="type">
                <option value="功能辅助">功能辅助</option>
                <option value="优化美观">优化美观</option>
            </select>
        </div>
        <button class="btn">增加插件</button>
    </form>
    <div class="item2">
        <%@include file="back.jsp" %>
    </div>
</div>
</body>
</html>
