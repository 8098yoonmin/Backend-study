import java.sql.*;
import java.util.*;

public class PassengerList {

    List<Passenger> passengerList = new ArrayList<>();
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseURL = "jdbc:mysql://localhost:/module06";

    public static void loadDriver(String driverName) {
        try{
            Class.forName(driverName);
        }
        catch(ClassNotFoundException e)  {
            e.printStackTrace();
        }
    }

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    public List<Passenger> getData() {
        loadDriver(driverName);
        Connection myConnection = null;
        PreparedStatement state = null;
        ResultSet result = null;
     
        try {
            myConnection = DriverManager.getConnection(databaseURL,"root", "rgw21due!"); 
            String sqlQuery = "SELECT PassengerNo, PassengerName, Grade, Age FROM Passenger";
            
            state = myConnection.prepareStatement(sqlQuery); 
            result = state.executeQuery(sqlQuery);

            while(result.next()) { 
                this.passengerList.add(new Passenger(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
                ));
            }
            
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
        finally{
            try{
                result.close();
                state.close();
                myConnection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return passengerList;
    }

 
}
