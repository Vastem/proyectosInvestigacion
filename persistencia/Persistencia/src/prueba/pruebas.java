/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Entidades.Doctor;
import daos.ConexionDB;
import daos.DoctorDAO;
import interfaces.IConexionDB;
import interfaces.IDoctorDAO;

/**
 *
 * @author Vastem
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionDB c = new ConexionDB();
        Doctor d = new Doctor();
        IDoctorDAO doc = new DoctorDAO((ConexionDB) c);

        d.setApellidos("Duran");
        d.setNombre("C");
        d.setDespacho("itson");
        d.setTelefono("69");
        
        doc.agregar(d);
        
    }
    
}
