/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Proyecto;

/**
 *
 * @author Erick
 */
public interface IProyectoBO {
    public boolean agregarProyecto(Proyecto proyecto);
    public boolean eliminarProyecto(Proyecto proyecto);
    public boolean actualizarProyecto(Proyecto proyecto);
    public Proyecto consultarProyecto(String codigo);
    
    
}
