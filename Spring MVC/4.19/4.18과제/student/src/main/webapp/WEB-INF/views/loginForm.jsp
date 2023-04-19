<%@ page contentType="text/html;charset=UTF-8" language="java"  session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form method="post" action="/login">
        <input type="text" name="id" placeholder="회원아이디"/><br />
        <br />
        <input type="password" name="pwd" placeholder="비밀번호"/><br />
        <p style="color:red">${message}</p>
        <input type="submit" />
    </form>
</body>
</html>
