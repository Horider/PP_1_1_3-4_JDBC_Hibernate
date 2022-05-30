package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соединения с БД
    private static String hostName = "localhost";
    private static String dbName = "mydbtest";
    private static String userName = "root";
    private static String password = "root";
    public static Connection connection;

    public static Connection getConnection()  {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
