package com.zq;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    public static Connection connection;

    public JDBCUtil() throws IOException, ClassNotFoundException {
        Properties prop = new Properties();
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("/jdbc.properties");
        prop.load(inputStream);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        //check driver
        Class.forName(driver);
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}