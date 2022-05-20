/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Doctor;
import Entidades.LineaInvestigacion;
import Entidades.NoDoctor;
import Entidades.Profesor;
import Entidades.Programa;
import Entidades.Proyecto;
import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import Entidades.PublicacionRevista;
import interfaces.IDoctorBO;
import interfaces.ILineaInvestigacionBO;
import interfaces.INegocioFachada;
import interfaces.INoDoctorBO;
import interfaces.IProgramaBO;
import interfaces.IProyectoBO;
import interfaces.IPublicacionCongresoBO;
import interfaces.IPublicacionRevistaBO;
import java.util.Date;
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
    IPublicacionRevistaBO revistaBO;
    IPublicacionCongresoBO congresoBO;

    public NegocioFachada() {
        proyectoBO=FabricaBOs.createProyectoBO();
        doctorBO=FabricaBOs.createDoctorBO();
        noDoctorBO=FabricaBOs.createNoDoctorBO();
        programaBO=FabricaBOs.createProgramaBO();
        lineaInvBO=FabricaBOs.createLineaInvBO();
        revistaBO=FabricaBOs.createPublicacionRevistaBO();
        congresoBO=FabricaBOs.createPublicacionCongresoBO();
    }
   
    public void agregarProyecto(Proyecto proyecto){
        if(proyectoBO.consultarTodos().contains(proyecto)){
            JOptionPane.showMessageDialog(null, "El nombre del proyecto y/o el acrónimo ya existe","Precaución",JOptionPane.ERROR_MESSAGE);
            return;
        }
        proyectoBO.agregarProyecto(proyecto);
    }
    
    public void actualizarProyecto(Proyecto proyecto){
        if(proyectoBO.consultarTodos().contains(proyecto)){
            proyectoBO.actualizarProyecto(proyecto);
            return;
        }
        JOptionPane.showMessageDialog(null, "","Precaución",JOptionPane.ERROR_MESSAGE);
            
    }
    
    public void guardarPublicacion(Proyecto proyecto){
        if(proyectoBO.consultarTodos().contains(proyecto)){
            proyectoBO.actualizarProyecto(proyecto);
            return;
        }
        JOptionPane.showMessageDialog(null, "","Precaución",JOptionPane.ERROR_MESSAGE);
            
    }
  
    public void eliminarProyecto(Proyecto proyecto){
        if(proyectoBO.consultarTodos().contains(proyecto)){
            proyectoBO.eliminarProyecto(proyecto);
            return;
        }
        JOptionPane.showMessageDialog(null, "","Precaución",JOptionPane.ERROR_MESSAGE);
    }
    
    public void agregarPublicacion(Proyecto proyecto, String titulo){
        proyectoBO.agregarPublicacion(proyecto, titulo);
    }
    
    public List<Programa> consultarTodosProgramas(){
        return programaBO.consultarTodos();
    }
    
    public List<Profesor> consultarTodosDoc(){
        return doctorBO.consultarTodos();
    }
    
    public List<Profesor> consultarTodosNoDoc(){
        return noDoctorBO.consultarTodos();
    }
    
    public List<LineaInvestigacion> consultarTodosLinInv(){
        return lineaInvBO.consultarTodos();
    }
    
    public List<Proyecto> consultarTodosProyectos(){
        return proyectoBO.consultarTodos();
    }
    
    public List<Proyecto> consultarProyectoCodigo(String codigo){
        return proyectoBO.consultarCodigo(codigo);
    }
    
    public List<Proyecto> consultarProyectoNombre(String nombre){
        return proyectoBO.consultarNombre(nombre);
    }
    
    public List<Proyecto> consultarProyectoAcronimo(String acronimo){
        return proyectoBO.consultarAcronimo(acronimo);
    }
    
    public List<Proyecto> consultarProyectoPrograma(String programa){
        return proyectoBO.consultarPrograma(programa);
    }
    
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin){
        return proyectoBO.consultarFechas(fechaInicio, fechaFin);
    }
    
    public boolean agregarDoctor(Doctor doctor){
        if(doctorBO.consultarTodos().contains(doctor)){
            JOptionPane.showMessageDialog(null, "El doctor ya se encuentra registrado","Precaución",JOptionPane.ERROR_MESSAGE);
        }
        else if(doctorBO.agregar(doctor)){
            return true;
        }
        return false;
    }
    
    public boolean agregarNoDoctor(NoDoctor noDoctor){
        if(noDoctorBO.consultarTodos().contains(noDoctor)){
            JOptionPane.showMessageDialog(null, "El profesor ya se encuentra registrado","Precaución",JOptionPane.ERROR_MESSAGE);
        }
        else if(noDoctorBO.agregar(noDoctor)){
            return true;
        }
        return false;
    }
    
    public boolean actualizarNoDoctor(NoDoctor NoDoctor){
        if(noDoctorBO.consultarTodos().contains(NoDoctor)){
            JOptionPane.showMessageDialog(null, "El profesor ya se encuentra registrado","Precaución",JOptionPane.ERROR_MESSAGE);
        }
        else if(noDoctorBO.actualizar(NoDoctor)){
            return true;
        }
        return false;
    }
    
    public List<Publicacion> consultarTodosRevista(){
        return revistaBO.cosultarTodos();
    }
    
    public List<Publicacion> consultarTodosCongreso(){
        return congresoBO.cosultarTodos();
    }
    
    public boolean agregarPublicacionRevista(PublicacionRevista revista){
        if(consultarTodosRevista().contains(revista))return false;
        else if(revistaBO.agregar(revista)) return true;
        return false;
    }
    
    public boolean agregarPublicacionCongreso(PublicacionCongreso congreso){
        if(consultarTodosCongreso().contains(congreso))return false;
        else if(congresoBO.agregar(congreso)) return true;
        return false;
    }
    
    public List<Publicacion> consultarTituloRevista(String titulo){
        return revistaBO.consultarTitulo(titulo);
    }
    
    public List<Publicacion> consultarTituloCongreso(String titulo){
        return congresoBO.consultarTitulo(titulo);
    }
    
    public boolean consultarPublicacion(String titulo){
        if(proyectoBO.consultarPublicacion(titulo) == null){
            return true;
        }
        return false;
    }
    
}
