/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Doctor;
import Entidades.Profesor;
import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.IPublicacionCongresoDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Vastem
 */
public class PublicacionCongresoDAO implements IPublicacionCongresoDAO{
    private MongoDatabase bd;
    private IConexionDB con;
    
    public PublicacionCongresoDAO(IConexionDB con) {
        this.con = con;                      
        this.bd = con.getInstanceConexion();
    }
    
    private MongoCollection <PublicacionCongreso>getColecion(){
        return this.bd.getCollection("congreso", PublicacionCongreso.class);
    }

    @Override
    public boolean agregar(PublicacionCongreso congreso) {
        MongoCollection <PublicacionCongreso> coleccion = this.getColecion();
        coleccion.insertOne(congreso);
        return true;
    }

    @Override
    public List<Publicacion> cosultarTodos() {
        MongoCollection <PublicacionCongreso> coleccion = this.getColecion();
        List<Publicacion> lCongreso = new LinkedList<>();
        coleccion.find().into(lCongreso);
        return lCongreso;
    }
    
    public List<Publicacion> consultarTitulo(String titulo){
        MongoCollection <PublicacionCongreso> coleccion = this.getColecion();
        List<Publicacion> publicacion = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("titulo", titulo)))).into(new ArrayList());
        if(publicacion.isEmpty()){
             return null;
         }
        return publicacion;
    }
    
}
