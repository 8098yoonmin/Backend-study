<%--
  Created by IntelliJ IDEA.
  User: yoonmin
  Date: 2023/04/07
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mycart</title>
</head>
<body>
  <h1>장바구니</h1>
<%--    왜 sessionscope?--%>
    <p>양파 : ${onionNum} 개</p>
    <p>계란 : ${eggNum} 개</p>
    </br>
    <h3>합계 : ${sum}</h3>
</body>
</html>
