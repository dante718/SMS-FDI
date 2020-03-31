package GestionDeProyectos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GDP_Conexion {
	//Conexion a la base de datos que estuve probando
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/mibd";
    private static final String ROOT="root";
    private static final String PASSWORD="Oscar@09";
	public static Connection getConexion() {
		Connection conexion=null;
		try {
			Class.forName(Driver);
			conexion = DriverManager.getConnection(URL, ROOT,PASSWORD);		
		} catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		}
        return conexion;
	}

}
