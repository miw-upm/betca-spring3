<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Spring MVC</title>
</head>

<body>
	<table border="1">
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.country}</td>
                <td>${user.languages}</td>
                <td>${user.description}</td>
				<td><a href="<c:url value='/delete-user/${user.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="<c:url value="create-user"/>">Create User</a>
	</p>
	<p>
		<a href="<c:url value="home"/>">Home</a>
	</p>
</body>
</html>