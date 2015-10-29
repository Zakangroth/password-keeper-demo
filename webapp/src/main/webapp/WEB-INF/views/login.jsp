<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/header.jsp"/>
<div class="container" style="margin-top:10%">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> <spring:message code="login.label.signInMessage"/></strong>
                </div>
                <div class="panel-body">
                    <form role="form" action="/login" method="POST">
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
                                            <input class="form-control"
                                                   placeholder="<spring:message code="login.label.username"/>"
                                                   id="username"
                                                   name="username"
                                                   type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
                                            <input class="form-control"
                                                   placeholder="<spring:message code="login.label.password"/>"
                                                   id="password"
                                                   name="password" type="password" value="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <input type="submit" class="btn btn-lg btn-primary btn-block"
                                               style="background-color: lightblue; border: none"
                                               value="<spring:message code="login.button.login"/>">
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p><spring:message code="login.label.wrongCredentials"/></p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p><spring:message code="login.label.loggedOut"/></p>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="include/footer.jsp"/>
