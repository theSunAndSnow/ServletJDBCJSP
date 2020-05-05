package com.theSunAndSnow.servlet;

import com.theSunAndSnow.entity.Student;
import com.theSunAndSnow.repository.StudentRepository;
import com.theSunAndSnow.util.JDBCTools;
import jdk.nashorn.internal.scripts.JD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentRepository studentRepository = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentRepository = new StudentRepository();
        String method = req.getParameter("method");
        if (method == null) {
            List<Student> list = studentRepository.findAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            switch (method) {
                case "put":
                    String s_no2 = req.getParameter("s_no");
                    try {
                        Student student = studentRepository.findBySno(s_no2);
                        req.setAttribute("student", student); // 传递键值对student
                        resp.sendRedirect("put.jsp");
//                        req.getRequestDispatcher("put.jsp").forward(req, resp);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "delete":
                    String s_no = req.getParameter("s_no");
                    studentRepository.deleteBySno(s_no);
                    resp.sendRedirect("/student");
                    break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String name = req.getParameter("S_name"),
                        sex = req.getParameter("Ssex"),
                        s_no = req.getParameter("S_no"),
                        class_no = req.getParameter("Class_no");

                studentRepository = new StudentRepository();
                studentRepository.add(name, sex, s_no, class_no);

                break;

            case "put":
                String s_no1 = req.getParameter("s_no"),
                        new_name = req.getParameter("s_name"),
                        new_sex = req.getParameter("s_sex"),
                        new_class_no = req.getParameter("class_no");
                String sql = "update student set S_name = ?, Ssex = ?, Class_no = ? where S_no = ?";
                Connection connection = JDBCTools.getConnection();
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, new_name);
                    preparedStatement.setString(2, new_sex);
                    preparedStatement.setString(3, new_class_no);
                    preparedStatement.setString(4, s_no1);

                    preparedStatement.executeUpdate();

                    JDBCTools.release(connection, preparedStatement, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

        resp.sendRedirect("/student");
    }
}
