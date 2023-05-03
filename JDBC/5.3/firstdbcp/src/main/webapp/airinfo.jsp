<%@ page import="java.sql.*" %>
<%@ page import="com.nhnacademy.firstdbcp.utils.DBUtils" %>
<%@ page import="javax.xml.transform.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>airline</title>
</head>
<body>
<table border="1">
    <tr>
        <td>항공편</td>
        <td>비행편</td>
        <td>출발</td>
        <td>도착</td>
        <td>가격</td>
        <td>날짜</td>
    </tr>

    <%
        Connection connection = DBUtils.getDataSource().getConnection();
        String sqlQuery = "SELECT * FROM FLIGHT WHERE flightNo = ?";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, request.getParameter("id"));

        ResultSet result = statement.executeQuery();

        while(result.next()) {
            int flightno = result.getInt(1);
            int aircraftno = result.getInt(2);
            String departure = result.getString(3);
            String arrival = result.getString(4);
            int price = result.getInt(5);
            String flightdate =  String.valueOf(result.getDate(6))+ String.valueOf(result.getTime(6));
    %>
    <tr>
        <td><%=flightno %></td>
        <td><%=aircraftno %></td>
        <td><%=departure%></td>
        <td><%=arrival %></td>
        <td><%=price %></td>
        <td><%=flightdate %></td>


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
