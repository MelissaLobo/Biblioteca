<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alugado com sucesso!</title>
</head>
<body>
	<h3>Livro alugado com sucesso!</h3>

	<ul>
		<li>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
				<tr>
					<td>Livro alugado:</td>
					<td>Data de Devolução:</td>
				</tr>
				<tr>
					<td>${nomeDoLivroAlugado }</td>
					<td>${dataDevolucao }</td>
				</tr>
			</table>
		</li>
	</ul>	
	
<h4><a href="http://localhost:8080/biblioteca/listaDeLivros">Lista de Livros </a><br/></h4>
<a href="http://localhost:8080/biblioteca/menu.jsp">Inicio</a><br/>		
		
</body>
</html>