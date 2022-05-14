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
import java.util.LinkedList;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proyecto> consultarTodos() {
        MongoCollection <Proyecto> coleccion = this.getColecion();
        List<Proyecto> lPr = new LinkedList<>();
        coleccion.find().into(lPr);
        return lPr;
    }
    
}
