<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>HotelBook Management Console</title>
    <c:url var="favicon" value="/resources/images/favicon.png"/>
    <link rel="shortcut icon" href="${favicon}">

    <jsp:include page="bootstrapImports.jsp"/>

    <c:url var="loginLogoutStyle" value="/resources/style/loginLogout.css"/>
    <link rel="stylesheet" type="text/css" href="${loginLogoutStyle}">
    <c:url var="formStyle" value="/resources/style/formStyle.css"/>
    <link rel="stylesheet" type="text/css" href="${formStyle}">

    <c:url var="addReservationURL" value="/backoffice/reservation/add"/>

    <%--<c:url var="backgroundImage" value="/resources/images/backgroundImg.jpg"/>--%>
</head>
<body background="${backgroundImage}">
<jsp:include page="headerManager.jsp"/>

<div class="container">
    <div class="col-md-4"></div>

    <div class="col-md-4" style="background-color: #e6e6fa">
        <h4 style="color: #3E4E51">ADD RESERVATION</h4>

        <form:form method="POST" action="${addReservationURL}" commandName="reservationForm">
            <div class="row">
                <div class="form-group col-xs-6">
                    <form:label path="startDate">START DATE:</form:label>
                    <form:input type="date" path="startDate" class="form-control"/>
                </div>
                <div class="form-group col-xs-6">
                    <form:label path="endDate">END DATE:</form:label>
                    <form:input type="date" path="endDate" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="capacity">ROOM CAPACITY:</form:label>
                <form:input type="number" path="capacity" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="firstName">FIRST NAME:</form:label>
                <form:input type="text" path="firstName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">LAST NAME:</form:label>
                <form:input type="text" path="lastName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="phoneNumber">PHONE NUMBER:</form:label>
                <form:input type="text" path="phoneNumber" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="email">EMAIL:</form:label>
                <form:input type="email" path="email" class="form-control"/>
            </div>

            <input type="submit" class="btn btn-save" value="Save"/>
        </form:form>
    </div>

    <div class="col-md-4"></div>
</div>

</body>
</html>
