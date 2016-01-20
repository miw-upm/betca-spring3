<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Form</h1>
	<form:form action="create-user" method="post" modelAttribute="user">
		<p>
			Id:
			<form:input path="id" />
			<form:errors path="id" cssClass="error" />
		</p>
		<p>
			Name:
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
		</p>
		<p>
			Age:
			<form:input path="age" />
			<form:errors path="age" cssClass="error" />
		<p>
			Email:
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />
		</p>
		<p>
			Password:
			<form:password path="password" />
		</p>
		<p>
			Country:
			<form:radiobuttons path="country" items="${languages}" />
		</p>
		<p>
			Languages:
			<form:select path="languages" items="${languages}" />
		</p>
		<p>
			Description:
			<form:textarea path="description" rows="3" cols="20" />
		</p>
		<p>
			<input type="submit" value="Execute">
		</p>
	</form:form>
	<a href="<c:url value="home"/>">Home</a>
</body>
</html>