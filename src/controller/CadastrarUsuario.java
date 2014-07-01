package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GerenciadorDeUsuarios;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/cadastro")
public class CadastrarUsuario extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		GerenciadorDeUsuarios gerenciador = new GerenciadorDeUsuarios();
		gerenciador.cadastrarUsuario(nome, email, senha);
		
		vaiParaPagina(req, resp, "/login.jsp");
		
		}

}
