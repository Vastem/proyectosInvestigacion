/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.NoDoctor;
import Entidades.Profesor;
import daos.DaosFactory;
import daos.PersistenciaFachada;
import interfaces.INoDoctorBO;
import interfaces.INoDoctorDAO;
import interfaces.IPersistenciaFachada;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class NoDoctorBO implements INoDoctorBO{
    private IPersistenciaFachada perFac;

    public NoDoctorBO() {
        perFac = new PersistenciaFachada();
    }

    @Override
    public boolean agregar(NoDoctor noDoctor) {
        if(perFac.agregar(noDoctor)){
            JOptionPane.showMessageDialog(null, "El profesor se registró correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El profesor no se pudo registrar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public boolean actualizar(NoDoctor noDoctor) {
        if(perFac.actualizar(noDoctor)){
            JOptionPane.showMessageDialog(null, "El profesor se actualizó correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El profesor no se pudo actualizar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public List<Profesor> consultarTodos() {
        return perFac.cosultarTodosNoDoctor();
    }
    
    
}
