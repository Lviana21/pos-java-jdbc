package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";//url de conexão do banco de dados
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	//Contrutor irá chamar o método conectar
	public SingleConnection() {
		conectar();
	}
	
	//Método conectar
	private static void conectar() {
		try {//Dentro do try escrever a parte de conexão
			
			if(connection == null) {
				//Fazer o carregamento do driver que irá utilizar
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);//Utilizado para não salvar automáticamente
				System.out.println("Conectado com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Método publico que irá retornar a conexão
	public static Connection getConnection() {
		return connection;
	}
}
