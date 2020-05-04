<%--
  Created by IntelliJ IDEA.
  User: Sun and Snow
  Date: 2020/5/5
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>put</title>
</head>
<body>
    <form action="/student" method="post">
            学号：<input type="text" name="s_no" value="${student.getS_no()}" readonly><br>
            姓名：<input type="text" name="s_name" value="${student.getS_name()}"><br>
            性别：<input type="text" name="s_sex" value="${student.getSsex()}"><br>
            班级号：<input type="text" name="class_no" value="${student.getClass_no()}"><br>
            <input type="hidden" name="method" value="put"></input> // 以表单的方式传递网页参数
            <input type="submit" value="修改">
    </form>
</body>
</html>
