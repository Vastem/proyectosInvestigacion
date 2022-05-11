/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import interfaces.IDoctorBO;
import interfaces.ILineaInvestigacionBO;
import interfaces.INoDoctorBO;
import interfaces.IProgramaBO;
import interfaces.IProyectoBO;

/**
 *
 * @author Erick
 */
public class FabricaBOs {
    
    public static IProyectoBO createProyectoBO(){
        return new ProyectoBO();
    }
    
    public static IDoctorBO createDoctorBO(){
        return new DoctorBO();
    }
    
    public static INoDoctorBO createNoDoctorBO(){
        return new NoDoctorBO();
    }
    
    public static IProgramaBO createProgramaBO(){
        return new ProgramaBO();
    }
    
    public static ILineaInvestigacionBO createLineaInvBO(){
        return new LineaInvestigacionBO();
    }
    
    
}
