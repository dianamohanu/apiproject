<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="formStyle" value="/resources/style/formStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${formStyle}">
    <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
    <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">

    <c:url var="addReservationURL" value="/backoffice/reservation/add"/>
</head>
<body>
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <div class="col-md-3"></div>

    <div class="col-md-4" style="background-color: #eee8e8">
        <h4 style="color: #3E4E51">ADD RESERVATION</h4>

        <form:form method="POST" action="${addReservationURL}" commandName="reservationForm">
            <div class="row">
                <div class="form-group col-xs-6 ">
                    <form:label path="startDate">START DATE:</form:label>
                    <form:input id="startDate" type="date" path="startDate" class="form-control"/>
                </div>
                <div class="form-group col-xs-6">
                    <form:label path="endDate">END DATE:</form:label>
                    <form:input id="endDate" type="date" path="endDate" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="capacity">ROOM CAPACITY:</form:label>
                <form:input id="capacity" type="number" path="capacity" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="firstName">FIRST NAME:</form:label>
                <form:input id="firstName" type="text" path="firstName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">LAST NAME:</form:label>
                <form:input id="lastName" type="text" path="lastName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="phoneNumber">PHONE NUMBER:</form:label>
                <form:input id="phoneNumber" type="text" path="phoneNumber" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="email">EMAIL:</form:label>
                <form:input id="email" type="email" path="email" class="form-control"/>
            </div>

            <input type="submit" class="btn btn-save" value="Save"/>
            <input type="button" onclick="formReset();" class="btn btn-save" value="Reset">
        </form:form>
    </div>

    <div class="col-md-4">
        <c:if test="${not empty reservationForm.email}">
            <c:if test="${not empty reservedRoom}">
                <p style="color: #3E4E51">Room <strong>${reservedRoom}</strong> was successfully reserved.</p>
                <h5 style="color: #3E4E51">RESERVATION DETAILS</h5>
                <p style="color: #3E4E51">Start date: <strong>${reservationForm.startDate}</strong></p>
                <p style="color: #3E4E51">End date: <strong>${reservationForm.endDate}</strong></p>
                <p style="color: #3E4E51">Room capacity: <strong>${reservationForm.capacity}</strong></p>
                <p style="color: #3E4E51">First name: <strong>${reservationForm.firstName}</strong></p>
                <p style="color: #3E4E51">Last name: <strong>${reservationForm.lastName}</strong></p>
                <p style="color: #3E4E51">Phone number: <strong>${reservationForm.phoneNumber}</strong></p>
                <p style="color: #3E4E51">Email: <strong>${reservationForm.email}</strong></p>
                <br>
                <p style="color: #3E4E51">A confirmation email was sent to: <strong>${reservationForm.email}</strong>
                </p>
            </c:if>
            <c:if test="${empty reservedRoom}">
                <div class="errorblock">No room with capacity ${reservationForm.capacity} is available
                    between ${reservationForm.startDate}
                    and ${reservationForm.endDate}.
                </div>
            </c:if>
        </c:if>
    </div>

    <div class="col-md-1"></div>
</div>

<script type="application/javascript" src="${formsJS}"></script>

</body>
</html>
