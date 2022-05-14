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

    public LineaInvestigacion(String codigo, String nombre, String conjuntoDescrip) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.conjuntoDescrip = conjuntoDescrip;
    }

    public LineaInvestigacion() {
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

    @Override
    public String toString() {
        return "LI: "+nombre;
    }
    
    
}
