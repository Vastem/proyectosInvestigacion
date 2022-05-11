/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Programa;
import Entidades.Proyecto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.IProgramaDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ProgramaDAO implements IProgramaDAO{
    private MongoDatabase bd;
    private IConexionDB con;
    
    public ProgramaDAO(IConexionDB con) {
        this.con = con;                      
        this.bd = con.crearConexion();
    }
    
    private MongoCollection <Programa>getColecion(){
        return this.bd.getCollection("proyectos", Programa.class);
    }

    @Override
    public boolean agregar(Programa programa) {
        MongoCollection <Programa> coleccion = this.getColecion();
        coleccion.insertOne(programa);
        return true;
    }

    @Override
    public boolean eliminar(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Programa> cosultarTodos() {
        MongoCollection <Programa> coleccion = this.getColecion();
        List<Programa> lPr = new LinkedList<>();
        coleccion.find().into(lPr);
        return lPr;
    }
    
}
