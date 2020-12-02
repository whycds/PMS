<%@ page import="plugin.common.bean.plugin" %>
<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/21
  Time: 19:40
  To change this template use File | Settings | File Templates.
  插件更新页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新插件</title>

    <script type="text/javascript">
        function show() {
            document.getElementById("div1").style.display = "";
        }
    </script>
    <%
        int click = 0;
        click = (int) application.getAttribute("click");
    %>
    <%
        if (click == 1) {
    %>
    <script type="text/javascript">
        setTimeout(function () {
            var e = document.createEvent("MouseEvents");
            e.initEvent("click", true, true);
            document.getElementById("btn").dispatchEvent(e);
        }, 10);
    </script>
    <%
        }
    %>
</head>
<body>
<%
    plugin plugin = (plugin) application.getAttribute("plugin");
%>
<div>
    <form action="${pageContext.request.contextPath}/PluginServlet?method=findChange" method="post">
        <a>输入你要更新的插件名:</a>
        <input type="text" name="name">
        <button>查看插件</button>
    </form>
    <div style="display: none">
        <button id="btn" onclick="show()">查看插件</button>
    </div>
    <div id="div1" style="display: none">
        <form action="${pageContext.request.contextPath}/PluginServlet?method=change" method="post">
            <input type="text" name="name" value="<%=plugin.getName()%>">
            <select name="type">
                <option value="功能辅助" selected>功能辅助</option>
                <option value="优化美观">优化美观</option>
            </select>
            <input type="text" name="price" value="<%=plugin.getPrice()%>">
            <input type="text" name="author" value="<%=plugin.getAuthor()%>">
            <button>更新插件</button>
        </form>
    </div>
    <div>
        <%@include file="back.jsp" %>
    </div>
</div>
</body>
</html>
