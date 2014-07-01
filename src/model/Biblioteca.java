package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.sql.Timestamp;

import com.sun.org.apache.xerces.internal.util.Status;

import controller.LivroStatus;
import persistencia.BibliotecaBancoDeDadosDAO;
import persistencia.BibliotecaDAO;
import model.Livro;


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

		Livro livro = new Livro();
		livro.setId(id);
		banco.alugandoLivro(livro, id);
		
		if (livro.getStatus() != model.Status.DISPONIVEL) {
			throw new RuntimeException("Livro indisponivel para alugar no momento");
		}else{
			Calendar emprestimo = Calendar.getInstance();
		    livro.setEmprestimo((Timestamp) emprestimo.getTime());
		    Calendar devolucao = Calendar.getInstance();
		    devolucao.add(Calendar.DAY_OF_MONTH, 20);
		    livro.setDevolucao((Timestamp) devolucao.getTime());
			    
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(emprestimo.getTime()); 
			
			livro.setStatus(model.Status.ALUGADO);
			
		}
		return livro;
	}
}

