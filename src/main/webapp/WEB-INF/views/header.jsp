<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Witek
  Date: 2020-06-16
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>

    </ul>
    <ul>
        <sec:authorize access="isAuthenticated()">
            Witaj <sec:authentication property="principal.username"/>
            <ul class="dropdown">
                <li><a href="/user">Profil</a></li>
                <li><a href="#">Moje zbiórki</a></li>
                <li><a href="/logout">Wyloguj</a></li>
            </ul>

        </sec:authorize>
    </ul>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <sec:authorize access="hasRole('ADMIN')">
        <li><a href="/admin/institution/list" class="btn btn--without-border">Fundacje i organizacje</a></li>
<%--        <li><a href="#" class="btn btn--without-border">Administratorzy</a></li>--%>
        <li><a href="/admin/user/list" class="btn btn--without-border">Użytkownicy</a></li>
        <li><a href="#" class="btn btn--without-border">Dary</a></li>
        <li><a href="/admin/list" class="btn btn--without-border">Administratorzy</a></li>
            </sec:authorize>
        <sec:authorize access="hasAnyRole('USER', 'ADMIN')">
        <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>
        <li><a href="/donation/user" class="btn btn--without-border">Moje Dary</a></li>
        </sec:authorize>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Zacznij pomagać!<br/>
            Oddaj niechciane rzeczy w zaufane ręce
        </h1>
    </div>
</div>
