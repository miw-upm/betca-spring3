<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. Greeting</title>
</head>

<body>
	<h1>Saludos. Ejercicios básicos</h1>

	<h3>Acceso a un atributo del Model</h3>
	<h5>Hello ${name}!!!</h5>

	<h3>Acceso a un atributo del Model condicional (if). Si no lo encuentra no se escribe nada</h3>
	<c:if test="${not empty name}">
		<h5>Hello ${name}!!!</h5>
	</c:if>

	<h3>Acceso a un atributo del Model con opciones (else-if)</h3>
	<c:choose>
		<c:when test="${empty name}">
			<p>No se encuentra el atributo</p>
		</c:when>
		<c:otherwise>
			<p>Atributo encontrado con el valor: ${name}</p>
		</c:otherwise>
	</c:choose>

	<h3>Lista de Strings</h3>
	<ul>
		<c:forEach var="var" items="${stringList}">
			<li>${var}</li>
		</c:forEach>
	</ul>

	<h3>Acceso por parte del controlador al contexto del Servlet</h3>
	<h5>cookie:${cookie}</h5>
	<h5>Ip:${ip}</h5>

	<p><a href="<c:url value="/home"/>">Home</a></p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>
