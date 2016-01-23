<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateUser</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear un usuario</h1>
	<form:form action="create-user" modelAttribute="user">
		<p>Id:
			<form:input path="id" placeholder="Id" required="required" />
			<form:errors path="id" cssClass="error" />
		</p>
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />
			<form:errors path="name" cssClass="error" />
		</p>
		<p>Age:
			<form:input path="age" placeholder="Age" />
			<form:errors path="age" cssClass="error" />
		<p>Email:
			<form:input path="email" placeholder="Email" required="required" />
		</p>
		<p>Password:
			<form:password path="password" placeholder="Password" required="required" showPassword="true" />
		</p>
		<p>Idioma nativo:
			<form:select path="nativeLanguage" items="${languageMap}" />
		</p>
		<p>Idiomas:
			<form:checkboxes path="languages" items="${languageMap}" />
		</p>
		<p>Descriptción:
			<form:textarea placeholder="Description" path="description" rows="3" cols="20" />
		</p>
		<p><input type="submit" value="Crear"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>