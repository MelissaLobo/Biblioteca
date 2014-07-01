package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Biblioteca;
import model.Livro;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/buscarLivro")
public class BuscarLivro extends HttpServlet{


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
    		Biblioteca biblioteca = new Biblioteca();
  		Livro livro = biblioteca.buscarLivro(nome);
				
		req.setAttribute("livroBuscado", livro);
		
		vaiParaPagina(req, resp, "busca.jsp");
	}
}
