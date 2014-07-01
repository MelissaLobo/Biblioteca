package model;

import java.sql.Timestamp;

public class Livro {

	private Long id;
	private String nome;
	private String autor;
	private String editora;
	private String genero;
	private Timestamp emprestimo;
	private Timestamp devolucao;
	private Status status;
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Timestamp getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Timestamp emprestimo) {
		this.emprestimo = emprestimo;
	}
	public Timestamp getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Timestamp devolucao) {
		this.devolucao = devolucao;
	}
	public boolean equals(Object obj) {
		Livro outroLivro=(Livro)obj;
		return this.id.equals(outroLivro.id);
	}
	public String toString() {
		return "  \n nome:"+ nome + " \n autor:"+ autor 
				+ " \n editora:"+ editora;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	 
}