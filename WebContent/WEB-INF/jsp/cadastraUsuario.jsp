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
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /> <br />
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha"> <br />
			<button type="submit">CADASTRAR</button>
		</form>
		
		
		
		<table>
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Senha</th>
					<th>X</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.usuario}</td>
						<td>${usuario.senha}</td>
						<td>
							<a href="mvc?logica=alterarUsuario&&id=${usuario.id}">Alterar</a>
							<a href="mvc?logica=removerUsuario&&id=${usuario.id}">Remover</a>
						</td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
		
</body>
</html>