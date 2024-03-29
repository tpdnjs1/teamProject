package com.example.teamproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection connection;

    public static DBUtil instance;

    public static DBUtil getInstance() {
        if (instance == null) {
            instance = new DBUtil();

        }
        return instance;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/project";
        String userName = "root";
        String password = "";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
