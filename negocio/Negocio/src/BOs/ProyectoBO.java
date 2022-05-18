/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Proyecto;
import Entidades.Publicacion;
import daos.DaosFactory;
import daos.PersistenciaFachada;
import interfaces.IPersistenciaFachada;
import interfaces.IProyectoBO;
import interfaces.IProyectoDAO;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProyectoBO implements IProyectoBO{
    private IPersistenciaFachada perFac;

    public ProyectoBO() {
       perFac = new PersistenciaFachada();
    }

    @Override
    public boolean agregarProyecto(Proyecto proyecto) {
        if(perFac.agregar(proyecto)){
            JOptionPane.showMessageDialog(null, "El proyecto se agregó correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El proyecto no se pudo agregar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    @Override
    public Proyecto consultarProyecto(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean eliminarProyecto(Proyecto proyecto) {
        return perFac.eliminar(proyecto);
    }

    @Override
    public boolean actualizarProyecto(Proyecto proyecto) {
        return perFac.actualizar(proyecto);
    }

    @Override
    public List<Proyecto> consultarTodos() {
        return perFac.consultarTodosProyecto();
    }
    
    public List<Proyecto> consultarCodigo(String codigo) {
        return perFac.consultarCodigo(codigo);
    }
    
    public List<Proyecto> consultarNombre(String nombre){
        return perFac.consultarNombre(nombre);
    }
    
    public List<Proyecto> consultarAcronimo(String acronimo){
        return perFac.consultarAcronimo(acronimo);
    }
    
    public List<Proyecto> consultarPrograma(String programa){
        return perFac.consultarPrograma(programa);
    }

    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin){
        return perFac.consultarFechas(fechaInicio, fechaFin);
    }
    
    public List<Proyecto> consultarPublicacion(String titulo){
        return perFac.consultarPublicacion(titulo);
    }
    
    public boolean agregarPublicacion(Proyecto p, String titulo){
        if(consultarPublicacion(titulo) != null){
            JOptionPane.showMessageDialog(null, "La publicacion no se pudo agregar","Precaución",JOptionPane.ERROR_MESSAGE);   
            return false;
        }
        JOptionPane.showMessageDialog(null, "Se agregó la publicación","",JOptionPane.INFORMATION_MESSAGE);
        return actualizarProyecto(p);
    }
    
}
