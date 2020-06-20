<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <jsp:include page="header.jsp"/>



</header>

<%--<section class="stats">--%>
<%--    <div class="container container--85">--%>
<%--        <div class="stats--item">--%>
<%--            <em>${bags}</em>--%>

<%--            <h3>Przekazanych worków</h3>--%>
<%--            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum--%>
<%--                tempora!</p>--%>
<%--        </div>--%>

<%--        <div class="stats--item">--%>
<%--            <em>${donations.size()}</em>--%>
<%--            <h3>Przekazanych darów</h3>--%>
<%--            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas--%>
<%--                quam.</p>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</section>--%>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="#" class="btn btn--large">Załóż konto</a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section class="help">
<form:form method="post" modelAttribute="donation" action="/form">


<div>
    <li>
        Zaznacz co chcesz oddać:
        <c:forEach items="${categories}" var="category">
<%--        <form:checkboxes path="categories"  items="${category.name}"/>--%>
            <input type="checkbox" name="categories" value="${category.id}">${category.name}
        </c:forEach>
    </li>
    <br>

</div>
    <div>
        <li>
            Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:
            <form:input path="quantity"/>
        </li>
        <br>
    </div>
    <div>
        Wybierz organizacje, której chcesz pomóc:
        <c:forEach items="${institutions}" var="institution">
            <input type="radio" name="institution" value="${institution.id}"> ${institution.name}
<%--        <form:select path="institution" items="${institutions}"/>--%>
        </c:forEach>
        <br>
    </div>
    <div>
        Podaj adres oraz termin odbioru rzeczy przez kuriera:
        <li>
        <form:input path="street" />
        <form:input path="city"/>
        <form:input path="zipCode" />
            <br>
        </li>
        <li>
        <form:textarea path="pickUpComment"/>
        <form:input type="date" path="pickUpDate"/>
        <form:input type="time" path="pickUpTime" />
            <br>
        </li>

    </div>
    <input type="submit">
</form:form>



</section>

<jsp:include page="footer.jsp"/>



<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
