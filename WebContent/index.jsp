<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	
		<form action="/appRevisaoJavaWeb/servletController" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login"/>
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha"/>
			<button type="submit">Logar</button>
		</form>
		
	</body>
</html>