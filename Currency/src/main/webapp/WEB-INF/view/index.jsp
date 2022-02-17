<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="/static/style/style.css">
</head>
<body>
<nav>
    <menu>
        <li><a href="/addUser">New User</a></li>
    </menu>
</nav>

<table>
    <caption>Курс Валют</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Покупка</th>
        <th>Продажа</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <th>USD</th>
        <td class="usd1"></td>
        <td class="usd2"></td>
    </tr>
    <tr>
        <th>EUR</th>
        <td class="eur1"></td>
        <td class="eur2"></td>
    </tr>
    <tr>
        <th>RUR</th>
        <td class="rur1"></td>
        <td class="rur2"></td>
    </tr>
    </tbody>
</table>
<script src="/static/js/script2.js"></script>
<br>
<caption>User List</caption>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>FirstName</th>
        <th>LastName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><a href="<c:url value="/user/delete?id=${user.id}"/>">Delete</a></td>
            <td><a href="/exchange/${user.id}">Transactions</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
