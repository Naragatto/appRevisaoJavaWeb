<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGAR NA APLICAÇÃO</title>
	</head>
	<body>
		<%--
		<c:if test="${test}">
				<h2>Usuário ou Senha inválidos</h2>
		</c:if>
		 --%>
		
		<form action="/appRevisaoJavaWeb/mvc?Logica=LogarLogica" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /> <br />
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha"> <br />
			<button type="submit">LOGAR</button>
			<input type="hidden" name="opcao" value="LOGAR"/>
		</form>
		
		
		
	</body>
</html>