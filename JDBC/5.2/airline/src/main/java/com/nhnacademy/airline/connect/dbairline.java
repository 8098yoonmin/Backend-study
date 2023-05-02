package com.nhnacademy.airline.connect;

import java.sql.*;
public class dbairline {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseURL = "jdbc:mysql://localhost:3306/module06";
    private static final String userName = "root";
    private static final String password = "rgw21due!";



    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(databaseURL, userName, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
