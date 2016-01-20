<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Jumbotron Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet">

<!-- Custom styles for this template -->
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
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='home'/>">Spring MVC
					4</a>
			</div>
			<c:if test="${name==null}">
				<div id="navbar" class="navbar-collapse collapse">
					<form:form action="login" class="navbar-form navbar-right"
						method="post" modelAttribute="loginUser">
						<div class="form-group">
							<input name="id" type="number" placeholder="Id"
								class="form-control" required>
							<form:errors class="control-label" path="id" />
						</div>
						<div class="form-group">
							<input name="password" type="password" placeholder="Password"
								class="form-control">
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
					</form:form>
				</div>
			</c:if>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Mi primer Spring MVC!!!</h1>
			<p>Accede al controlador, este sitúa en el Model un String con la
				clave "name" y la vista lo presenta mediante &#36;{name}</p>
			<h3>Hello ${name}!!!</h3>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
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
				<h4>Ip: ${ip}</h4>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; UPM MIW ETSISI</p>
		</footer>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/static/js/bootstrap.js' />"></script>
</body>
</html>