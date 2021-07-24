<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="http://localhost:8080/WebServer/hello2" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        兴趣爱好：
        <input type="checkbox" name="hobby" value="java">java
        <input type="checkbox" name="hobby" value="python">python
        <input type="submit">
    </form>
</body>
</html>