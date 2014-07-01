<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de livros</title>
</head>
<body>

	<c:if test="${not empty livros}">
	<h2><a href="http://localhost:8080/biblioteca/listaDeLivros">Lista de Livros </a><br/></h2>
<table border=1 cellspacing=0 cellpadding=2 bordercolor="000">
<tr><td>
	<ul>
			<c:forEach var="livro" items="${livros}">
			<br/>
			<li>${livro.nome}, Autor ${livro.autor}
			, Editora ${livro.editora }, Genero: ${livro.genero }, Status: ${livro.status }
			, Emprestado em: ${livro.dataEmprestimo }, Data de devolução: ${livro.dataDevolucao }
			<br/>
			<a href="http://localhost:8080/biblioteca/alugar?idLivroParaAlugar=${livro.id}">Alugar</a>
			
			<a href="http://localhost:8080/biblioteca/devolver?idLivroParaDevolver=${livro.id}">Devolver</a><br/>
			
			</li> 
			
		</c:forEach>
	</ul>
</td></tr>
</table>
</c:if>
<br/>	
<a href="http://localhost:8080/biblioteca/menu.jsp">Inicio</a><br/>
</body>
</html>