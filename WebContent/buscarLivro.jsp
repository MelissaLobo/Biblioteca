<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscar Livro</title>
</head>
<body>
${erro}
	<h1>Buscar livro:</h1>
	<form action="http://localhost:8080/biblioteca/buscarLivro" method="POST">
		Livro: <input type="text" name="nome"> <input type="submit"
			value="Buscar">
	</form>
	<a href="http://localhost:8080/biblioteca/menu.jsp">Inicio</a><br/>
</body>
</html>