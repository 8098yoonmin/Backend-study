<%--
  Created by IntelliJ IDEA.
  User: songdo-eon
  Date: 2023/04/05
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>학생-조회</title>

</head>
<body>
<jsp:include page="/WEB-INF/view/loginInfo.jsp" />
<table>
  <tbody>
    <tr>
      <td>아이디</td>
      <td>${student.id}</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${student.name}</td>
    </tr>
    <tr>
      <td>성별</td>
      <td>${student.gender}</td>
    </tr>
    <tr>
      <td>나이</td>
      <td>${student.age}</td>
    </tr>
      <td>등록일</td>
      <td><fmt:formatDate value="${student.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" />
      </td>
    </tr>
  </tbody>
</table>
<ul>
  <li><a href="/list">리스트</a></li>
  <li>
    <form method="get" action="/update">
      <input type="hidden" name="id" value="${student.id}" />
      <button type="submit">수정</button>
    </form>
  </li>
  <li>
    <form method="post" action="/delete">
      <input type="hidden" name="id" value="${student.id}" />
      <button type="submit">삭제</button>
    </form>
  </li>
</ul>
</body>
</html>