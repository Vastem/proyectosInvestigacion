/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import Entidades.PublicacionRevista;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionDB;
import interfaces.IPublicacionRevistaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Vastem
 */
public class PublicacionRevistaDAO implements IPublicacionRevistaDAO{
    private MongoDatabase bd;
    private IConexionDB con;    
    
    public PublicacionRevistaDAO(IConexionDB con) {
        this.con = con;                      
        this.bd = con.getInstanceConexion();
    }
    
    private MongoCollection <PublicacionRevista>getColecion(){
        return this.bd.getCollection("revista", PublicacionRevista.class);
    }
    
    @Override
    public boolean agregar(PublicacionRevista revista) {
        MongoCollection <PublicacionRevista> coleccion = this.getColecion();
        coleccion.insertOne(revista);
        return true;}

    @Override
    public List<Publicacion> cosultarTodos() {
        MongoCollection <PublicacionRevista> coleccion = this.getColecion();
        List<Publicacion> lRevista = new LinkedList<>();
        coleccion.find().into(lRevista);
        return lRevista;
    }
    
    public List<Publicacion> consultarTitulo(String titulo){
        MongoCollection <PublicacionRevista> coleccion = this.getColecion();
        List<Publicacion> publicacion = coleccion.aggregate(Arrays.asList( new Document("$match", new Document("titulo", titulo)))).into(new ArrayList());
        if(publicacion.isEmpty()){
             return null;
         }
        return publicacion;
    }
    
}
