<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Biblioteca</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Bem Vindo a Biblioteca Online Lobo Marinho</h2>
<br/>
	
<c:if test="${not empty erro}">
	${erro}<br/>
</c:if>
<h3>Login:</h3>
	<form action="http://localhost:8080/biblioteca/login" method="POST">
		<input type="text" name="email" /> 
		<input type="password" name="senha" /> 
		<input type="submit" value="efetuar login" />
	</form>
	
<a href="http://localhost:8080/biblioteca/cadastro.jsp">Cadastre-se</a>	
</body>
</html>