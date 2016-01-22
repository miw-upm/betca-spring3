<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Spring MVC</title>
</head>

<body>
	<H1>Creación de usuario correcto</H1>

	<h3>El usuario (${user}) ha sido creado satisfactoriamente</h3>

	<p>
		<a href="<c:url value='/user-list' />">Ir a Lista de Usuario</a>
	</p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>