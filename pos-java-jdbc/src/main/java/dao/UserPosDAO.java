package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public void salvar(Userposjava userposjava) {
		try {

			String sql = "insert into userposjava (id, nome, email) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);// é o que irá fazer o insert
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit();//salva no banco

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
