<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="/static/style/style.css">
</head>
<body>
<h1>Add User</h1>
<form method="post">
    <h3>Укажите имя нового пользователя</h3>
    <input type="text" name="firstName"><br>
    <h3>Укажите фамилию нового пользователя</h3>
    <input type="text" name="lastName"><br>
    <h3>Добавить</h3>
    <input type="submit">
</form>
</body>
</html>
