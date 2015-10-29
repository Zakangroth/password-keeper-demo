<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- width=device-width : sets the width of the page to follow the screen-width of the device (which will vary depending on the device).-->
    <!-- initial-scale=1 : sets the initial zoom level when the page is first loaded by the browser.-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Include bootstrap CSS et JS minified files-->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" media="screen">
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <title><spring:message code="header.label.appName"/></title>
</head>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class=" container">
        <div class="navbar-header">
            <strong><a class="navbar-brand" href="#"><spring:message code="header.label.appName"/></a></strong>
        </div>
        <div>
            <ul class="nav">
                <li class="navbar-right">
                    <form class="navbar-form">
                        <select class="form-control" id="lang" name="lang" onchange="submit()">
                            <option value="fr_FR" ${pageContext.response.locale == 'fr_FR' ? 'selected' : ''}>Français
                            </option>
                            <option value="en_US" ${pageContext.response.locale == 'en_US' ? 'selected' : ''}>English
                            </option>
                        </select>
                    </form>
                </li>
                <c:if test="${user != null}">
                    <li class="navbar-right">
                        <p class="navbar-btn">
                            <a href="/logout"
                               class="btn btn-default"><spring:message code="login.button.logout"/> </a>
                        </p>
                    </li>
                    <li class="navbar-nav navbar-text navbar-right" style="margin-right: 2%">
                        <i class="glyphicon glyphicon-user"></i>
                        </span><spring:message code="header.label.hello"/> ${user}
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
