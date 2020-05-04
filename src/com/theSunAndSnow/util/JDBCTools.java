package com.theSunAndSnow.util;

import java.sql.*;

// 专门用来解决 数据库连接过程中的重复代码 问题
public class JDBCTools {

    private static String URL = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8";
    private static String ROOT = "root"; // 数据库用户名
    private static String PASSWORD = "18325379510"; // 数据库密码

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, ROOT, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
