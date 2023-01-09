package myDBtest.dao;

import java.sql.*;

public class ConnectionManager {
    private static final String URL_KEY = "mydbtest.url";
    private static final String USER_KEY = "mydbtest.user";
    private static final String PASSWORD_KEY = "mydbtest.password";

    private Connection connection = null;
    private Statement statement = null;

    public ConnectionManager() {
        try {
            Connection connection = DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
            Statement statement = connection.createStatement();
            this.connection = connection;
            this.statement = statement;
        } catch (SQLException e) {
            System.out.println("Connection error " + e.getMessage());
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("failed to close the connection");
        }
    }
}
