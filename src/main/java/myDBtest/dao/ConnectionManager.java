package myDBtest.dao;

import myDBtest.service.PropertiesUtil;

import java.sql.*;

public class ConnectionManager {
    private static final String URL_KEY = "mydbtest.url";
    private static final String USER_KEY = "mydbtest.user";
    private static final String PASSWORD_KEY = "mydbtest.password";

    private Connection connection = null;

    public ConnectionManager() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            System.out.println("Connection error " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("failed to close the connection");
        }
    }
}
