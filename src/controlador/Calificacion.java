/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author daniel
 */
public class Calificacion {
    private String alumnoCarnet;
    private String nombre;
    private String curso_id;
    private int cal_nota;
    private String cal_observacion;

    public Calificacion(String nombre, String curso_id, int cal_nota, String cal_observacion) {
        this.alumnoCarnet = alumnoCarnet;
        this.curso_id = curso_id;
        this.cal_nota = cal_nota;
        this.cal_observacion = cal_observacion;
         this.nombre = nombre;
    }

    public String getAlumnoCarnet() {
        return alumnoCarnet;
    }

    public void setAlumno_carnet(String alumno_carnet) {
        this.alumnoCarnet = alumno_carnet;
    }

    public String getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(String curso_id) {
        this.curso_id = curso_id;
    }

    public int getCal_nota() {
        return cal_nota;
    }

    public void setCal_nota(int cal_nota) {
        this.cal_nota = cal_nota;
    }

    public String getCal_observacion() {
        return cal_observacion;
    }

    public void setCal_observacion(String cal_observacion) {
        this.cal_observacion = cal_observacion;
    }
    public String getNombre( ) {
        return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }
    
    
}
