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
@WebServlet(urlPatterns = "/addLivro")
public class AdicionandoLivro  extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		String editora = req.getParameter("editora");
 		String genero = req.getParameter("genero");
		String status = req.getParameter("status");

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adicionaLivro(nome, autor, editora, genero, status);

		req.setAttribute("Livros", biblioteca.listaDeLivros());
		vaiParaPagina(req, resp, "listaDeLivros.jsp");

	}
}
