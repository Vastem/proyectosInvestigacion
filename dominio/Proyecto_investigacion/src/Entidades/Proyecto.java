/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Vastem
 */
public class Proyecto {
    protected String codigo;
    protected String nombre;
    protected String acronimo;
    protected float presupuesto;
    protected Programa programaInvestigacion;
    protected String desarrolloFinanza;
    protected Date fechaInicio;
    protected Date fechaFin;
    protected String descripcionObjeto;
    protected List<ProfesorProyecto> profesoresProyecto;
    protected Doctor investigadorPrincipal;
    protected List<LineaInvestigacion> lineasInvestigacion;
    protected List<PublicacionCongreso> publicacionesCongreso;
    protected List<PublicacionRevista> publicacionesRevista;
    
    public Proyecto() {        
        publicacionesCongreso = new ArrayList();
        publicacionesRevista = new ArrayList();
    }

    public Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public Proyecto(String codigo, String nombre, String acronimo, float presupuesto, Programa programaInvestigacion, String desarrolloFinanza, Date fechaInicio, Date fechaFin, String descripcionObjeto) {
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

    
    
    public Proyecto(String codigo, String nombre, String acronimo, float presupuesto, Programa programaInvestigacion, String desarrolloFinanza, String telefono, Date fechaInicio, Date fechaFin, String descripcionObjeto, List<ProfesorProyecto> profesoresProyecto, Doctor investigadorPrincipal) {
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

//    public List<LineaInvestigacion> getLineaInvestigacion() {
//        return lineasInvestigacion;
//    }
//
//    public void setLineasInvestigacion(List<LineaInvestigacion> lineasInvestigacion) {
//        this.lineasInvestigacion = lineasInvestigacion;
//    }
    
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

    public Programa getProgramaInvestigacion() {
        return programaInvestigacion;
    }

    public void setProgramaInvestigacion(Programa programaInvestigacion) {
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

    public List<LineaInvestigacion> getLineasInvestigacion() {
        return lineasInvestigacion;
    }

    public void setLineasInvestigacion(List<LineaInvestigacion> lineasInvestigacion) {
        this.lineasInvestigacion = lineasInvestigacion;
    }

    public List<PublicacionCongreso> getPublicacionesCongreso() {
        return publicacionesCongreso;
    }
    
    public PublicacionCongreso getPublicacionesCongreso(int index) {
        return publicacionesCongreso.get(index);
    }

    public void setPublicacionesCongreso(List<PublicacionCongreso> publicacionesCongreso) {
        this.publicacionesCongreso = publicacionesCongreso;
    }
    
    public void setPublicacionesCongreso(PublicacionCongreso publicacion) {
        this.publicacionesCongreso.add(publicacion);
    }

    public List<PublicacionRevista> getPublicacionesRevista() {
        return publicacionesRevista;
    }

    public void setPublicacionesRevista(List<PublicacionRevista> publicacionesRevista) {
        this.publicacionesRevista = publicacionesRevista;
    }    
    
    public void setPublicacionesRevista(PublicacionRevista publicacion) {
        this.publicacionesRevista.add(publicacion);
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.acronimo);
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
        final Proyecto other = (Proyecto) obj;
        if (Objects.equals(this.nombre, other.nombre) || Objects.equals(this.acronimo, other.acronimo)) {
            return true;
        }
        return false;
    }

    
    
    @Override
    public String toString() {
        return nombre + ", " + acronimo;
    }
    
    
    
}
