<%--
  Created by IntelliJ IDEA.
  User: taft
  Date: 2016/5/29
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>LoginPage</title>
</head>
<body>
    <form action="login.do" method="post">
        用户名:<input type="text" name="userName"/><br/>
        密码:<input type="password" name="userPass"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
