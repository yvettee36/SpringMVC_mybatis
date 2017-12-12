<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/12/12
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="/login.action" method="post">
    用户账号：<input type="text" name="username"/><br/>
    用户密码 ：<input type="password" name="password"/><br/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
