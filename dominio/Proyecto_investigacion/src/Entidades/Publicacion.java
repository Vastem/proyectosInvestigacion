/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Vastem
 */
public class Publicacion {
    protected ObjectId id;
    protected int numeroSecuencia;
    protected String titulo;
    protected List<Profesor> profesores;

    public Publicacion() {
        
    }

    public Publicacion(int numeroSecuencia, String titulo) {
        this.numeroSecuencia = numeroSecuencia;
        this.titulo = titulo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    
    
    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
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

    @Override
    public String toString() {
        return "Publicacion{" + "numeroSecuencia=" + numeroSecuencia + ", titulo=" + titulo + ", listaProfesores=";
    }
    
    
    
}
