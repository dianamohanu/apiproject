<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="formBtnStyle" value="/resources/style/formBtnStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${formBtnStyle}">
    <c:url var="tableStyle" value="/resources/style/tableStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${tableStyle}">
    <c:url var="formsJS" value="/resources/js/forms.js"/>

    <c:url var="getAll" value="/backoffice/reservation/getAll"/>
    <c:url var="getAllStartingToday" value="/backoffice/reservation/getAllStartingToday"/>
    <c:url var="getAllEndingToday" value="/backoffice/reservation/getAllEndingToday"/>
    <c:url var="filtersURL" value="/backoffice/reservation/getAllByFilters"/>
</head>
<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h4 style="color: #3E4E51">RESERVATIONS</h4>
        <h5 style="color: #3E4E51"><strong>VIEW: </strong>
            <a href="${getAll}" style="color: #3E4E51;">All</a> |
            <a href="${getAllStartingToday}" style="color: #3E4E51;">All Starting Today</a> |
            <a href="${getAllEndingToday}" style="color: #3E4E51;">All Ending Today</a>
        </h5>

        <hr>

        <h5 style="color: #3E4E51"><strong>FILTERS: </strong></h5>
        <form:form class="form-inline" method="POST" action="${filtersURL}" commandName="filtersForm">
            <div class="form-group">
                <form:input id="firstName" type="text" path="firstName" class="form-control" placeholder="First Name"/>
            </div>
            &nbsp;
            <div class="form-group">
                <form:input id="lastName" type="text" path="lastName" class="form-control" placeholder="Last Name"/>
            </div>

            <input type="submit" class="btn btn-save btn-sm" value="Search"/>
        </form:form>

        <hr>

        <c:if test="${not empty reservations}">
            <div class="table-responsive">
                <table class="table table-condensed">
                    <thead>
                    <th>#nr</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Room Number</th>
                    <th>Capacity</th>
                    <th>Client</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="reservation" items="${reservations}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>

                            <td>${reservation.startDateFormatted}</td>
                            <td>${reservation.endDateFormatted}</td>
                            <td>${reservation.room.roomNumber}</td>
                            <c:if test="${reservation.room.capacity == 1}">
                                <td>${reservation.room.capacity} adult</td>
                            </c:if>
                            <c:if test="${reservation.room.capacity > 1}">
                                <td>${reservation.room.capacity} adults</td>
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
                            <td>
                                <table class="table">
                                    <tr>
                                        <td><a href="#" style="color: #3E4E51; font-size: 10px" data-toggle="tooltip"
                                               title="Permanently delete this reservation!">Cancel</a></td>
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

<script type="application/javascript" src="${formsJS}"></script>

</body>
</html>
