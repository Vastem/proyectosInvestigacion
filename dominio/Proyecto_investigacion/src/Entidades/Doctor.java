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
public class Doctor extends Profesor{

    public Doctor() {
    }

    public Doctor(String nombre, String apellidos, String despacho, String telefono) {
        super(nombre, apellidos, despacho, telefono);
    }
    
}
