<%--
  Created by IntelliJ IDEA.
  User: Sun and Snow
  Date: 2020/5/4
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <table>
      <tr>
        <th>学号</th>
        <th>班级号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
      </tr>
      <c:forEach items="${list}" var="student">
        <tr>
          <td>${student.getS_no()}</td>
          <td>${student.getClass_no()}</td>
          <td>${student.getS_name()}</td>
          <td>${student.getSsex()}</td>
          <td>${student.getS_birthday()}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
