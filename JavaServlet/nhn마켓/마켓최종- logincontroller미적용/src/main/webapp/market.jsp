<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hello market</title>
</head>
<body>
    <h3> 어서오세요,NHN마켓입니다.</h3>
    <p><a href="/init.do">구경하기</a></p>
    <p><a href="/food.do">상품목록 확인하기</a></p>
    <p><a href="/cart.do">장바구니</a></p>
    <p><h3>현재 포인트: ${applicationScope.money}</h3></p>
    <p><a href='/logout'>logout</a></p>
</body>
</html>