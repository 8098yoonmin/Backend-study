<%--
  Created by IntelliJ IDEA.
  User: yoonmin
  Date: 2023/04/07
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foodStand</title>
</head>
<body>
<%-- foreach문의 iterator가 안되는 이유..arraylist라서? 그냥 list로 선언하면 됐으려나?--%>
  <form method="post" action="/cart" value="${applicationScope.foodStand}">
    <h5>상품목록</h5>
    양파 - 가격: ${initParam.onion} / 개수: ${applicationScope.onionAmount}
  </br>
    계란 - 가격: ${initParam.egg} / 개수: ${applicationScope.eggAmount}
  </br>
    <h5>구매할 수량을 입력해주세요</h5>
    양파 개수 : <input type="number" name="onion" max="${applicationScope.onionAmount}" required />
  </br>
    계란 개수 : <input type="number" name="egg" max="${applicationScope.eggAmount}" required/>
  </br>
  <input type="submit" value="전송" />
  </form>

</body>
</html>
