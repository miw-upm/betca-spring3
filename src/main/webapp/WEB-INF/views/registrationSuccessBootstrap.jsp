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

<!-- Custom styles for this template -->
<link href="<c:url value='/static/css/blog.css' />" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/static/css/signin.css' />" rel="stylesheet">


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
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h3>El usuario (${user.name}) ha sido creado satisfactoriamente</h3>
			<p>
				<a href="<c:url value='/user-list' />">Ir a Lista de Usuario</a>
			</p>
			<footer>
				<p>&copy; UPM MIW ETSISI</p>
			</footer>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/static/js/bootstrap.js' />"></script>
</body>
</html>