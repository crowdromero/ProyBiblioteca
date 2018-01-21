package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConection {

	public MySqlConection() {
		
	}

	public static Connection getConection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/BD_BiBLIOTECA", "adminbiblios", "123456");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR al cargar el Driver");
			
		} 
		return con;
	}

}
