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
public class ProfesorProyecto {
    protected Profesor profesor;
    protected Proyecto proyecto;
    protected Date fechaInicio;
    protected Date fechaFin;

    public ProfesorProyecto(Profesor profesor, Proyecto proyecto, Date fechaInicio, Date fechaFin) {
        this.profesor = profesor;
        this.proyecto = proyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
    

    @Override
    public String toString() {
        return "ProfesorProyecto{" + "profesor=" + profesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
}
