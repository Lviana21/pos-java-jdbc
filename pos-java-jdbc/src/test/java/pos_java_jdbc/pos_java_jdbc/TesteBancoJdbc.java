package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() throws SQLException {
		//SingleConnection.getConnection();
		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		//Teste dados dinâmicos
		userposjava.setId(10L);
		userposjava.setNome("Laura teste DAO");
		userposjava.setEmail("lauratestedao@gmail.com");
		
		userPosDao.salvar(userposjava);
	}
}
