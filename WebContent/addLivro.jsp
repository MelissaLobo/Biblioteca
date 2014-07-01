<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Livro</title>
</head>
<body>
<h1>Adicionar livro:</h1>
	<form action="http://localhost:8080/biblioteca/addLivro" method="POST">
		Nome: <input type="text" name="nome"> 
		Autor: <input type="text" name="autor"> 
		Editora: <input type="text" name="editora"> 
		Genero: <input type="text" name="genero">
		Status: <input type="text" name="status">  
		
		<input type="submit" value="Salvar">
	</form>
	
</body>
</html>