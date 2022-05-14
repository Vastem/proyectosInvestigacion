/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.LineaInvestigacion;
import Entidades.Profesor;
import Entidades.Programa;
import Entidades.Proyecto;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface INegocioFachada {
    public void agregarProyecto(Proyecto proyecto);
    
    public List<Programa> consultarTodosProgramas();
    
    public List<Profesor> consultarTodosDoc();
    public List<Profesor> consultarTodosNoDoc();
    
    public List<LineaInvestigacion> consultarTodosLinInv();
}
