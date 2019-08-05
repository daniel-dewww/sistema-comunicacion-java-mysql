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
public class Alumno {
    private static String idAlumno= "";
    private String nombreAlumno;
    private String padreAlumno;

    public Alumno(){
    }
    public Alumno(String idAlumno, String nombreAlumno, String padreAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.padreAlumno = padreAlumno;
    }

    public static String getIdAlumno() {
        return idAlumno;
    }

    public  static void setIdAlumno(String idAlumno) {
        Alumno.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getPadreAlumno() {
        return padreAlumno;
    }

    public void setPadreAlumno(String padreAlumno) {
        this.padreAlumno = padreAlumno;
    }
     public String toString(){
        return this.nombreAlumno;
    }
    
    
}
