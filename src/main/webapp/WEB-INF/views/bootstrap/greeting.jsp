<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Spring 4 MVC. Greeting</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet">
<link href="<c:url value='/static/css/jumbotron.css' />"
	rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/home'/>">Spring MVC</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1>Mi primer Spring MVC!!!</h1>
			<p>Acceso a un atributo llamado "name" del Model mediante:
				&#36;{name}</p>
			<h5>Hello ${name}!!!</h5>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Acceso a un atributo del Model condicional (if)</h2>
				<p>En este caso, si el atributo no existe o está vacío, no se
					presenta nada: &lt;c:if test="&#36;{not empty
					name}"&gt;...&lt;/c:if&gt;</p>
				<c:if test="${not empty name}">
					<h5>Hello ${name}!!!</h5>
				</c:if>
			</div>
			<div class="col-md-4">
				<h2>Acceso a un atributo del Model con opciones (else-if)</h2>
				<p>En este caso, si el atributo no existe o está vacío, se
					presenta una alternativa: &lt;c:choose>&lt;c:when test="&#36;{empty
					name}">...&lt;c:otherwise>...</p>
				<c:choose>
					<c:when test="${empty name}">
						<h5>No se encuentra el atributo</h5>
					</c:when>
					<c:otherwise>
						<h5>Atributo encontrado con el valor: ${name}</h5>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-4">
				<h2>Lista de String</h2>
				<p>En este caso, el controlador sitúa en el Model un
					List&lt;String&gt; y lo presenta a partir de JSTL mediante la
					etiqueta c:forEach...</p>
				<ul>
					<c:forEach var="var" items="${stringList}">
						<li>...${var}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h2>Acceso a cookies</h2>
				<p>El framework puede injectar cookies al controlador mediante
					anotaciones:@CookieValue, y este guarda en el Model el valor de la
					cookie.</p>
				<p>cookie: ${cookie}</p>
			</div>
			<div class="col-md-4">
				<h2>HttpServletRequest</h2>
				<p>Si el controlador define un parámetro de tipo:
					HttpServletRequest, el framework lo injecta, y así, el controlador
					tiene acceso a todos los parámetros de la petición, por ejemplo a
					la IP del cliente. http.</p>
				<p>Ip: ${ip}</p>
			</div>
			<div class="col-md-4"></div>
		</div>
		<hr>
		<footer>
			<p>&nbsp;&nbsp;&copy; UPM-MIW --- ${now}</p>
		</footer>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/static/js/bootstrap.js' />"></script>
</body>
</html>