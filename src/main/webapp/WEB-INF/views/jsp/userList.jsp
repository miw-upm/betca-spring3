<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Spring MVC. User List</title>
</head>

<body>
    <H1>Listado de usuarios</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Email</th>
				<th>Password</th>
				<th>NativeLanguage</th>
				<th>Languages</th>
				<th>Description</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.nativeLanguage}</td>
					<td>${user.languages}</td>
					<td>${user.description}</td>
					<td><a href="<c:url value='/delete-user/${user.id}' />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/create-user'/>">Create User</a></p>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>