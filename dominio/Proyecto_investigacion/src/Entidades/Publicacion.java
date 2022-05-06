/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import proyectos.Proyectos;

/**
 *
 * @author Vastem
 */
public class Publicacion {
    protected int numeroSecuencia;
    protected String titulo;
    protected Proyecto proyecto;
    protected List<LineaInvestigacion> lineas;

    public Publicacion(int numeroSecuencia, String titulo) {
        this.numeroSecuencia = numeroSecuencia;
        this.titulo = titulo;
    }
    
    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(int numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Proyecto getListaProfesores() {
        return proyecto;
    }

    public void setListaProfesores(Proyecto listaProfesoresda) {
        this.proyecto = listaProfesoresda;
    }

    public List<LineaInvestigacion> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaInvestigacion> lineas) {
        this.lineas = lineas;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "numeroSecuencia=" + numeroSecuencia + ", titulo=" + titulo + ", listaProfesores=" + proyecto + ", lineas=" + lineas + '}';
    }
    
    
    
}
