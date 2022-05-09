/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Entidades.Doctor;
import Entidades.LineaInvestigacion;
import daos.ConexionDB;
import daos.DoctorDAO;
import daos.LineaInvestigacionDAO;
import interfaces.IConexionDB;
import interfaces.IDoctorDAO;
import interfaces.ILineaInvestigacionDAO;

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

        d.setApellidos("Pendejon");
        d.setNombre("Pendejin");
        d.setDespacho("itson");
        d.setTelefono("69");
        
        doc.agregar(d);
        
        LineaInvestigacion l = new LineaInvestigacion();
        ILineaInvestigacionDAO lin = new LineaInvestigacionDAO((ConexionDB) c);
        
        l.setCodigo("2");
        l.setConjuntoDescrip("nosè");
        l.setNombre("name");
        
        lin.agregar(l);
        
    }
    
}
