<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Witek
  Date: 2020-06-23
  Time: 16:01
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

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> "/>
</head>
<body>
<header class="header--main-page">
    <jsp:include page="header.jsp"/>

<%--<TABLE>--%>
<%--    <TR>--%>
<%--        <TH>Nazwa</TH>--%>
<%--        <th>opis</th>--%>
<%--    </TR>--%>
<%--    <c:forEach items="${institutions}" var="institutions">--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                ${institutions.name}--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                ${institutions.description}--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</TABLE>--%>

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

<section >
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section>
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>
        <a class="btn btn--without-border" href="/institution/create">Dodaj nową fundacje</a>

        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="count">
                <c:if test="${count.count % 2 != 0}" >
                    <li>
                </c:if>
                <div class="col">
                    <div class="title">Fundacja "${institution.name}"</div>
                    <div class="subtitle">Cel i misja: ${institution.description}</div>
                    <div>
                        <a class="btn btn--without-border" href="/institution/${institution.id}">Edytuj</a>
                        <a class="btn btn--without-border" href="/institution/delete/${institution.id}">Usuń</a>
<%--                        tu dac admin w linku --%>
                    </div>

                </div>
                <c:if test="${count.count %2 == 0}">

                    </li>
                </c:if>
            </c:forEach>

        </ul>
    </div>

</section>

<jsp:include page="footer.jsp"/>



<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
