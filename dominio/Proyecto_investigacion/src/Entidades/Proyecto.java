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
public class Proyecto {
    protected String codigo;
    protected String nombre;
    protected String acronimo;
    protected float presupuesto;
    protected String programaInvestigacion;
    protected String desarrolloFinanza;
    protected Date fechaInicio;
    protected Date fechaFin;
    protected String descripcionObjeto;
    protected List<ProfesorProyecto> profesoresProyecto;
    protected Doctor investigadorPrincipal;
    
    
    public Proyecto() {
    }

    public Proyecto(String codigo, String nombre, String acronimo, float presupuesto, String programaInvestigacion, String desarrolloFinanza, Date fechaInicio, Date fechaFin, String descripcionObjeto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acronimo = acronimo;
        this.presupuesto = presupuesto;
        this.programaInvestigacion = programaInvestigacion;
        this.desarrolloFinanza = desarrolloFinanza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionObjeto = descripcionObjeto;
    }

    
    
    public Proyecto(String codigo, String nombre, String acronimo, float presupuesto, String programaInvestigacion, String desarrolloFinanza, String telefono, Date fechaInicio, Date fechaFin, String descripcionObjeto, List<ProfesorProyecto> profesoresProyecto, Doctor investigadorPrincipal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acronimo = acronimo;
        this.presupuesto = presupuesto;
        this.programaInvestigacion = programaInvestigacion;
        this.desarrolloFinanza = desarrolloFinanza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionObjeto = descripcionObjeto;
        this.profesoresProyecto = profesoresProyecto;
        this.investigadorPrincipal = investigadorPrincipal;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getProgramaInvestigacion() {
        return programaInvestigacion;
    }

    public void setProgramaInvestigacion(String programaInvestigacion) {
        this.programaInvestigacion = programaInvestigacion;
    }

    public String getDesarrolloFinanza() {
        return desarrolloFinanza;
    }

    public void setDesarrolloFinanza(String desarrolloFinanza) {
        this.desarrolloFinanza = desarrolloFinanza;
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

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }

    public List<ProfesorProyecto> getProfesoresProyecto() {
        return profesoresProyecto;
    }

    public void setProfesoresProyecto(List<ProfesorProyecto> profesoresProyecto) {
        this.profesoresProyecto = profesoresProyecto;
    }

    public Doctor getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    public void setInvestigadorPrincipal(Doctor investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "codigo=" + codigo + ", nombre=" + nombre + ", acronimo=" + acronimo + ", presupuesto=" + presupuesto + ", programaInvestigacion=" + programaInvestigacion + ", desarrolloFinanza=" + desarrolloFinanza + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", descripcionObjeto=" + descripcionObjeto + ", profesoresProyecto=" + profesoresProyecto + ", investigadorPrincipal=" + investigadorPrincipal + '}';
    }
    
    
    
}
