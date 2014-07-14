package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Biblioteca;

@SuppressWarnings("serial")
@WebServlet("/listaDeLivros")
public class ListaDeLivros  extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Biblioteca biblioteca = new Biblioteca();

 		req.setAttribute("livros",biblioteca.listaDeLivros() );

 		vaiParaPagina(req, resp, "listaDeLivros.jsp");
	}
}