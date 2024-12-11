package com.example.final_module3.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo  {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/libary?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456";
    private static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private BaseRepo() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
