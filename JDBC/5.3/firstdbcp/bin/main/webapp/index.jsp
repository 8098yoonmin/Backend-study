<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import ="com.nhnacademy.firstdbcp.utils.DBUtils"%>
<%@ page import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>passengers</title>
</head>
<body>
<table border="1">
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>등급</td>
        <td>나이</td>
    </tr>

    <%

        String sqlQuery = "SELECT * FROM PASSENGER";
        Connection connection = DBUtils.getDataSource().getConnection();


        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);

        while(result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            int wh = result.getInt(3);
            int age = result.getInt(4);
    %>
    <tr>
        <td><a href="reservation.jsp?id=<%=id %>"><%=id %></a></td>
        <td><%=name %></td>
        <td><%=wh%></td>
        <td><%=age %></td>

    </tr>
    <%
        }
        result.close();
        statement.close();
        connection.close();

    %>
</table>


</body>
</html>