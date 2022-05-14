/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.LineaInvestigacion;
import Entidades.Profesor;
import Entidades.Programa;
import Entidades.Proyecto;
import interfaces.IDoctorBO;
import interfaces.ILineaInvestigacionBO;
import interfaces.INegocioFachada;
import interfaces.INoDoctorBO;
import interfaces.IProgramaBO;
import interfaces.IProyectoBO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class NegocioFachada implements INegocioFachada{
    IProyectoBO proyectoBO ;
    IDoctorBO doctorBO;
    INoDoctorBO noDoctorBO;
    ILineaInvestigacionBO lineaInvBO;
    IProgramaBO programaBO; 

    public NegocioFachada() {
        proyectoBO=FabricaBOs.createProyectoBO();
        doctorBO=FabricaBOs.createDoctorBO();
        noDoctorBO=FabricaBOs.createNoDoctorBO();
        programaBO=FabricaBOs.createProgramaBO();
        lineaInvBO=FabricaBOs.createLineaInvBO();
    }
    
    @Override
    public void agregarProyecto(Proyecto proyecto){
        if(proyectoBO.consultarTodos().contains(proyecto)){
            JOptionPane.showMessageDialog(null, "El nombre del proyecto y/o el acrónimo ya existe","Precaución",JOptionPane.ERROR_MESSAGE);
            return;
        }
        proyectoBO.agregarProyecto(proyecto);
    }
    
    @Override
    public List<Programa> consultarTodosProgramas(){
        return programaBO.consultarTodos();
    }
    
    @Override
    public List<Profesor> consultarTodosDoc(){
        return doctorBO.consultarTodos();
    }
    
    @Override
    public List<Profesor> consultarTodosNoDoc(){
        return noDoctorBO.consultarTodos();
    }
    
    @Override
    public List<LineaInvestigacion> consultarTodosLinInv(){
        return lineaInvBO.consultarTodos();
    }
}
