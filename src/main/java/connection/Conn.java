package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private static final String URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=review;"
			+ "encrypt=true;trustServerCertificate=true";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";

	public static Connection getConnection() {
		Connection connection;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connected!");
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
