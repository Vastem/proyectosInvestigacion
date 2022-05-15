/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Doctor;
import Entidades.Profesor;
import daos.DaosFactory;
import interfaces.IDoctorBO;
import interfaces.IDoctorDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class DoctorBO implements IDoctorBO{
    private IDoctorDAO doctorDao;

    public DoctorBO() {
        doctorDao=DaosFactory.createDoctorDAO();
    }

    
    
    @Override
    public boolean agregar(Doctor doctor) {
        if(doctorDao.agregar(doctor)){
            JOptionPane.showMessageDialog(null, "El profesor (doctor) se registró correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El profesor (doctor) no se pudo registrar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public boolean eliminar(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doctor consultar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> consultarTodos() {
        return doctorDao.cosultarTodos();
    }
    
}
