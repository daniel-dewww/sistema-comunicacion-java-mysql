/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Alumno;
import controlador.Cursos;
import controlador.Grado;
import controlador.Profesor;
import controlador.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import static modelo.Metodos_sql.resultado;
import static modelo.Metodos_sql.sentencia_preparada;

/**
 *
 * @author daniel
 */
public class Metodos_Admin {
    public conexionBD conexion = new conexionBD();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    private ArrayList<Cursos> listaCurso = new  ArrayList<Cursos>();
    private ArrayList<Profesor> listaProfesor = new  ArrayList<Profesor>();
    private ArrayList<Alumno> listaAlumno = new  ArrayList<Alumno>();

    public Metodos_Admin() {
    }
    /*=====BUSCAR CORREO DE ADMIN===*/
    public static String buscarNombre(String correo){
    
       String busqueda_nombre = "";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT loginAdmin  from tbl_administrador where loginAdmin='" + correo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String username = resultado.getString("loginAdmin");
                
                busqueda_nombre = username + "";
            }
            conexion.close();
        }catch(Exception e){
             System.out.println(e);
        }
       
        
        return busqueda_nombre;
    
    }
    
    /*==========BUSCAR ADMIN REGISTRADO EN LA BBDD===============*/    
    public static String buscarAdminRegistrado(String username, String password){
    String busqueda_usuario = null;
    Connection conexion = null;
    try{
        conexion = conexionBD.getConection();
        String sentencia_buscar_usuario = ("SELECT loginAdmin,passAdmin from tbl_administrador where loginAdmin = '" + username + "' and passAdmin ='" + password + "'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
         resultado = sentencia_preparada.executeQuery();
         if (resultado.next()) {
            busqueda_usuario = "usuario encontrado";
        } else{
         
          busqueda_usuario = "usuario no encontrado";
         }
           conexion.close();
      
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e );
    }
    return busqueda_usuario;
    }
     
    /*==========GUARDAR PROFESOR===============*/     
    public int guardarProfesor(String id, String nombre,String username, String password, String direccion , String email, String telefono, String fecha, String genero){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_usuario (user_id, user_nombre, user_username, user_password, user_direccion,user_email,user_telefono,user_fechaNacimiento, user_genero) VALUES (?,?,?,?,?,?,?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,id); 
           sentencia_preparada.setString(2,nombre); 
           sentencia_preparada.setString(3,username); 
           sentencia_preparada.setString(4,password); 
           sentencia_preparada.setString(5,direccion); 
           sentencia_preparada.setString(6,email); 
           sentencia_preparada.setString(7,telefono);          
           
           sentencia_preparada.setString(8,fecha);
           sentencia_preparada.setString(9,genero); 
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }
     
    /*==========GUARDAR ALUMNO===============*/   
    public int guardarAlumno(String carnet, String nombre,String direccion, String genero, String fecha ){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_usuario (user_id, user_nombre, user_direccion, user_genero, user_fechaNacimiento) VALUES (?,?,?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,carnet); 
           sentencia_preparada.setString(2,nombre); 
           sentencia_preparada.setString(3,direccion); 
           sentencia_preparada.setString(4,genero); 
           sentencia_preparada.setString(5,fecha); 
           
           
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }
    
     /*==========GUARDAR PADRE===============*/   
     public int guardarPadre(String id, String nombre,String username, String password, String direccion , String email, String telefono, String fecha, String genero){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_usuario (user_id, user_nombre, user_username, user_password, user_direccion,user_email,user_telefono,user_fechaNacimiento, user_genero) VALUES (?,?,?,?,?,?,?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,id); 
           sentencia_preparada.setString(2,nombre); 
           sentencia_preparada.setString(3,username); 
           sentencia_preparada.setString(4,password); 
           sentencia_preparada.setString(5,direccion); 
           sentencia_preparada.setString(6,email); 
           sentencia_preparada.setString(7,telefono);          
           
           sentencia_preparada.setString(8,fecha);
           sentencia_preparada.setString(9,genero); 
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }
    /*==========GUARDAR CURSO===============*/  
    public int guardarCurso( String nombre,String idProfesor){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_curso (curso_nombre, prof_id) VALUES (?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
          
           sentencia_preparada.setString(1,nombre); 
           sentencia_preparada.setString(2,idProfesor); 
           
           
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }
     /*==========GUARDAR DATOS DE PROFESOR EN ALUMNO==============*/   
    public int guardarAlumnoProfesor(String carnet, String nombre, String profesor){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_alumno (alumno_carnet,user_id,prof_id) VALUES (?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,carnet);
           sentencia_preparada.setString(2,nombre); 
           sentencia_preparada.setString(3,profesor); 
           
           
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }
   
     /*==========GUARDAR DATOS DE ALUMNO EN PADRE==============*/   
public int guardarAlumnoPadre(String id, String user_id, String alumno_Carnet){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_padre (pdr_id,user_id,alumno_carnet) VALUES (?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,id);
           sentencia_preparada.setString(2,user_id); 
           sentencia_preparada.setString(3,alumno_Carnet); 
           
           
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   }

       /*==========LLENAR CURSO===============*/
    public Vector<Cursos> llenarCursos(){
       
       Connection con = null;
       Vector<Cursos> datos = new Vector<Cursos>();
       Cursos dat = null;
       try {
           con = conexionBD.getConection();
           String sentencia_llenar_curso = ("select * from tb_curso");
           sentencia_preparada = con.prepareStatement(sentencia_llenar_curso);
           resultado = sentencia_preparada.executeQuery();
            dat = new Cursos();
               
               dat.setNombre("Selecciona un curso");
               datos.add(dat);
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Cursos();
               
               dat.setNombre(resultado.getString("curso_nombre"));
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }
     /*==========GUARDAR GRADO===============*/
     public int guardarGrado( String id,int grado,String idUsuario){
       int resultado =0;
       Connection con = null;
        try {
           con = conexionBD.getConection();
  String consulta_guardar = ("INSERT INTO tb_profesor (prof_id, grado_id,user_id) VALUES (?,?,?)");
           sentencia_preparada = con.prepareStatement(consulta_guardar);
          
           sentencia_preparada.setString(1,id); 
           sentencia_preparada.setInt(2,grado); 
            sentencia_preparada.setString(3,idUsuario); 
           
           
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        return resultado;
   } 
    /*==========LLENAR GRADO===============*/
    public Vector<Grado> llenarGrados(){
       
       Connection con = null;
       Vector<Grado> datos = new Vector<Grado>();
       Grado dat = null;
       try {
           con = conexionBD.getConection();
           String sentencia_llenar_curso = ("select * from tb_grado");
           sentencia_preparada = con.prepareStatement(sentencia_llenar_curso);
           resultado = sentencia_preparada.executeQuery();
            dat = new Grado();
               dat.setCodigoGrado(0);
               dat.setNombreGrado("Selecciona un grados");
               datos.add(dat);
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Grado();
               dat.setCodigoGrado(resultado.getInt("grado_id"));
               dat.setNombreGrado(resultado.getString("grado_nombre"));
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }
    /*==========LLENAR PROFESOR===============*/
    public Vector<Profesor> llenarProfesor(){     
       Connection con = null;
       Vector<Profesor> datos = new Vector<Profesor>();
       Profesor dat = null;
       try {
           con = conexionBD.getConection();
           String sentencia_llenar_profesor = ("select  prof_id, user_nombre from tb_usuario inner join tb_profesor on tb_usuario.user_id = tb_profesor.user_id");
           sentencia_preparada = con.prepareStatement(sentencia_llenar_profesor);
           resultado = sentencia_preparada.executeQuery();
            dat = new Profesor();
               dat.setCodigo("0");
               dat.setNombre("Selecciona a un profesor");
               datos.add(dat);
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Profesor();
               dat.setCodigo(resultado.getString("prof_id"));
               dat.setNombre(resultado.getString("user_nombre"));
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }
     /*==========LLENAR ALUMNO===============*/
     public Vector<Alumno> llenarAlumno(){
       
       Connection con = null;
       Vector<Alumno> datos = new Vector<Alumno>();
       Alumno dat = null;
       try {
           con = conexionBD.getConection();
           String sentencia_llenar_curso = ("select alumno_carnet, user_nombre from tb_usuario inner join tb_alumno on tb_usuario.user_id = tb_alumno.user_id" );
           sentencia_preparada = con.prepareStatement(sentencia_llenar_curso);
           resultado = sentencia_preparada.executeQuery();
            dat = new Alumno();
                dat.setIdAlumno("0");
               dat.setNombreAlumno("Selecciona un alumno");
               datos.add(dat);
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Alumno();
               dat.setIdAlumno(resultado.getString("alumno_carnet"));
               dat.setNombreAlumno(resultado.getString("user_nombre"));
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }   
    /*==========BUSCAR ID PROFESOR===============*/
    public static String buscarIdProfesor(String nombre){
    
       String busqueda_nombre = "";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("select prof_id, user_nombre from TB_USUARIO inner join TB_PROFESOR on TB_USUARIO.user_id = tb_profesor.user_id where user_nombre ='" + nombre + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String user_id = resultado.getString("prof_id");     
                busqueda_nombre = user_id;
            }
            conexion.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
        
        return busqueda_nombre;
    
    }
    
    
    
    /*============================ARRAYLIST===================================*/
    /*==========ADICIONAR ALUMNO===============*/
     public void adicionarAlumno(Alumno a){
         listaAlumno.add(a);
     }
     /*==========OBTENER CURSO===============*/
     public Alumno obtenerAlumno(int posicion){
        return listaAlumno.get(posicion);
    }
     /*==========OBTENER ALUMNO===============*/
      public int totalAlumno(){   
        return listaAlumno.size();
    }
      
     /*==========ADICIONAR CURSO===============*/
     public void adicionarCurso(Cursos c){
         listaCurso.add(c);
     }
     
     /*==========OBTENER CURSO===============*/
     public Cursos obtenerCurso(int posicion){
        return listaCurso.get(posicion);
    }
     /*==========SIZE CURSO===============*/
     public int totalCurso(){
        //ESTO SERA REFLEJADO EN EL GUI MEDIANTE UN TEXTAREA, AHÍ SE VERA TODOS LOS PRODUCTOS(TAMAÑO)
        return listaCurso.size();
    }
     
     /*==========ADICIONAR PROFESOR===============*/
     public void adicionarProfesor(Profesor p){
         listaProfesor.add(p);
     }
     /*==========OBTENER PROFESOR===============*/
     public Profesor obtenerProfesor(int posicion){
        return listaProfesor.get(posicion);
    }
     /*==========SIZE PROFESOR===============*/
     public int totalProfesor(){
        
        return listaProfesor.size();
    }
     
     
     
       /*==========LISTAR PROFESOR===============*/
    /* public Vector<Profesor> listarProfesor(){     
       Connection con = null;
       Vector<Profesor> datos = new Vector<Profesor>();
       Profesor dat = null;
       try {
           con = conexionBD.getConection();
           String sentencia_llenar_profesor = ("select * from tb_profesor");
           sentencia_preparada = con.prepareStatement(sentencia_llenar_profesor);
           resultado = sentencia_preparada.executeQuery();
            
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Profesor();
               dat.setCodigo(resultado.getString("prof_id"));
               
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }*/
}
