<%--
  Created by IntelliJ IDEA.
  User: taft
  Date: 2016/5/29
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>"/>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <a href="pages/login.jsp">登录</a>
  </body>
</html>
