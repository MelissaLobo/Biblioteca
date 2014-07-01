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
		
		long id =Long.parseLong(req.getParameter("idLivroParaAlugar"));
		
		try {
			
			Biblioteca biblioteca = new Biblioteca();
			Livro livroAlugado = biblioteca.alugar(id);
			
			req.setAttribute("nomeDoLivroAlugado", livroAlugado.getNome());
			vaiParaPagina(req, resp, "sucesso.jsp");
			
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			vaiParaPagina(req, resp, "erro.jsp");
		}
		
	
	}
}
