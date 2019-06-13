/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.conexionBD;

/**
 *
 * @author daniel
 */
public class Metodos_sql {
    public conexionBD conexion = new conexionBD();
    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
    public static String buscar(String correo){
    
        String busqueda_nombre = null;
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT user_direccion from TB_USUARIO WHERE user_username=' " + correo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String username = resultado.getString("user_direccion");
                
                busqueda_nombre = username + "";
            }
            conexion.close();
        }catch(Exception e){
             System.out.println(e);
        }
       
        
        return busqueda_nombre;
    
    }
    public static String buscarUsuarioRegistrado(String username, int password){
    String busqueda_usuario = null;
    Connection conexion = null;
    try{
        conexion = conexionBD.getConection();
        String sentencia_buscar_usuario = ("SELECT user_direccion,user_username,user_password from TB_USUARIO where user_username = '" + username + "' and user_password ='" + password + "'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
         resultado = sentencia_preparada.executeQuery();
         if (resultado.next()) {
            busqueda_usuario = "usuario encontrado";
        } else{
         
          busqueda_usuario = "usuario no encontrado";
         }
           conexion.close();
         
    }catch(Exception e){
        System.out.println(e);
    }
    return busqueda_usuario;
    }
    
}
