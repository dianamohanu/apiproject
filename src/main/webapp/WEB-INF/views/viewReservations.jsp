<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <c:url var="getAll" value="/backoffice/reservation/getAll"/>
    <c:url var="getAllStartingToday" value="/backoffice/reservation/getAllStartingToday"/>
    <c:url var="getAllEndingToday" value="/backoffice/reservation/getAllEndingToday"/>

    <jsp:include page="bootstrapImports.jsp"/>
</head>
<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <h4 style="color: #3E4E51">RESERVATIONS</h4>

    <h5 style="color: #3E4E51"><strong>VIEW: </strong></h5>
    <a href="${getAll}">All</a>
    <a href="${getAllStartingToday}">All Starting Today</a>
    <a href="${getAllEndingToday}">All Ending Today</a>

    <h5 style="color: #3E4E51"><strong>FILTERS: </strong></h5>

    <br>

    <c:forEach var="reservation" items="${reservations}" varStatus="loop">
        <p>
            ${loop.index + 1}
            ${reservation.startDate}
            ${reservation.endDate}
            ${reservation.client.firstName}
            ${reservation.client.lastName}
            ${reservation.client.phoneNumber}
            ${reservation.client.email}
            ${reservation.room.roomId}
            ${reservation.room.capacity}
        </p>
    </c:forEach>
</div>

</body>
</html>
