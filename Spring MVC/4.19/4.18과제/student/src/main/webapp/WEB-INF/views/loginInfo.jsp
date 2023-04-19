<%--
  Created by IntelliJ IDEA.
  User: yoonmin
  Date: 2023/04/18
  Time: 2:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login-info</title>
</head>
<body>
    <div style="width : 300px; height: 50px; border: 2px solid grey; padding:10px">
        아이디: ${user.userId} 이름: ${user.userName}
        <form method="post" action="/student/logout">
            <button type="submit">로그아웃</button>
        </form>
    </div>

</body>
</html>
