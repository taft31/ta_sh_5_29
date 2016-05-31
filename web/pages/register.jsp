<%--
  Created by IntelliJ IDEA.
  User: taft
  Date: 2016/5/29
  Time: 20:37
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
    <title>registerPage</title>
    <script src="scripts/jquery_1.7.1.js"></script>
    <script>
        $(function(){
            $("#un").blur(function(){
                $.ajax({
                    data:{},
                    url:"checkUserName.do?time="+new Date().getTime(),
                    type:"post",
                    dateType:"text",
                    success:function(val){
                        alert(val);
                    },
                    error:function(data){
                        alert("请求异常");
                    }
            });


            })
        });
    </script>
</head>
<body>
    <form action="register.do" method="post">
        用户名:<input id="ud" type="text" name="userName"/><br/>
        密码:<input id="up" type="password" name="userPass"/><br/>
        重复密码:<input id="rup" type="password"/><br/>
        <input type="button" value="注册"/>
    </form>
</body>
</html>
