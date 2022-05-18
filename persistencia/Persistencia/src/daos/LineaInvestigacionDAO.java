/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Doctor;
import Entidades.LineaInvestigacion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.ILineaInvestigacionDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class LineaInvestigacionDAO implements ILineaInvestigacionDAO{
    private MongoDatabase bd;
    private IConexionDB con;

    public LineaInvestigacionDAO(IConexionDB con) {
        this.con = con;                      
        this.bd = con.getInstanceConexion();
    }
    
    private MongoCollection <LineaInvestigacion>getColecion(){
        return this.bd.getCollection("lineasinvestigacion", LineaInvestigacion.class);
    }
    
    @Override
    public boolean agregar(LineaInvestigacion lInvestigacion) {
        MongoCollection <LineaInvestigacion> coleccion = this.getColecion();
        coleccion.insertOne(lInvestigacion);
        return true;
    }

    @Override
    public boolean eliminar(LineaInvestigacion lInvestigacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(LineaInvestigacion lInvestigacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LineaInvestigacion> cosultarTodos() {
        MongoCollection <LineaInvestigacion> coleccion = this.getColecion();
        List<LineaInvestigacion> linea = new LinkedList<>();
        return coleccion.find().into(linea); 

        //return this.getColecion().find().into(new ArrayList());

    } 
}
