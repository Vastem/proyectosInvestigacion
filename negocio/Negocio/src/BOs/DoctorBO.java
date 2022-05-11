/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Doctor;
import Entidades.Profesor;
import daos.DaosFactory2;
import interfaces.IDoctorBO;
import interfaces.IDoctorDAO;
import java.util.List;

/**
 *
 * @author Erick
 */
public class DoctorBO implements IDoctorBO{
    private IDoctorDAO doctor;

    public DoctorBO() {
        DaosFactory2 dF=new DaosFactory2();
        doctor=dF.createDoctorDAO();
    }

    
    
    @Override
    public boolean agregar(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return doctor.cosultarTodos();
    }
    
}
