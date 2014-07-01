package model;

import persistencia.UsuarioBancoDeDadosDAO;
import persistencia.UsuarioDAO;

public class GerenciadorDeUsuarios {

	UsuarioDAO banco = new UsuarioBancoDeDadosDAO();

	public void cadastrarUsuario(String nome, String email, String senha) {

		Usuario usuario = new Usuario(nome, email, senha);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		banco.salvaUsuario(usuario);
	}

	public Usuario tentaLogar(String email, String senha) {
		return banco.buscaPorLoginESenha(email, senha);
	}
}
