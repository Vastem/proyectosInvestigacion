/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import interfaces.IConexionDB;
import interfaces.IDoctorDAO;
import interfaces.ILineaInvestigacionDAO;
import interfaces.INoDoctorDAO;
import interfaces.IProgramaDAO;
import interfaces.IProyectoDAO;

/**
 *
 * @author Erick
 */
public class DaosFactory {
    private static final IConexionDB conexion=ConexionDB.getInstance();
    
    public static IProyectoDAO createProyectoDAO(){
        return new ProyectoDAO(conexion);
    }
    
    public static IProgramaDAO createProgramaDAO(){
        return new ProgramaDAO(conexion);
    }
    
    public static ILineaInvestigacionDAO createLineaInvestigacionDAO(){
        return new LineaInvestigacionDAO(conexion);
    }
    
    public static IDoctorDAO createDoctorDAO(){
        return new DoctorDAO(conexion);
    }
    
    public static INoDoctorDAO createNoDoctorDAO(){
        return new NoDoctorDAO(conexion);
    }
}
