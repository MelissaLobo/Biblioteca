package model;

import java.util.Date;

public class Livro {

	private Long id;
	private String nome;
	private String autor;
	private String editora;
	private String genero;
	private Date dataEmprestimo;
	private Date dataDevolucao;
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
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
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