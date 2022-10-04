<%--
  Created by IntelliJ IDEA.
  User: judie
  Date: 04/10/2022
  Time: 05:49 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String fullname = (String)request.getAttribute("Name");
%>
<body>
<div>
<h1>Welcome again!</h1>

<p>You have logged in as: <%=fullname%></p>
</div>
</body>
<style>
    <%@include file="styles/base.css" %>
</style>
</html>
