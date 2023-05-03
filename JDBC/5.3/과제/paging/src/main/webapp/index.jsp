<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.nhnacademy.paging.DButils" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>paging</title>
</head>
<body>
<table border="1">
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>도시</td>
    </tr>

    <%
        int itemsPerPage = 10;
        int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        

        String sqlQuery = "SELECT * FROM MEMBERS";
        Connection connection = DButils.getDataSource().getConnection();


        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);

        while(result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String city = result.getString(3);
    %>
    <tr>
        <td><%=id %></td>
        <td><%=name %></td>
        <td><%=city%></td>
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