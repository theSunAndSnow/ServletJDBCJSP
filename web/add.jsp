<%--
  Created by IntelliJ IDEA.
  User: Sun and Snow
  Date: 2020/5/4
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form action="/student" method="post">
        姓名：<input type="text" name="S_name"><br>
        性别：<input type="text" name="Ssex"><br>
        学号：<input type="text" name="S_no"><br>
        班级号：<input type="text" name="Class_no"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
