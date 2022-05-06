/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;

/**
 *
 * @author Vastem
 */
public class LineaInvestigacion {
    protected String codigo;
    protected String nombre;
    protected String conjuntoDescrip;
    protected List<Profesor> profesores;
    protected List<Publicacion> publicaciones;

    public LineaInvestigacion(String codigo, String nombre, String conjuntoDescrip, List<Profesor> profesores, List<Publicacion> publicaciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.conjuntoDescrip = conjuntoDescrip;
        this.profesores = profesores;
        this.publicaciones = publicaciones;
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

    public String getConjuntoDescrip() {
        return conjuntoDescrip;
    }

    public void setConjuntoDescrip(String conjuntoDescrip) {
        this.conjuntoDescrip = conjuntoDescrip;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @Override
    public String toString() {
        return "LineaInvestigacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", conjuntoDescrip=" + conjuntoDescrip + ", profesores=" + profesores + ", publicaciones=" + publicaciones + '}';
    }
    
    
}
