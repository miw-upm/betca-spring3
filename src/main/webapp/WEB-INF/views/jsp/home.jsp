<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring 4 MVC. Home</title>
</head>
<body>

	<H1>Página principal con vista: JSTL + JSP + Spring tags</H1>

	<h3>ViewResolver</h3>
	<p>
		<c:forEach items="${themes}" var="theme">
			<a href="<c:url value="create-theme?theme=${theme}"/>">${theme}</a>;
    </c:forEach>
	</p>

	<h3>Ejercicios:</h3>
	<p>
		<a href="<c:url value='/greeting'/>">- Empezar</a>
	</p>
	<p>
		<a href="<c:url value='/user-list'/>">- Lista de usuarios</a>
	</p>
	<p>
		<a href="<c:url value='/create-user'/>">- Crear un usuario</a>
	</p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>