/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import controlador.Cursos;
import controlador.Alumno;
import controlador.Calificacion;
import controlador.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    private Cursos selectedItem;
    private ArrayList<Calificacion> listaCalificacion = new  ArrayList<Calificacion>();
    private ArrayList<Tarea> listarTarea = new  ArrayList<Tarea>();
   

    public Metodos_sql() {
    }
    
   
      
     public void adicionar(Calificacion c){ 
        listaCalificacion.add(c);
    }
    
     
     public Calificacion obtener(int posicion){
        return listaCalificacion.get(posicion);
    }
      // EL TAMAÑO DE LA LISTA DE PRODUCTOS
    public int totalCal(){
        //ESTO SERA REFLEJADO EN EL GUI MEDIANTE UN TEXTAREA, AHÍ SE VERA TODOS LOS PRODUCTOS(TAMAÑO)
        return listaCalificacion.size();
    }
     /*==========ADICIONAR TAREA===============*/
     public void adicionarTarea(Tarea p){
         listarTarea.add(p);
     }
     /*==========OBTENER TAREA===============*/
     public Tarea obtenerTarea(int posicion){
        return listarTarea.get(posicion);
    }
     /*==========SIZE TAREA===============*/
     public int totalTarea(){
        
        return listarTarea.size();
    }
    public int guardarCalificacion(String alumno,int curso_id,int nota,String observacion){
        int resultado = 0;
        Connection con = null;
        
        try {
            con = conexionBD.getConection();
             String consulta_guardar_calificacion = ("insert into tb_calificacion(alumno_carnet,curso_id,cal_nota,cal_observacion) values (?,?,?,?)");
            sentencia_preparada = con.prepareStatement(consulta_guardar_calificacion);
           
            sentencia_preparada.setString(1,alumno); 
            sentencia_preparada.setInt(2,curso_id); 
            sentencia_preparada.setInt(3,nota); 
            sentencia_preparada.setString(4,observacion); 
            resultado = sentencia_preparada.executeUpdate();
            con.close();
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
        return resultado;
    }
      public int guardarTarea(String nombre,String descripcion,String alumno,int curso){
        int resultado = 0;
        Connection con = null;
        
        try {
            con = conexionBD.getConection();
             String consulta_guardar_calificacion = ("insert into tb_tarea(tar_nombre,tar_desc,alumno_carnet,curso_id) values (?,?,?,?)");
            sentencia_preparada = con.prepareStatement(consulta_guardar_calificacion);
           
            sentencia_preparada.setString(1,nombre); 
            sentencia_preparada.setString(2,descripcion); 
            sentencia_preparada.setString(3,alumno); 
            sentencia_preparada.setInt(4,curso); 
            resultado = sentencia_preparada.executeUpdate();
            con.close();
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
        return resultado;
    }
      public int guardarMensaje(String tema,String descripcion,String alumno,int curso,String codigoProfesor){
        int resultado = 0;
        Connection con = null;
        
        try {
            con = conexionBD.getConection();
             String consulta_guardar_calificacion = ("insert into tb_bandeja(ban_tema,ban_desc,alumno_carnet,curso_id,prof_id) values (?,?,?,?,?)");
            sentencia_preparada = con.prepareStatement(consulta_guardar_calificacion);
           
            sentencia_preparada.setString(1,tema); 
            sentencia_preparada.setString(2,descripcion); 
            sentencia_preparada.setString(3,alumno); 
            sentencia_preparada.setInt(4,curso); 
            sentencia_preparada.setString(5,codigoProfesor); 
            resultado = sentencia_preparada.executeUpdate();
            con.close();
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
        return resultado;
    }
   public int guardarMensajePadre(String tema, String descripcion,String alumnoId,  int curso , String profId ){
       int resultado =0;
       Connection con = null;
        String consulta_guardar = ("INSERT INTO TB_BANDEJA (ban_tema,ban_desc, alumno_carnet, curso_id, prof_id) VALUES (?,?,?,?,?)");
        try {
           con = conexionBD.getConection();
           sentencia_preparada = con.prepareStatement(consulta_guardar);
           sentencia_preparada.setString(1,tema); 
           sentencia_preparada.setString(2,descripcion); 
           sentencia_preparada.setString(3,alumnoId); 
           sentencia_preparada.setInt(4,curso); 
           sentencia_preparada.setString(5,profId); 
           resultado = sentencia_preparada.executeUpdate();
           con.close();
       } catch (Exception e) {
            System.out.println(e);
       }
        return resultado;
   }
            /*========BUSCAR NOMBRE POR EL CORREO=============*/
    public static String buscar(String correo){
    
       String busqueda_nombre = "";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT user_nombre  from TB_USUARIO where user_username='" + correo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String username = resultado.getString("user_nombre");
                
                busqueda_nombre = username + "";
            }
            conexion.close();
        }catch(Exception e){
             System.out.println(e);
        }
       
        
        return busqueda_nombre;
    
    }
            /*========BUSCAR ID POR EL CORREO=============*/
    public static String buscarId(String nombre){
    
       String busqueda_id = " ";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT user_id from TB_USUARIO where user_username ='" + nombre + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String user_id = resultado.getString("user_id");     
                busqueda_id = user_id;
            }
            conexion.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
        
        return busqueda_id;
    
    }
         /*========BUSCAR ID POR EL CORREO=============*/
    public static String buscarIdProfesor(String codigo){
    
       String busqueda_id = " ";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT prof_id from TB_profesor where user_id ='" + codigo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String user_id = resultado.getString("prof_id");     
                busqueda_id = user_id;
            }
            conexion.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
        
        return busqueda_id;
    
    }
    /*========BUSCAR ID POR EL CORREO=============*/
    public static String buscarIdPadre(String codigo){
    
       String busqueda_id = " ";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("SELECT pdr_id from TB_padre where user_id ='" + codigo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String user_id = resultado.getString("pdr_id");     
                busqueda_id = user_id;
            }
            conexion.close();
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
       
        
        return busqueda_id;
    
    }
    public static String buscarIdAlumno(String codigo){
    
       String busqueda_id = " ";
        Connection conexion = null;
        try{
          conexion = conexionBD.getConection();
          String sentencia_buscar = ("select alumno_carnet from tb_usuario inner join tb_padre on tb_usuario.user_id = tb_padre.user_id where pdr_id='"+ codigo + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { // si el resultado es el siguiente
                String user_id = resultado.getString("alumno_carnet");     
                busqueda_id = user_id;
            }
            conexion.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
        
        return busqueda_id;
    
    }
            /*========BUSCAR USUARIO REGISTRADO=============*/
    public static String buscarUsuarioRegistrado(String username, String password){
    String busqueda_usuario = null;
    Connection conexion = null;
    try{
        conexion = conexionBD.getConection();
        String sentencia_buscar_usuario = ("SELECT user_username,user_password from TB_USUARIO where user_username = '" + username + "' and user_password ='" + password + "'");
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
    
            /*========BUSCAR CURSO ID=============*/
   public static String buscarCursoId(String nombre){
       String resultado_id_curso = "";
       Connection conexion = null;
       try {
           conexion = conexionBD.getConection();
           String sentencia_buscar_curso_id = ("select curso_id from tb_curso where curso_nombre = '" + nombre + "'");
           sentencia_preparada = conexion.prepareStatement(sentencia_buscar_curso_id);
           resultado = sentencia_preparada.executeQuery();
           
           if (resultado.next()) {
              resultado_id_curso = "usuario encontrado"; 
           } else {
              resultado_id_curso = "usuario no encontrado"; 
           }
            conexion.close();
           
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
       }
       
       return resultado_id_curso;
       }
   
             /*========LLENAR CURSOS=============*/
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
               dat.setCodigo(0);
               dat.setNombre("Selecciona un curso");
               datos.add(dat);
           while (resultado.next()){
                 //una opcion del combobox
               dat = new Cursos();
               dat.setCodigo(resultado.getInt("curso_id"));
               dat.setNombre(resultado.getString("curso_nombre"));
               datos.add(dat);
          }
            
           
           con.close();
       } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return datos;
   
   }
            /*========LLENAR ALUMNO=============*/
    
   
   public Object getSelectedItem() {
        return selectedItem;
    }
    public int getSelectedCodigo() {
        return selectedItem == null ? null : selectedItem.getCodigo();
    }
}
   
   
  
 
   

