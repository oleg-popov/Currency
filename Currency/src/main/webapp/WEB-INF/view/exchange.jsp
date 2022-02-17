<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="/static/style/style.css">
</head>
<body>
<div class="main">
    <form method="post" id="currency">
        <div class="data">
            <div class="currencyChoose">
                <label for="buy-currency">Покупка : <br>
                    <select name="buy-currency" id="buy-currency">
                        <option value="USD">USD</option>
                        <option value="UAH">UAH</option>
                        <option value="EUR">EUR</option>
                        <option value="RUB">RUR</option>
                    </select>
                </label>
                <label for="sell-currency">Продажа : <br>
                    <select name="sell-currency" id="sell-currency">
                        <option value="USD" disabled>USD</option>
                        <option value="UAH">UAH</option>
                        <option value="EUR">EUR</option>
                        <option value="RUB">RUR</option>
                    </select>
                </label>
            </div>

            <div class="fieldsForAmount">
                Сумма покупки :
                <label for="amount">
                    <input type="number" name="amount" id="amount">
                </label>
                Сумма продажи :
                <label for="sum">
                    <input type="number" name="sum" id="sum" readonly>
                </label>
                <input type="hidden" value="${user.id}" id="userId">
            </div>
        </div>
        <input id="submit_button" type="submit" value="Выполнить"></form>
</div>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Created</td>
        <td>Buy</td>
        <td>Amount</td>
        <td>Sell</td>
        <td>Sum</td>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${user.transactionList}" var="tr">
            <tr>
                <td>${tr.id}</td>
                <td>${tr.created}</td>
                <td>${tr.buy}</td>
                <td>${tr.amount}</td>
                <td>${tr.sell}</td>
                <td>${tr.sum}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/">return</a>
<script src="/static/js/script.js">

</script>
</body>
</html>
