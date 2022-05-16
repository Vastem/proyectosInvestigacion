/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Proyecto;
import daos.DaosFactory;
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
    private IProyectoDAO proyectoDao;

    public ProyectoBO() {
       proyectoDao=DaosFactory.createProyectoDAO();
    }

    @Override
    public boolean agregarProyecto(Proyecto proyecto) {
        
        if(proyectoDao.agregar(proyecto)){
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
        return proyectoDao.eliminar(proyecto);
    }

    @Override
    public boolean actualizarProyecto(Proyecto proyecto) {
        return proyectoDao.actualizar(proyecto);
    }

    @Override
    public List<Proyecto> consultarTodos() {
        return proyectoDao.consultarTodos();
    }
    
    public List<Proyecto> consultarCodigo(String codigo) {
        return proyectoDao.consultarCodigo(codigo);
    }
    
    public List<Proyecto> consultarNombre(String nombre){
        return proyectoDao.consultarNombre(nombre);
    }
    
    public List<Proyecto> consultarAcronimo(String acronimo){
        return proyectoDao.consultarAcronimo(acronimo);
    }
    
    public List<Proyecto> consultarPrograma(String programa){
        return proyectoDao.consultarPrograma(programa);
    }

    
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin){
        return proyectoDao.consultarFechas(fechaInicio, fechaFin);
    }
    
}
