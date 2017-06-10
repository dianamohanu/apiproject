<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <c:url var="getAllReservations" value="/backoffice/reservation/getAll"/>
    <c:url var="getAllStartingOnDate" value="/backoffice/reservation/getAllStartingOnDate"/>
    <c:url var="getAllEndingOnDate" value="/backoffice/reservation/getAllEndingOnDate"/>
</head>

<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <a href="${getAllReservations}">View all reservations</a>

    <form:form method="GET" action="${getAllEndingOnDate}" commandName="dateForm">
        <form:label path="date">Date:</form:label>
        <form:input type="date" path="date"/>
        <input type="submit" value="View all reservations ending on date"/>
    </form:form>
</div>
</body>
</html>
