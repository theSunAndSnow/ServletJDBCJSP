package com.theSunAndSnow.servlet;

import com.theSunAndSnow.entity.Student;
import com.theSunAndSnow.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentRepository studentRepository = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentRepository = new StudentRepository();
        List<Student> list = studentRepository.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("S_name"),
                sex = req.getParameter("Ssex"),
                s_no = req.getParameter("S_no"),
                class_no = req.getParameter("Class_no");

        studentRepository = new StudentRepository();
        studentRepository.add(name, sex, s_no, class_no);

        resp.sendRedirect("/student");
    }
}
