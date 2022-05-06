/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class ProfesorLineaInvestigacion {
    protected Profesor profesor;
    protected LineaInvestigacion lineaInvestigacion;

    public ProfesorLineaInvestigacion() {
    }

    public ProfesorLineaInvestigacion(Profesor profesor, LineaInvestigacion lineaInvestigacion) {
        this.profesor = profesor;
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public LineaInvestigacion getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    @Override
    public String toString() {
        return "ProfesorLineaInvestigacion{" + "profesor=" + profesor + ", lineaInvestigacion=" + lineaInvestigacion + '}';
    }
    
    
}
