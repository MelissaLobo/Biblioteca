package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Biblioteca;

@SuppressWarnings("serial")
@WebServlet("/listaDeLivros")
public class ListaDeLivros  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Biblioteca biblioteca = new Biblioteca();

 		request.setAttribute("livros",biblioteca.listaDeLivros() );

		RequestDispatcher rd = request.getRequestDispatcher("listaDeLivros.jsp");
		rd.forward(request, response);
	}
}