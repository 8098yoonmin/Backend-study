import java.sql.*;

public class FirstConnection{
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseURL = "jdbc:mysql://localhost:/module06";
    private static final String userName = "root";
    private static final String password = "rgw21due!";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    public void connect() {
        try{
            // 클래스 로딩을 해줘야함
            Class.forName(driverName);
            connection = DriverManager.getConnection(databaseURL, userName, password);
      
            String sqlQuery = "SELECT * FROM PASSENGER WHERE PassengerNo= ?";
            
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,2);

            result = statement.executeQuery();

            while(result.next()) {
                System.out.print(result.getInt(1)+" ");
                System.out.print(result.getString(2) +" ");
                System.out.print(result.getString(3) +" ");
                System.out.println(result.getString(4) +" ");

            }
            result.close();
            statement.close();
            connection.close();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FirstConnection connection = new FirstConnection();
        connection.connect();

    }


}