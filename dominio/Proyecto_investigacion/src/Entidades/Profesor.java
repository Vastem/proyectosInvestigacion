/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import java.util.List;
import proyectos.*;

/**
 *
 * @author Vastem
 */
public class Profesor {
    protected String nombre;
    protected String apellidos;
    protected String despacho;
    protected String telefono;
    protected List<Proyectos> proyectos;
    protected List<LineaInvestigacion> lineas;

    public Profesor() {
    }

    public Profesor(String nombre, String apellidos, String despacho, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.despacho = despacho;
        this.telefono = telefono;
    }

    
    
    public Profesor(String nombre, String apellidos, String despacho, String telefono, List<Proyectos> proyectos, List<LineaInvestigacion> lineas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.despacho = despacho;
        this.telefono = telefono;
        this.proyectos = proyectos;
        this.lineas = lineas;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Proyectos> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyectos> proyectos) {
        this.proyectos = proyectos;
    }

    public List<LineaInvestigacion> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaInvestigacion> lineas) {
        this.lineas = lineas;
    }
    
    
}
