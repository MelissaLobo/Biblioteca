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
@WebServlet(urlPatterns = "/devolver")
public class DevolverLivro extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Long id =Long.parseLong(req.getParameter("idLivroParaDevolver"));
		
		try {

			Biblioteca biblioteca = new Biblioteca();
			Livro livroDevolvido = biblioteca.devolverLivro(id);

			req.setAttribute("nomeDoLivroDevolvido", livroDevolvido.getNome());
					
			vaiParaPagina(req, resp, "devolucaoLivro.jsp");

		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			vaiParaPagina(req, resp, "erro.jsp");
		}
	}
}
