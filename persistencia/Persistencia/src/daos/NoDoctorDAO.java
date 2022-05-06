/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Doctor;
import Entidades.NoDoctor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.INoDoctorDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class NoDoctorDAO implements INoDoctorDAO{
    private MongoDatabase bd;
    
    private MongoCollection <NoDoctor>getColecion(){
        return this.bd.getCollection("nodoctores", NoDoctor.class);
    }
    
    @Override
    public boolean agregar(NoDoctor ndoctor) {
        MongoCollection <NoDoctor> coleccion = this.getColecion();
        coleccion.insertOne(ndoctor);
        return true;
    }

    @Override
    public boolean eliminar(NoDoctor ndoctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(NoDoctor ndoctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NoDoctor> cosultarTodos() {
        MongoCollection <NoDoctor> coleccion = this.getColecion();
        List<NoDoctor> lDoc = new LinkedList<>();
        coleccion.find().into(lDoc);
        return lDoc;
    }
    
}
