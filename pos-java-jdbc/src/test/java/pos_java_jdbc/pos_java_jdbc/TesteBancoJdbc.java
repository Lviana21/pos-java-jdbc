package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	// Método de inserir dados "INSERT"
	@Test
	public void initBanco() throws SQLException {
		// SingleConnection.getConnection();
		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		// Teste dados dinâmicos
		userposjava.setNome("Lucas teste id");
		userposjava.setEmail("lucastesteid@gmail.com");

		userPosDao.salvar(userposjava);
	}

	// Método de consulta de todos os dados da tabela "SELECT"
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-----------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método de consulta por ID "SELECT WHERE"
	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(6L);
			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Método atualizar "UPDATE"
	@Test
	public void initAtualizar() {
		try {

			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Nome mudado com o método atualizar");
			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Método Deletar "DELETE"
	@Test
	public void initDeletar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(11L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
