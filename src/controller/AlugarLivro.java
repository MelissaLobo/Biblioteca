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
@WebServlet(urlPatterns = "/alugar")
public class AlugarLivro extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = (Long) null;
		
		try {
			
			Biblioteca biblioteca = new Biblioteca();
			Livro livro = biblioteca.alugar(id);
			req.setAttribute(" ",biblioteca.alugar(id));

		} catch (Exception e) {
			throw new RuntimeException("Livro indisponivel para alugar no momento", e);
		}
		
		vaiParaPagina(req, resp, ".jsp");
	}
}
