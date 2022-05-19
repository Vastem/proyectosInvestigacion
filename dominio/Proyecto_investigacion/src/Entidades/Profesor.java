/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import org.bson.types.ObjectId;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class Profesor {
    protected ObjectId id;
    protected String nombre;
    protected String apellidos;
    protected String despacho;
    protected String telefono;
    protected List<Proyecto> proyectos;
    protected List<LineaInvestigacion> lineas;

    public Profesor() {
    }

    public Profesor(ObjectId id) {
        this.id = id;
    }
    
    public Profesor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public Profesor(String nombre, String apellidos, String despacho, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.despacho = despacho;
        this.telefono = telefono;
    }
    
    public Profesor(String nombre, String apellidos, String despacho, String telefono, List<Proyecto> proyectos, List<LineaInvestigacion> lineas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.despacho = despacho;
        this.telefono = telefono;
        this.proyectos = proyectos;
        this.lineas = lineas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    @Override
    public String toString() {
        return nombre + " " +  apellidos;
    }
    
    
    
}
