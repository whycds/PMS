<%@ page import="plugin.common.bean.plugin" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: why
  Date: 2020/11/23
  Time: 20:12
  To change this template use File | Settings | File Templates.
  所有插件显示页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有插件</title>
</head>
<body>
<%
    List<plugin> plugins = (List<plugin>) application.getAttribute("plugins");
%>
<tr>
    <td>名字</td>
    <td>类型</td>
    <td>更改日期</td>
    <td>价格</td>
    <td>作者</td>
</tr>
<%
    for (int i = 0; i < plugins.size(); i++) {
%>
<tr>
    <%
        plugin plugin = plugins.get(i);
    %>
    <td><%=plugin.getName()%>
    </td>
    <td><%=plugin.getType()%>
    </td>
    <td><%=plugin.getUpdate()%>
    </td>
    <td><%=plugin.getPrice()%>
    </td>
    <td><%=plugin.getAuthor()%>
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
