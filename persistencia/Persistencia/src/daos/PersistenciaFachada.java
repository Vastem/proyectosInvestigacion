/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Doctor;
import Entidades.LineaInvestigacion;
import Entidades.NoDoctor;
import Entidades.Profesor;
import Entidades.Programa;
import Entidades.Proyecto;
import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import Entidades.PublicacionRevista;
import interfaces.IDoctorDAO;
import interfaces.ILineaInvestigacionDAO;
import interfaces.INoDoctorDAO;
import interfaces.IPersistenciaFachada;
import interfaces.IProgramaDAO;
import interfaces.IProyectoDAO;
import interfaces.IPublicacionCongresoDAO;
import interfaces.IPublicacionRevistaDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erick
 */
public class PersistenciaFachada implements IPersistenciaFachada{
    IProyectoDAO proyectoDAO ;
    IDoctorDAO doctorDAO;
    INoDoctorDAO noDoctorDAO;
    ILineaInvestigacionDAO lineaInvDAO;
    IProgramaDAO programaDAO; 
    IPublicacionRevistaDAO revistaDAO;
    IPublicacionCongresoDAO congresoDAO;

    public PersistenciaFachada() {
        proyectoDAO=DaosFactory.createProyectoDAO();
        doctorDAO=DaosFactory.createDoctorDAO();
        noDoctorDAO=DaosFactory.createNoDoctorDAO();
        lineaInvDAO=DaosFactory.createLineaInvestigacionDAO();
        programaDAO=DaosFactory.createProgramaDAO();
        revistaDAO=DaosFactory.createPublicacionRevistaDAO();
        congresoDAO=DaosFactory.createPublicacionCongresoDAO();
    }

    @Override
    public boolean agregar(Proyecto proyecto) {
        return proyectoDAO.agregar(proyecto);
    }

    @Override
    public boolean eliminar(Proyecto proyecto) {
        return proyectoDAO.eliminar(proyecto);
    }

    @Override
    public boolean actualizar(Proyecto proyecto) {
        return proyectoDAO.actualizar(proyecto);
    }

    @Override
    public List<Proyecto> consultarTodosProyecto() {
        return proyectoDAO.consultarTodos();
    }

    @Override
    public List<Proyecto> consultarCodigo(String codigo) {
        return proyectoDAO.consultarCodigo(codigo);
    }

    @Override
    public List<Proyecto> consultarNombre(String nombre) {
        return proyectoDAO.consultarNombre(nombre);
    }

    @Override
    public List<Proyecto> consultarAcronimo(String acronimo) {
        return proyectoDAO.consultarAcronimo(acronimo);
    }

    @Override
    public List<Proyecto> consultarPrograma(String programa) {
        return proyectoDAO.consultarPrograma(programa);
    }

    @Override
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin) {
        return proyectoDAO.consultarFechas(fechaInicio, fechaFin);
    }

    @Override
    public List<Proyecto> consultarPublicacion(String titulo) {
        return proyectoDAO.consultarPublicacion(titulo);
    }

    @Override
    public boolean agregar(NoDoctor ndoctor) {
        return noDoctorDAO.agregar(ndoctor);
    }

    @Override
    public boolean eliminar(NoDoctor ndoctor) {
        return noDoctorDAO.eliminar(ndoctor);
    }

    @Override
    public boolean actualizar(NoDoctor ndoctor) {
        return noDoctorDAO.actualizar(ndoctor);}

    @Override
    public List<Profesor> cosultarTodosNoDoctor() {
        return noDoctorDAO.cosultarTodos();
    }

    @Override
    public boolean agregar(Doctor doctor) {
        return doctorDAO.agregar(doctor);}

    @Override
    public List<Profesor> cosultarTodosDoctor() {
        return doctorDAO.cosultarTodos();
    }

    @Override
    public List<Programa> cosultarTodosPrograma() {
        return programaDAO.cosultarTodos();
    }

    @Override
    public List<LineaInvestigacion> cosultarTodosLineaInv() {
        return lineaInvDAO.cosultarTodos();
    }
    
    public boolean agregar(PublicacionRevista revista) {
        return revistaDAO.agregar(revista);
    }
    
    public boolean agregar(PublicacionCongreso congreso) {
        return congresoDAO.agregar(congreso);
    }
    
    public List<Publicacion> cosultarTodosPublicacionRevista() {
        return revistaDAO.cosultarTodos();
    }
    
    public List<Publicacion> cosultarTodosPublicacionCongreso() {
        return congresoDAO.cosultarTodos();
    }
    
    public List<Publicacion> cosultarTituloCongreso(String titulo) {
        return congresoDAO.consultarTitulo(titulo);
    }
    
    public List<Publicacion> cosultarTituloRevista(String titulo) {
        return revistaDAO.consultarTitulo(titulo);
    }
    
}
