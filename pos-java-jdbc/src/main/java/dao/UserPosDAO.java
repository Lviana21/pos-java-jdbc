package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

//## DAO - Obeto de acesso a dados
public class UserPosDAO {

	// Connection do SQL
	private Connection connection;

	// Construtur para enjetar SingleConnection
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	// Método Salvar recebe objeto Userposjava
	public List<Userposjava> salvar(Userposjava userposjava) {
		try {

			String sql = "insert into userposjava (id, nome, email) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);// é o que irá fazer o insert
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit();// salva no banco

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;

	}

	//Lista de Objetos-------------------------------------------------------------------
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {// enquanto for "true" tiver dados
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			list.add(userposjava);
		}

		return list;
	}

	//Consutar somente 1 Objeto----------------------------------------------------------------
	    //buscar() não retorna uma lista, apenas um objeto
		public Userposjava buscar(Long id) throws Exception {
			Userposjava retorno = new Userposjava();

			String sql = "select * from userposjava where id = " + id;

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {// retorna apenas um ou nenhun
				
				retorno.setId(resultado.getLong("id"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setEmail(resultado.getString("email"));

				
			}

			return retorno;
		}
	
}
