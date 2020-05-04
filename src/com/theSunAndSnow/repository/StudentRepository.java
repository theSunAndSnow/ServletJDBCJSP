package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Student;
import com.theSunAndSnow.util.JDBCTools;

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

            connection = JDBCTools.getConnection();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCTools.release(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return list;
    }

    public void add(String s_name, String ssex, String s_no, String class_no) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = JDBCTools.getConnection(); // 建立数据库连接

            String sql = "insert into student(S_no, Class_no, S_name, Ssex, S_birthday)" +
                    "value (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s_no);
            preparedStatement.setString(2, class_no);
            preparedStatement.setString(3, s_name);
            preparedStatement.setString(4, ssex);
            preparedStatement.setDate(5, new java.sql.Date(1));

            preparedStatement.executeUpdate(); // 进行 INSERT

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCTools.release(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        List<Student> list = studentRepository.findAll();

        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
