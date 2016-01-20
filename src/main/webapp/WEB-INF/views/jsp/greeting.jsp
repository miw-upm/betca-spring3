<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Spring MVC</title>
</head>
<h1>Mi primer Spring MVC</h1>
<h3>Hello ${name}!!!</h3>
<c:if test="${name==null}">
	<form:form action="login" method="post" modelAttribute="loginUser">
		<input name="id" type="number" placeholder="Id" required="required">
		<form:errors class="control-label" path="id" />
		<input name="password" type="password" placeholder="Password">
		<button type="submit" class="btn btn-success">Sign in</button>
	</form:form>
</c:if>

<h5>Lista de Strings</h5>
<ul>
	<c:forEach var="var" items="${stringList}">
		<li>...${var}</li>
	</c:forEach>
</ul>
<h5>cookie:${cookie}</h5>
<h5>Ip:${ip}</h5>

<p>
	<a href="<c:url value="home"/>">Home</a>
</p>
</body>
</html>
