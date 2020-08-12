<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Witek
  Date: 2020-06-24
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</header>

<<section >
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="/resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="/resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section>
    <h2>Lista Darów</h2>


    <div class="help--slides active" data-id="1">


        <ul class="help--slides-items">
            <c:forEach items="${user.donations}" var="donation" >
                    <li>
                <div class="col">
                    <div class="title">Dar dla  "${donation.institution}"</div>
                    <div class="subtitle">Data odbioru ${donation.pickUpDate}</div>
                    <div class="subtitle">Godzina odbioru ${donation.pickUpTime}</div>
                    <div class="subtitle">Godzina odbioru ${donation.pickUpTime}</div>
                    <c:if test="${donation.status == 1}" >
                        <div class="subtitle">Zamówienie odebrane ${donation.pickUpDate}</div>
                    </c:if>
                    <div>
                        <a class="btn btn--without-border" href="/donation/${donation.id}">Edytuj</a>
                        <a class="btn btn--without-border" href="/delete/${donation.id}">Usuń</a>
                    </div>

                </div>
                    </li>
            </c:forEach>

        </ul>
    </div>

</section>

<jsp:include page="footer.jsp"/>



<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
