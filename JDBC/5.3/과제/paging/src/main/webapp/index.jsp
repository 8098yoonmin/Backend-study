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

        String sqlQuery = "SELECT COUNT(*) FROM MEMBERS ";
        Connection connection = DButils.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);
        result.next();
        int totalItems = result.getInt(1);

        PreparedStatement pstmtList = connection.prepareStatement("SELECT * FROM members LIMIT ?, ?");
        pstmtList.setInt(1, (currentPage-1) * itemsPerPage);
        pstmtList.setInt(2, itemsPerPage);
        ResultSet rsList = pstmtList.executeQuery();

        int totalPages = totalItems/ itemsPerPage;

        int startPage = (currentPage /10) *10 +1;
        int endPage = startPage +9;
        if(endPage > totalPages) {
            endPage = totalPages;
        }

        String prevLink = "<a href=\"?page=" + (currentPage -1) + "\">Prev</a>";
        String nextLink = "<a href=\"?page=" + (currentPage +1) + "\">Next</a>";
        String firstLink = "<a href=\"?page=1\">First</a>";
        String lastLink = "<a href=\"?page="+ totalPages + "\">Last</a>";

        if(currentPage ==1) {
            prevLink ="Prev";
            firstLink = "First";
        }

        if(currentPage == totalPages) {
            nextLink="Next";
            lastLink="Last";
        }

        while(rsList.next()) {
            int id = rsList.getInt(1);
            String name = rsList.getString(2);
            String city = rsList.getString(3);
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
<div>
    <%= firstLink %> | <%= prevLink%>

    <% for( int i= startPage; i<=endPage; i++) { %>
    <a href="?page=<%= i %>"><%= i%></a>
    <% } %>

    <%= nextLink%> | <%= lastLink%>
</div>
<div>
    <p>Page <%= currentPage%> of <%=totalPages%></p>
    <p>Total items: <%=totalItems %></p>
</div>
</body>
</html>