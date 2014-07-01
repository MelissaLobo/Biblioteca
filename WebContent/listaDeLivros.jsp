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
	<h1><a href="http://localhost:8080/biblioteca/listaDeLivros">Lista de Livros </a><br/></h1>


	<ul>
			<c:forEach var="livro" items="${livros}">
			<li>${livro.id }: ${livro.nome}: ${livro.autor}
			: ${livro.editora }: ${livro.genero }: ${livro.status }
			: ${livro.dataEmprestimo }: ${livro.dataDevolucao }
			<a href="http://localhost:8080/biblioteca/alugar?idLivroParaAlugar=${livro.id}">alugar</a><br/>
			</li> 
			
		</c:forEach>
	</ul>
</c:if>
	
<a href="http://localhost:8080/biblioteca/menu.jsp">Inicio</a><br/>
</body>
</html>