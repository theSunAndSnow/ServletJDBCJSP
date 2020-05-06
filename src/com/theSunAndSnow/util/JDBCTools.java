package com.theSunAndSnow.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

// 专门用来解决 数据库连接过程中的重复代码 问题
public class JDBCTools {
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource("study");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
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
