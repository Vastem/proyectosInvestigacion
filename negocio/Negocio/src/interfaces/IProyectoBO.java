/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Proyecto;
import Entidades.Publicacion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface IProyectoBO {
    public boolean agregarProyecto(Proyecto proyecto);
    public boolean eliminarProyecto(Proyecto proyecto);
    public boolean actualizarProyecto(Proyecto proyecto);
    public Proyecto consultarProyecto(Proyecto proyecto);
    public List<Proyecto> consultarTodos();
    public List<Proyecto> consultarCodigo(String codigo);
    public List<Proyecto> consultarNombre(String nombre);
    public List<Proyecto> consultarAcronimo(String acronimo);
    public List<Proyecto> consultarPrograma(String programa);
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin);
    public List<Proyecto> consultarPublicacion(String titulo);
    public boolean agregarPublicacion(Proyecto p, String titulo);
}
