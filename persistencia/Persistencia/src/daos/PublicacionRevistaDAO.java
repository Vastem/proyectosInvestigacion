/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.PublicacionRevista;
import Entidades.NoDoctor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IPublicacionRevistaDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class PublicacionRevistaDAO implements IPublicacionRevistaDAO{
    private MongoDatabase bd;
    
    private MongoCollection <PublicacionRevista>getColecion(){
        return this.bd.getCollection("revista", PublicacionRevista.class);
    }
    
    @Override
    public boolean agregar(PublicacionRevista revista) {
        MongoCollection <PublicacionRevista> coleccion = this.getColecion();
        coleccion.insertOne(revista);
        return true;
    }

    @Override
    public boolean eliminar(PublicacionRevista revista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(PublicacionRevista revista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PublicacionRevista> cosultarTodos() {
         MongoCollection <PublicacionRevista> coleccion = this.getColecion();
        List<PublicacionRevista> lRev = new LinkedList<>();
        coleccion.find().into(lRev);
        return lRev;
    }
    
}
