package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 专门用来访问数据库的类
public class StudentRepository {
    public List<Student> findAll() {

        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8";
            String root = "root"; // 数据库用户名
            String password = "18325379510"; // 数据库密码
            connection = DriverManager.getConnection(url, root, password); // 建立数据库连接

            String sql = "select * from student;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(); // 进行 SELECT 查询

            while (resultSet.next()) {
                    String s_no = resultSet.getString(1);
                    String class_no = resultSet.getString(2);
                    String s_name = resultSet.getString(3);
                    String ssex = resultSet.getString("Ssex");
                    Date s_birthday = resultSet.getDate("S_birthday");

                    list.add(new Student(s_no, class_no, s_name, ssex, s_birthday));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return list;
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        List<Student> list = studentRepository.findAll();

        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
