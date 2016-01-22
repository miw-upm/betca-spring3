<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="MIW. Spring 4 MVC">
<meta name="author" content="J.Bernal">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet">
<link href="<c:url value='/static/css/jumbotron.css' />"
	rel="stylesheet">
<link href="<c:url value='/static/css/blog.css' />" rel="stylesheet">
<link href="<c:url value='/static/css/signin.css' />" rel="stylesheet">
<title>Spring 4 MVC. CreateUser</title>
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

	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<form:form action="create-user" modelAttribute="user"
					class="form-horizontal form-signin">
					<h2 class="form-signin-heading">Create User</h2>
					<label for="id" class="control-label">Id</label>
					<input name="id" type="number" placeholder="Id"
						class="form-control" required autofocus value="${user.id}" />
					<form:errors path="id" class="control-label" />
					<label for="name" class="control-label">Name</label>
					<input name="name" type="text" maxlength="30" class="form-control"
						placeholder="Name" required value="${user.name}" />
					<form:errors path="name" class="control-label" />
					<label for="age" class="control-label">Age</label>
					<input name="age" type="number" min="18" class="form-control"
						placeholder="Age" required value="${user.age}" />
					<label for="email" class="control-label">Email</label>
					<input name="email" type="email" class="form-control"
						placeholder="Email" required value="${user.email}">
					<label for="password" class="control-label">Password</label>
					<input name="password" type="password" class="form-control"
						placeholder="Password" value="${user.password}">
					<label class="control-label">NativeLanguage</label>
					<span class="form-control"> <form:select
							path="nativeLanguage" items="${languageMap}" /></span>
					<label class="control-label">Languages </label>
					<span class="form-control"><form:checkboxes
							path="languages" items="${languageMap}" class="checkbox-inline" /></span>
					<label for="description" class="form-label">Description</label>
					<textarea name="description" class="form-control" rows="3">${user.description}</textarea>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form:form>
			</div>
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>Acerca de los formularios</h4>
					<p>Bootstrap 3 define estilos adecuados para todos y cada uno
						de los campos de formulario existentes. Los campos de tipo
						&lt;input&gt; son los más numerosos, ya que con HTML5 la lista se
						ha ampliado a text, password, datetime, datetime-local, date,
						month, time, week, number, email, url, search, tel, y color.</p>
				</div>
			</div>
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