/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Proyecto;
import daos.ProyectoDAO;
import interfaces.IProyectoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProyectoBO {
    public IProyectoDAO proyectoDao = new ProyectoDAO();
    
    public boolean consultar(String nombre){
        if(!proyectoDao.cosultarTodos().equals(nombre)){
            JOptionPane.showMessageDialog(null, "El nombre del proyecto ya esta ocupada","Precaución",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void registrarProyecto(Proyecto proyecto){
        if(consultar(proyecto.getNombre())){
            proyectoDao.agregar(proyecto);
        }
    }
}
