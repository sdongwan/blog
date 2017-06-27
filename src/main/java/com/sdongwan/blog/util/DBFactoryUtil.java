package com.sdongwan.blog.util;

import java.sql.*;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DBFactoryUtil {
    private static final String url = "jdbc:mysql://localhost:3306/blog";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver); //加载驱动
        connection = DriverManager.getConnection(url, "root", "sdongwan");

        return connection;

    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (statement != null) {
            statement.close();
        }


        if (connection != null) {
            connection.close();
        }

    }


}
