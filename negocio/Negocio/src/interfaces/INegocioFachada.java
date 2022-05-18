/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Doctor;
import Entidades.LineaInvestigacion;
import Entidades.NoDoctor;
import Entidades.Profesor;
import Entidades.Programa;
import Entidades.Proyecto;
import java.util.Date;
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
    public void actualizarProyecto(Proyecto proyecto);
    public void guardarPublicacion(Proyecto proyecto);
    public void eliminarProyecto(Proyecto proyecto);
    public void agregarPublicacion(Proyecto proyecto, String titulo);
    public List<Proyecto> consultarTodosProyectos();
    public List<Proyecto> consultarProyectoCodigo(String codigo);
    public List<Proyecto> consultarProyectoNombre(String nombre);
    public List<Proyecto> consultarProyectoAcronimo(String acronimo);
    public List<Proyecto> consultarProyectoPrograma(String programa);
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin); 
    public boolean agregarNoDoctor(NoDoctor noDoctor);
    public boolean agregarDoctor(Doctor doctor);
    public boolean actualizarNoDoctor(NoDoctor NoDoctor);
    
}
