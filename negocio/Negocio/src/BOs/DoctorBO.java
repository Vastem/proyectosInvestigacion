/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Doctor;
import Entidades.Profesor;
import daos.DaosFactory;
import daos.PersistenciaFachada;
import interfaces.IDoctorBO;
import interfaces.IDoctorDAO;
import interfaces.IPersistenciaFachada;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class DoctorBO implements IDoctorBO{
    private IPersistenciaFachada perFac;

    public DoctorBO() {
        perFac = new PersistenciaFachada();
    }

    
    
    @Override
    public boolean agregar(Doctor doctor) {
        if(perFac.agregar(doctor)){
            JOptionPane.showMessageDialog(null, "El profesor (doctor) se registró correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El profesor (doctor) no se pudo registrar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public List<Profesor> consultarTodos() {
        return perFac.cosultarTodosDoctor();
    }
    
}
