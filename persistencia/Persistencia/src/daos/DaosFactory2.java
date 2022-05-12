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
public class DaosFactory2 {
    //private  final IConexionDB conexion=ConexionDB.getInstance();
    private  final IConexionDB conexion=null;
    
    public  IProyectoDAO createProyectoDAO(){
        return new ProyectoDAO(conexion);
    }
    
    public  IProgramaDAO createProgramaDAO(){
        return new ProgramaDAO(conexion);
    }
    
    public  ILineaInvestigacionDAO createLineaInvestigacionDAO(){
        return new LineaInvestigacionDAO(conexion);
    }
    
    public  IDoctorDAO createDoctorDAO(){
        return new DoctorDAO(conexion);
    }
    
    public  INoDoctorDAO createNoDoctorDAO(){
        return new NoDoctorDAO(conexion);
    }
}