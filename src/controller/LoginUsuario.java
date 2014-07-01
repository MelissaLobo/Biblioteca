package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.GerenciadorDeUsuarios;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginUsuario extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		GerenciadorDeUsuarios gerenciador = new GerenciadorDeUsuarios();
			
		Usuario usuarioLogado = gerenciador.tentaLogar(email, senha);
		
		if(usuarioLogado!=null){
			request.getSession().setAttribute("usuarioLogado", usuarioLogado);
			vaiParaPagina(request, response, "menu.jsp");
		}else{
			request.setAttribute("erro", "usuario ou senha invalida");
			vaiParaPagina(request, response, "/login.jsp");
		}
			
	}

}
