package modelo;

import controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    ConexionBD conexion =new ConexionBD(); // Instancia de la conección a la base de datos
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    
     public List listar(){
         String sql="select * from usuario";
         List<Usuario> lista = new ArrayList<>();
         try{       
             con = conexion.ConectarBaseDeDatos();
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             while(rs.next()){
              Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(3));
                usuario.setApellido(rs.getString(4));
                usuario.setIdentificacion(rs.getDouble(2));
                usuario.setUser(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                lista.add(usuario);

//                 *******  Validacion
//                 System.out.println(
//                         usuario.getId() + " " +
//                                 usuario.getNombre().toString() + " " +
//                                 usuario.getApellido() + " " +
//                                 usuario.getIdentificacion() + " " +
//                                 usuario.getUser() + " " +
//                                 usuario.getPassword()
//                 );

             }         
         }catch(SQLException e){
             System.out.println("Error al Listar: " + e);
         }
    return lista;
    }  //Fin del metodo Listar
    
    //Metodo para agregar
     public void agregar(Usuario usuario){
         String sql = "INSERT INTO usuario (nombre, apellido, identificacion, user, password) VALUES  (?,?,?, ?, ?)";
         try {
             con = conexion.ConectarBaseDeDatos();
             ps = con.prepareStatement(sql);
             ps.setString(1, usuario.getNombre());
             ps.setString(2, usuario.getApellido());
             ps.setDouble(3, usuario.getIdentificacion());
             ps.setString(4, usuario.getUser());
             ps.setString(5, usuario.getPassword());
             ps.executeUpdate();
         } catch (Exception e) {
             System.out.println("Error en el método Agregar");         
         }         
     }//Fin metodo Agregar
     
}//Fin de la clase ProductoDAO
