/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Proyecto;
import daos.DaosFactory2;
import interfaces.IProyectoBO;
import interfaces.IProyectoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProyectoBO implements IProyectoBO{
    private IProyectoDAO proyectoDao;

    public ProyectoBO() {
       DaosFactory2 dF=new DaosFactory2();
       proyectoDao=dF.createProyectoDAO();
    }
    
    public boolean consultar(String nombre){
        if(proyectoDao.cosultarTodos().contains(new Proyecto(nombre))){
            JOptionPane.showMessageDialog(null, "El nombre del proyecto ya esta ocupada","Precaución",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
//    public void registrarProyecto(Proyecto proyecto){
//        if(consultar(proyecto.getNombre())){
//            proyectoDao.agregar(proyecto);
//        }
//    }

    @Override
    public boolean agregarProyecto(Proyecto proyecto) {
        if(proyectoDao.cosultarTodos().contains(new Proyecto(proyecto.getNombre()))){
            JOptionPane.showMessageDialog(null, "El nombre del proyecto ya esta ocupada","Precaución",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(proyectoDao.agregar(proyecto)){
            JOptionPane.showMessageDialog(null, "El proyecto se agrego correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El proyecto no se pudo agregar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    @Override
    public Proyecto consultarProyecto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean eliminarProyecto(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarProyecto(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
