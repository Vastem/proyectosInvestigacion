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
import java.util.LinkedList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author Vastem
 */
public class LineaInvestigacionDAO implements ILineaInvestigacionDAO{
    private MongoDatabase bd;
    private IConexionDB con;

    public LineaInvestigacionDAO(IConexionDB con) {
        this.con = con;                      
        this.bd = con.crearConexion();
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
        MongoCollection <LineaInvestigacion> coleccion = this.getColecion();
        coleccion.deleteOne((Bson)lInvestigacion);      
        return true;
    }

    @Override
    public boolean actualizar(LineaInvestigacion lInvestigacionBuscar,LineaInvestigacion lInvestigacionActualiza) {
        MongoCollection<LineaInvestigacion> coleccion = this.getColecion();
        coleccion.updateOne((Bson) lInvestigacionBuscar, (Bson) lInvestigacionActualiza);
        return true;
    }

    @Override
    public List<LineaInvestigacion> cosultarTodos() {
        MongoCollection <LineaInvestigacion> coleccion = this.getColecion();
        List<LineaInvestigacion> linea = new LinkedList<>();
        coleccion.find().into(linea);
        return linea;
    }
    
}
