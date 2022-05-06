/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.*;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class DoctorDAO implements IDoctorDAO{
    DB database;
    DBCollection collection;
    private MongoDatabase bd;

    public DoctorDAO() {
        crearConexion();
    }
    
    public void crearConexion(){
        MongoClient mongo = null;
        
        try{
            mongo = new MongoClient("localhost",27017);
            System.out.println("Conectado");
            
            database=mongo.getDB("proyectosInvestigacion");
            collection=database.getCollection("doctores");
        }
        catch(MongoException e){
           
            System.out.println("fallo");
        }
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doctor> cosultarTodos() {
        MongoCollection <Doctor> coleccion = this.getColecion();
        List<Doctor> lDoc = new LinkedList<>();
        coleccion.find().into(lDoc);
        return lDoc;
    }
    
}
