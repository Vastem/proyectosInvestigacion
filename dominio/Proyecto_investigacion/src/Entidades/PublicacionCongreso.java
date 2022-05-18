/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Vastem
 */
public class PublicacionCongreso extends Publicacion{
    protected String nombreCongreso;
    protected Date fechaInicio;
    protected Date fechaFin;
    protected String lugarCelebracion;
    protected String pais;
    protected String editorial;
    protected String tipo;

    public PublicacionCongreso(int numeroSecuencia, String titulo) {
        super(numeroSecuencia, titulo);
    }

    public PublicacionCongreso() {
    }
    
    public PublicacionCongreso(int numeroSecuencia, String titulo, String nombreCongreso, Date fechaInicio, Date fechaFin, String lugarCelebracion, String pais, String editorial) {
        super(numeroSecuencia, titulo);
        this.nombreCongreso = nombreCongreso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugarCelebracion = lugarCelebracion;
        this.pais = pais;
        this.editorial = editorial;
    }

    public String getNombreCongreso() {
        return nombreCongreso;
    }

    public void setNombreCongreso(String nombreCongreso) {
        this.nombreCongreso = nombreCongreso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getLugarCelebracion() {
        return lugarCelebracion;
    }

    public void setLugarCelebracion(String lugarCelebracion) {
        this.lugarCelebracion = lugarCelebracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "EnCongreso{" + "nombreCongreso=" + nombreCongreso + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", lugarCelebracion=" + lugarCelebracion + ", pais=" + pais + ", editorial=" + editorial + '}';
    }
    
    
    
    
}
