package persistencia;

import static util.Ferramentas.getConection;
import static util.Ferramentas.releaseDatabaseResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.Status;

public class BibliotecaBancoDeDadosDAO implements BibliotecaDAO {

	@Override
	public List<Livro> listaDeLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM biblioteca ORDER BY nome ASC";
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Livro book = new Livro();
				book.setId(resultSet.getLong("id"));
				book.setNome(resultSet.getString("nome"));
				book.setAutor(resultSet.getString("autor"));
				book.setEditora(resultSet.getString("editora"));
				book.setGenero(resultSet.getString("genero"));
				book.setStatus(Status.valueOf(resultSet.getString("status")
						.toUpperCase()));
				book.setDataEmprestimo(resultSet.getTimestamp("emprestimo"));
				book.setDataDevolucao(resultSet.getTimestamp("devolucao"));
				livros.add(book);
			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar todos os livros", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return livros;
	}

	@Override
	public Livro buscarLivro(String nome) {
		Livro book = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM biblioteca WHERE nome = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				book = new Livro();
				book.setId(resultSet.getLong("id"));
				book.setNome(resultSet.getString("nome"));
				book.setAutor(resultSet.getString("autor"));
				book.setEditora(resultSet.getString("editora"));
				book.setGenero(resultSet.getString("genero"));
				book.setStatus(Status.valueOf(resultSet.getString("status")
						.toUpperCase()));
				book.setDataEmprestimo(resultSet.getTimestamp("emprestimo"));
				book.setDataDevolucao(resultSet.getTimestamp("devolucao"));

			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Livro não encontrado", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return book;

	}

	@Override
	public Livro buscarLivroPorId(Long id) {
		Livro book = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM biblioteca WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				book = new Livro();
				book.setId(resultSet.getLong("id"));
				book.setNome(resultSet.getString("nome"));
				book.setAutor(resultSet.getString("autor"));
				book.setEditora(resultSet.getString("editora"));
				book.setGenero(resultSet.getString("genero"));
				book.setStatus(Status.valueOf(resultSet.getString("status")
						.toUpperCase()));
				book.setDataEmprestimo(resultSet.getTimestamp("emprestimo"));
				book.setDataDevolucao(resultSet.getTimestamp("devolucao"));

			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Livro não encontrado", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return book;

	}

	@Override
	public Livro adicionaLivro(Livro livro) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = getConection();
			String sql = "INSERT INTO biblioteca (nome, autor, editora, genero, status) VALUES (?, ?, ?, ?, ?)";

			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, livro.getNome());
			statement.setString(2, livro.getAutor());
			statement.setString(3, livro.getEditora());
			statement.setString(4, livro.getGenero());
			statement.setString(5, Status.DISPONIVEL.toString());
			statement.executeUpdate();

			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			livro.setId(key);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir livro", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return livro;
	}

	@Override
	public void atualizaDadosDoLivro(Livro livro) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "UPDATE biblioteca SET status=?,emprestimo=?,devolucao=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, livro.getStatus().toString());

			if (livro.getDataEmprestimo() != null) {
				statement.setDate(2, new Date(livro.getDataEmprestimo()
						.getTime()));
			} else {
				statement.setDate(2, null);
			}
			if (livro.getDataDevolucao() != null) {
				statement.setDate(3, new Date(livro.getDataDevolucao()
						.getTime()));
			} else {
				statement.setDate(3, null);
			}
			statement.setLong(4, livro.getId());
			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
