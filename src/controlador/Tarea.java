/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Administrador
 */
public class Tarea {
    private int id;
    private String nombre;
    private String desc;
    private String alumno_carnet;
    private int curso_id;
    public Tarea( String nombre, String desc, String alumno_carnet, int curso_id) {
        this.id = id;
        this.nombre = nombre;
        this.desc = desc;
         this.alumno_carnet = alumno_carnet;
          this.curso_id = curso_id;
    }
   
    public Tarea(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAlumno_carnet() {
        return alumno_carnet;
    }

    public void setAlumno_carnet(String alumno_carnet) {
        this.alumno_carnet = alumno_carnet;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

   
    
    
            
}
