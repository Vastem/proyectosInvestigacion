/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Doctor;
import Entidades.NoDoctor;
import Entidades.Profesor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.INoDoctorDAO;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Vastem
 */
public class NoDoctorDAO implements INoDoctorDAO{
    private MongoDatabase bd;
    private IConexionDB con;
    
    public NoDoctorDAO(IConexionDB con){
        this.con = con;                      
        this.bd = con.crearConexion();
    }
    
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
        MongoCollection <NoDoctor> coleccion = this.getColecion();
        
        Document filtro = new Document("nombre", ndoctor.getNombre());
        Document cambios = new Document()
                .append("nombre", ndoctor.getNombre())
                .append("apellido", ndoctor.getApellidos())
                .append("despacho", ndoctor.getDespacho())
                .append("telefono", ndoctor.getTelefono());               

        coleccion.updateOne(filtro, new Document("$set", cambios));
        return true;
    }

    @Override
    public List<Profesor> cosultarTodos() {
        MongoCollection <NoDoctor> coleccion = this.getColecion();
        List<Profesor> lDoc = new LinkedList<>();
        coleccion.find().into(lDoc);
        return lDoc;
    }
    
}
