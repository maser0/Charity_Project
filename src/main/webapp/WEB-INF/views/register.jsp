<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Witek
  Date: 2020-06-21
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <<jsp:include page="header.jsp"/>
</header>

<section class="login-page">
<h2>Załóż konto</h2>
<form:form method="post" modelAttribute="user" action="/register">
    <form:hidden path="id"/>
    <div class="form-group">


    <form:input path="username" placeholder="Email"/>
    <form:errors path="username"/>
    </div>
    <div class="form-group">


        <form:input path="firstName" placeholder="Imię"/>
        <form:errors path="firstName"/>
    </div>
    <div class="form-group">


        <form:input path="surname" placeholder="Nazwisko"/>
        <form:errors path="surname"/>
    </div>
    <div class="form-group">

    <form:input path="password" placeholder="Hasło" type="password"/>
    <form:errors path="password"/>
    </div>
    <div class="form-group">

    </div>

    <div class="form-group form-group--buttons">
    <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
    <button class="btn" type="submit">Zatwierdź</button>
    </div>
</form:form>
    </section>

    <jsp:include page="footer.jsp"/>
    </body>
    </html>

