<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <!-- width=device-width : sets the width of the page to follow the screen-width of the device (which will vary depending on the device).-->
    <!-- initial-scale=1 : sets the initial zoom level when the page is first loaded by the browser.-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Include bootstrap CSS et JS minified files-->
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" media="screen">
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
    <title><spring:message code="header.label.appName"/></title>
</head>
<body>
<nav class="navbar navbar-default" style="background-color: #a6e1ec">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><spring:message code="header.label.appName"/></a>
        </div>
        <div class="navbar-right">
            <form>
                <select id="lang" name="lang" onchange="submit()">
                    <option value="fr_FR" ${pageContext.response.locale == 'fr_FR' ? 'selected' : ''}>Français</option>
                    <option value="en_US" ${pageContext.response.locale == 'en_US' ? 'selected' : ''}>English</option>
                </select>
            </form>
        </div>
    </div>
</nav>
