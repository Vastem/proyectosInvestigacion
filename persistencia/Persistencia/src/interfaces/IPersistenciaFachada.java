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
public interface IPersistenciaFachada {
    public boolean agregar(Proyecto proyecto);

    public boolean eliminar(Proyecto proyecto);

    public boolean actualizar(Proyecto proyecto);
    
    public List<Proyecto> consultarTodosProyecto();
    
    public List<Proyecto> consultarCodigo(String codigo);
    
    public List<Proyecto> consultarNombre(String nombre);
    
    public List<Proyecto> consultarAcronimo(String acronimo);
    
    public List<Proyecto> consultarPrograma(String programa);
    
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin);
    
    public List<Proyecto> consultarPublicacion(String titulo);
    
    public boolean agregar(NoDoctor ndoctor);
    
    public boolean eliminar(NoDoctor ndoctor);
    
    public boolean actualizar(NoDoctor ndoctor);
    
    public List<Profesor> cosultarTodosDoctor();
    
    public boolean agregar(Doctor doctor);
    
    public List<Profesor> cosultarTodosNoDoctor();
    
    public List<Programa> cosultarTodosPrograma();
    
    public List<LineaInvestigacion> cosultarTodosLineaInv();
    
}
