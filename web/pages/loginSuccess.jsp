<%--
  Created by IntelliJ IDEA.
  User: taft
  Date: 2016/5/29
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>LoginSuccessPage</title>
</head>
<body>
    当前用户:<c:out value="${sessionScope.loginUser.get(0).name}"/><br/>
    <c:if test="${null!=sessionScope.loginUser.get(0).udid}">
        个人信息:<br/>
        <c:forEach items="${sessionScope.loginUser}" var="userDTO">
            地址:<c:out value="${userDTO.address}"/>
            电话:<c:out value="${userDTO.phone}"/>
            <br/>
        </c:forEach>
    </c:if>
</body>
</html>
