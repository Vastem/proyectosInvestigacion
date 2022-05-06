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
public class PublicacionLineaInvestigacion {
    protected LineaInvestigacion lineaInvestigacion;
    protected Publicacion publicacion;

    public PublicacionLineaInvestigacion() {
    }

    public PublicacionLineaInvestigacion(LineaInvestigacion lineaInvestigacion, Publicacion publicacion) {
        this.lineaInvestigacion = lineaInvestigacion;
        this.publicacion = publicacion;
    }

    public LineaInvestigacion getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "PublicacionLineaInvestigacion{" + "lineaInvestigacion=" + lineaInvestigacion + ", publicacion=" + publicacion + '}';
    }
    
    
}
