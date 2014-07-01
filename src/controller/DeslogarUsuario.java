package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static util.Ferramentas.vaiParaPagina;

@SuppressWarnings("serial")
@WebServlet("/deslogar")
public class DeslogarUsuario extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().setAttribute("usuarioLogado", null);
		vaiParaPagina(request, response, "login.jsp");
		
	}

}
