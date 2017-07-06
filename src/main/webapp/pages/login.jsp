<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

<%@ include file = "header.jsp"%>

<div class="container-fluid">
    <div class="container" style="width: 300px;">
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="admin">
            <input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="color: darkgrey">Войти</button>
        </form>
    </div>
</div>

<%@ include file = "footer.jsp"%>