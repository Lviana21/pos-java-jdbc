package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

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
	
	//método
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
}
