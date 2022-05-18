/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.NoDoctor;
import Entidades.Proyecto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.IProyectoDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Vastem
 */
public class ProyectoDAO implements IProyectoDAO{
    private MongoDatabase bd;
    private IConexionDB con;
    
    public ProyectoDAO(IConexionDB con){
        this.con = con;                      
        this.bd = con.crearConexion();
    }
    
    private MongoCollection <Proyecto>getColecion(){
        return this.bd.getCollection("proyectos", Proyecto.class);
    }
    
    @Override
    public boolean agregar(Proyecto proyecto) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        coleccion.insertOne(proyecto);
        return true;
    }

    @Override
    public boolean eliminar(Proyecto proyecto) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        Document filtro = new Document("codigo", proyecto.getCodigo());
        coleccion.deleteOne(filtro);
        return true;
    }

    @Override
    public boolean actualizar(Proyecto proyecto) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        
        Document filtro = new Document("codigo", proyecto.getCodigo());
        Document cambios = new Document()
                .append("codigo", proyecto.getCodigo())
                .append("nombre", proyecto.getNombre())
                .append("acronimo", proyecto.getAcronimo())
                .append("programaInvestigacion", proyecto.getProgramaInvestigacion())
                .append("presupuesto", proyecto.getPresupuesto())
                .append("fechaInicio", proyecto.getFechaInicio())
                .append("fechaFin", proyecto.getFechaFin())
                .append("descripcionObjeto", proyecto.getDescripcionObjeto())
                .append("lineasInvestigacion", proyecto.getLineasInvestigacion())
                .append("profesoresProyecto", proyecto.getProfesoresProyecto())
                .append("investigadorPrincipal", proyecto.getInvestigadorPrincipal());

        coleccion.updateOne(filtro, new Document("$set", cambios));
        return true;
    }

    @Override
    public List<Proyecto> consultarTodos() {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = new LinkedList<>();
        coleccion.find().into(lPr);
//        if(lPr.isEmpty()){
//             return null;
//         }
        return lPr;
    }
    
    public List<Proyecto> consultarCodigo(String codigo) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("codigo", codigo)))).into(new ArrayList());
        if(lPr.isEmpty()){
             return null;
         }
        return lPr;
    }
    
    public List<Proyecto> consultarNombre(String nombre) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("nombre", nombre)))).into(new ArrayList());
        if(lPr.isEmpty()){
             return null;
         }
        if(lPr.isEmpty()){
             return null;
         }
        return lPr;
    }
    
    public List<Proyecto> consultarAcronimo(String acronimo) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("acronimo", acronimo)))).into(new ArrayList());
        if(lPr.isEmpty()){
             return null;
         }
        return lPr;
    }
    
    public List<Proyecto> consultarPrograma(String programa) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("programaInvestigacion.nombre", programa)))).into(new ArrayList());
        if(lPr.isEmpty()){
             return null;
         }
        return lPr;
    }
    
    public List<Proyecto> consultarFechas(Date fechaInicio, Date fechaFin) {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        Document filtro = new Document()
                .append("fechaInicio", new Document("$gte", fechaInicio))
                .append("fechaFin", new Document("$lte", fechaFin));
         List<Proyecto> lPr = coleccion.find(filtro).into(new ArrayList());
         if(lPr.isEmpty()){
             return null;
         }
         return lPr;
    }
}
