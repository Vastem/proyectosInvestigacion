/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class PeriodoSup {
    protected Doctor supervisor;
    protected Date fechaInicio;
    protected Date fechaFin;   
    protected List<NoDoctor> supervisados;

    public PeriodoSup(Doctor supervisor, List<NoDoctor> supervisados, Date fechaInicio, Date fechaFin) {
        this.supervisor = supervisor;
        this.supervisados=supervisados;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public PeriodoSup() {
    }

    public Doctor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Doctor supervisor) {
        this.supervisor = supervisor;
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
    
    public List<NoDoctor> getNoDoctores() {
        return supervisados;
    }

    public void setNoDoctores(List<NoDoctor> noDoctores) {
        this.supervisados = noDoctores;
    }

    @Override
    public String toString() {
        return "PeriodoSup{" + "supervisor=" + supervisor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", supervisados=" + supervisados + '}';
    }

}
