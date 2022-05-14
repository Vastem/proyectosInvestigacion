/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Vastem
 */
public class ProfesorProyecto {
    protected Profesor profesor;
    protected Date fechaInicio;
    protected Date fechaFin;

    public ProfesorProyecto(Profesor profesor, Date fechaInicio, Date fechaFin) {
        this.profesor = profesor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ProfesorProyecto(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesorProyecto() {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.profesor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfesorProyecto other = (ProfesorProyecto) obj;
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfesorProyecto{" + "profesor=" + profesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
}
