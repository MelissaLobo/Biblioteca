package model;

import java.util.Calendar;
import java.util.List;

import persistencia.BibliotecaBancoDeDadosDAO;
import persistencia.BibliotecaDAO;

public class Biblioteca {
	BibliotecaDAO banco = new BibliotecaBancoDeDadosDAO();

	public List<Livro> listaDeLivros() {
		return banco.listaDeLivros();
	}

	public Livro buscarLivro(String nome) {
		return banco.buscarLivro(nome);
	}

	public void adicionaLivro(String nome, String autor, String editora,
			String genero, String status) {
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setGenero(genero);	
		livro.setStatus(model.Status.DISPONIVEL);

		banco.adicionaLivro(livro);

	}

	public Livro alugar(long id){


		Livro livro  = banco.buscarLivroPorId(id);
		
		if (livro.getStatus() != Status.DISPONIVEL) {
			throw new RuntimeException("Livro indisponivel para alugar no momento");
		}else{
			
			Calendar dataAtual = Calendar.getInstance();
			livro.setDataEmprestimo(dataAtual.getTime());
		    
		    dataAtual.add(Calendar.DAY_OF_MONTH, 20);
		    livro.setDataDevolucao(dataAtual.getTime());
	
			livro.setStatus(Status.ALUGADO);
			
			banco.atualizaDadosDoLivro(livro);
		}
		return livro;
	}

	public Livro devolverLivro(Long id) {
		Livro livro  = banco.buscarLivroPorId(id);

		if (livro.getStatus() != Status.ALUGADO) {
			throw new RuntimeException("Este livro já foi devolvido");
		}else{

			livro.setDataDevolucao(null);
			livro.setDataDevolucao(null);
			livro.setStatus(Status.DISPONIVEL);

			banco.atualizaDadosDoLivro(livro);
		}
		return livro;
	}
}


