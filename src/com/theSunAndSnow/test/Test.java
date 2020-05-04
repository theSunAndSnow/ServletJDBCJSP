package com.theSunAndSnow.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载驱动
            String url = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8";;
            String user = "root";
            String password = "18325379510";
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
