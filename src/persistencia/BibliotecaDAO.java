package persistencia;

import java.util.List;

import model.Livro;

public interface BibliotecaDAO {

	List<Livro> listaDeLivros();
    Livro buscarLivro(String nome);
 	Livro adicionaLivro(Livro livro);
 	Livro devolveldoLivro(Livro livro);
	Livro buscarLivroPorId(Long id);
	void atualizaDadosDoLivro(Livro livro);
	void atualizaDevolucaoDoLivro(Livro livro);
}
