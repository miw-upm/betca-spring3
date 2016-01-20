<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-8">
				<div class="table-responsive">
					<table class="table table-hover table-condensed">
						<thead>
							<tr>
								<th>#</th>
								<th>Id</th>
								<th>name</th>
								<th>age</th>
								<th>email</th>
								<th>password</th>
								<th>country</th>
								<th>languages</th>
								<th>description</th>
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
									<td>${user.country}</td>
									<td>${user.languages}</td>
									<td>${user.description}</td>
									<td><a href="<c:url value='/delete-user/${user.id}' />"><span
											class="label label-danger">Delete</span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>Acerca de las tablas</h4>
					<p>Para que los contenidos de la tabla sean todavía más fáciles
						de entender, añade la clase .table-hover para modificar
						ligeramente el aspecto de las filas cuando el usuario pasa el
						ratón por encima de ellas (sólo funciona para las filas dentro de
						&lt;tbody&gt;).</p>
					<p>Cuando una tabla es muy grande o cuando tienes muchas tablas
						en una misma página, puede ser interesante mostrar sus contenidos
						de forma más compacta. Añade la clase .table-condensed a tus
						tablas y el padding se reducirá a la mitad</p>
				</div>
			</div>
			<!-- /.blog-sidebar -->
		</div>
		<hr>
        <footer>
            <p>&nbsp;&nbsp;&copy; UPM-MIW --- ${now}</p>
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