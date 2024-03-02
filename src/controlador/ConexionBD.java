package controlador;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    Connection con;
    String bd = "db_saludcontigo";
    //String url = "jdbc:mysql://localhost:3306/";
    String url = "jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&use" + 
            "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" 
            + "serverTimezone=UTC";
    String username = "root";
    String password = "123456789";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection ConectarBaseDeDatos() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo Conectar a la base de datos " + bd);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return con;

    }

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.ConectarBaseDeDatos();
    }    
}

