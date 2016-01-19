<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registration Confirmation Page</title>
</head>
<body>
	<h3>El usuario (${user.name}) ha sido creado satisfactoriamente</h3>
	<p>
		<a href="<c:url value='/user-list' />">Ir a Lista de Usuario</a>
</body>
</html>