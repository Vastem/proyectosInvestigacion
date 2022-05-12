/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.IDoctorDAO;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author Vastem
 */
public class DoctorDAO implements IDoctorDAO{
    private MongoDatabase bd;
    private IConexionDB con;
    
    public DoctorDAO(IConexionDB con){
        this.con = con;                      
        this.bd = con.crearConexion();
    }

    public DoctorDAO() {
        
    }

    private MongoCollection <Doctor>getColecion(){
        return this.bd.getCollection("doctores", Doctor.class);
    }
    
    @Override
    public boolean agregar(Doctor doctor) {
        MongoCollection <Doctor> coleccion = this.getColecion();
        coleccion.insertOne(doctor);
        return true;
    }

    @Override
    public boolean eliminar(Doctor doctor) {
        MongoCollection <Doctor> coleccion = this.getColecion();
        coleccion.deleteOne((Bson)doctor);      
        return true;
    }

    @Override
    public boolean actualizar(Doctor docBuscar, Doctor docActualiza) {
        MongoCollection <Doctor> coleccion = this.getColecion();
        coleccion.updateOne((Bson)docBuscar, (Bson)docActualiza);
        return true;
    }

    @Override
    public List<Profesor> cosultarTodos() {
        MongoCollection <Doctor> coleccion = this.getColecion();
        List<Profesor> lDoc = new LinkedList<>();
        coleccion.find().into(lDoc);
        return lDoc;
    }
    
}
