<%--
  Created by IntelliJ IDEA.
  User: yoonmin
  Date: 2023/04/09
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="/login">
  <input type="text" name="id" placeholder="아이디 : admin" /><br />
  <input type="password" name="pwd" placeholder="패스워드 : 1234" /><br />
  <input type="submit" value="전송" />
</form>
</body>
</html>
