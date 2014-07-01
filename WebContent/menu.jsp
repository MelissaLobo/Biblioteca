<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca </title>
</head>
<body>
<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br/>
</c:if>

<br/>
<a href="http://localhost:8080/biblioteca/listaDeLivros">Lista de Livros</a><br/>
<a href="http://localhost:8080/biblioteca/buscarLivro.jsp">Buscar Livro</a><br/>
<a href="http://localhost:8080/biblioteca/alugar.jsp">Alugar Livro</a><br/>
<a href="http://localhost:8080/biblioteca/addLivro.jsp">Adicionar Livro</a><br/>
<br/>

<form action="http://localhost:8080/biblioteca/deslogar" method="POST">
		<input type="hidden" name="logout" value="Logout" /> 
		<input type="submit" value="Deslogar" />
	</form>
</body>
</html>