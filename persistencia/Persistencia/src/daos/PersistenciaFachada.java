/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import interfaces.IDoctorDAO;
import interfaces.ILineaInvestigacionDAO;
import interfaces.INoDoctorDAO;
import interfaces.IProgramaDAO;
import interfaces.IProyectoDAO;

/**
 *
 * @author Erick
 */
public class PersistenciaFachada {
    IProyectoDAO proyectoDAO ;
    IDoctorDAO doctorDAO;
    INoDoctorDAO noDoctorDAO;
    ILineaInvestigacionDAO lineaInvDAO;
    IProgramaDAO programaDAO; 

    public PersistenciaFachada() {
        proyectoDAO=DaosFactory.createProyectoDAO();
        doctorDAO=DaosFactory.createDoctorDAO();
        noDoctorDAO=DaosFactory.createNoDoctorDAO();
        lineaInvDAO=DaosFactory.createLineaInvestigacionDAO();
        programaDAO=DaosFactory.createProgramaDAO();
        
    }
    
    
    
}
