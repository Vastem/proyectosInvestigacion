/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.NoDoctor;
import Entidades.Profesor;
import daos.DaosFactory;
import interfaces.INoDoctorBO;
import interfaces.INoDoctorDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class NoDoctorBO implements INoDoctorBO{
    private INoDoctorDAO noDoctorDao;

    public NoDoctorBO() {
        noDoctorDao=DaosFactory.createNoDoctorDAO();
    }

    @Override
    public boolean agregar(NoDoctor noDoctor) {
        if(noDoctorDao.agregar(noDoctor)){
            JOptionPane.showMessageDialog(null, "El profesor se registró correctamente");
            return true;
        }
        JOptionPane.showMessageDialog(null, "El profesor no se pudo registrar","Precaución",JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public boolean eliminar(NoDoctor ndoctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(NoDoctor ndoctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NoDoctor consultar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> consultarTodos() {
        return noDoctorDao.cosultarTodos();
    }
    
    
}
