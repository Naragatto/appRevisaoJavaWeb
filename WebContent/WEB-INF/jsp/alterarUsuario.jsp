<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>
</head>
<body>
	<h1>Cadastrar Usuario</h1>
	
		<form action="/appRevisaoJavaWeb/mvc?logica=CadastrarLogica" method="post">
			<input type="hidden" name="id" value="${usuario.id}"/>
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" value="${usuario.login}"/> <br />
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha" value="${usuario.senha}"> <br />
			<button type="submit">Alterar</button>
		</form>
		
</body>
</html>