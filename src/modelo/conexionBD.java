/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 
 * @author daniel
 */
public class conexionBD {
    public static String url ="jdbc:mysql://localhost:3306/colegio_inmaculada?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "";
    public static String  clase = "com.mysql.cj.jdbc.Driver";
     
    public static Connection getConection(){
        Connection con = null;
        
        try{
        Class.forName(clase); //controlador para solicitar la conexion
       con = DriverManager.getConnection(url,user,password); //se realiza la conexion a las variables para acceder a las bases de datos
       
        } catch(Exception e){
            System.out.println(e);   
        
        }
        return con;
     
} //getConection
}
