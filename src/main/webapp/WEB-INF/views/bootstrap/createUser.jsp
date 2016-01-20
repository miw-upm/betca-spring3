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

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-8">
				<form:form action="create-user" method="post" class="form-signin"
					modelAttribute="user">
					<h2 class="form-signin-heading">Create User</h2>
					<input name="id" type="number" class="form-control"
						placeholder="Id" required autofocus value="${user.id}" />
                    <form:errors class="control-label" path="id" />
					<input name="name" type="text" maxlength="30" class="form-control"
						placeholder="Name" required value="${user.name}" />
					<form:errors class="control-label" path="name" />
					<input name="age" type="number" min="18" class="form-control"
						placeholder="Age" required value="${user.age}" />
					<input name="email" type="email" class="form-control"
						placeholder="Email"  required value="${user.email}">
					<input name="password" type="password" class="form-control"
						placeholder="Password" value="${user.password}">
					<label class="control-label">Elige tu pais:</label>
					<br>
					<c:forEach items="${languages}" var="op">
						<label class="radio-inline"><input type="radio"
							name="country" value="${op}">${op}</label>
					</c:forEach>
					<label class="control-label">Elige tus idiomas:</label>
					<br>
					<c:forEach items="${languages}" var="op">
						<label class="checkbox-inline"><input type="checkbox"
							name="languages" value="${op}">${op}</label>
					</c:forEach>
					<textarea name="description" class="form-control" rows="3">${user.description}</textarea>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form:form>
			</div>
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>Acerca de los formularios</h4>
					<p>
						Bootstrap 3 define estilos adecuados para todos y cada uno de los
						campos de formulario existentes. Los campos de tipo
						&lt;input&gt; son los más numerosos, ya que con HTML5 la lista
						se ha ampliado a text, password, datetime, datetime-local, date,
						month, time, week, number, email, url, search, tel, y color.
					</p>
				</div>
			</div>
			<!-- /.blog-sidebar -->
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