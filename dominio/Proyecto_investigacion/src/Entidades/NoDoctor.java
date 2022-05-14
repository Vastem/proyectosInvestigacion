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
public class NoDoctor extends Profesor{
    protected List<PeriodoSup> periodos;

    public NoDoctor() {
    }

    public NoDoctor(String nombre, String apellidos, String despacho, String telefono) {
        super(nombre, apellidos, despacho, telefono);
    }

    public List<PeriodoSup> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<PeriodoSup> periodos) {
        this.periodos = periodos;
    }
    
    @Override
    public String toString() {
        return "Prof. " + super.toString();
    }
    
}
