<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <c:url var="formBtnStyle" value="/resources/style/formBtnStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${formBtnStyle}">
    <c:url var="tableStyle" value="/resources/style/tableStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${tableStyle}">

    <c:url var="getAll" value="/backoffice/reservation/getAll"/>
    <c:url var="getAllStartingToday" value="/backoffice/reservation/getAllStartingToday"/>
    <c:url var="getAllEndingToday" value="/backoffice/reservation/getAllEndingToday"/>
    <c:url var="filtersURL" value="/backoffice/reservation/getAllByFilters"/>

    <jsp:include page="bootstrapImports.jsp"/>
</head>
<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h4 style="color: #3E4E51">RESERVATIONS</h4>

        <h5 style="color: #3E4E51"><strong>VIEW: </strong></h5>
        <a href="${getAll}">All</a>
        <a href="${getAllStartingToday}">All Starting Today</a>
        <a href="${getAllEndingToday}">All Ending Today</a>

        <h5 style="color: #3E4E51"><strong>FILTERS: </strong></h5>
        <form:form class="form-inline" method="POST" action="${filtersURL}" commandName="filtersForm">
            <div class="form-group">
                <form:label path="firstName">FIRST NAME:</form:label>
                <form:input id="firstName" type="text" path="firstName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">LAST NAME:</form:label>
                <form:input id="lastName" type="text" path="lastName" class="form-control"/>
            </div>

            <input type="submit" class="btn btn-save btn-sm" value="Search"/>
        </form:form>

        <c:if test="${not empty reservations}">
            <div class="table-responsive">
                <table class="table table-condensed">
                    <thead>
                    <th>#nr</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Room ID</th>
                    <th>Capacity</th>
                    <th>Client</th>
                    </thead>
                    <tbody>
                    <c:forEach var="reservation" items="${reservations}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>

                            <td>${reservation.startDateFormatted}</td>
                            <td>${reservation.endDateFormatted}</td>
                            <td>${reservation.room.roomId}</td>
                            <c:if test="${reservation.room.capacity == 1}">
                                <td>${reservation.room.capacity} person</td>
                            </c:if>
                            <c:if test="${reservation.room.capacity > 1}">
                                <td>${reservation.room.capacity} people</td>
                            </c:if>
                            <td>
                                <table class="table table-condensed table-striped table-bordered">
                                    <tr>
                                        <td>${reservation.client.firstName}</td>
                                    </tr>
                                    <tr>
                                        <td>${reservation.client.lastName}</td>
                                    </tr>
                                    <tr>
                                        <td>${reservation.client.phoneNumber}</td>
                                    </tr>
                                    <tr>
                                        <td>${reservation.client.email}</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${empty reservations}">
            <h5 style="color: #3E4E51"><strong>No reservations found.</strong></h5>
        </c:if>

    </div>
    <div class="col-md-2"></div>
</div>

</body>
</html>
