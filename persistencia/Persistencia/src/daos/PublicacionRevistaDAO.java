/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.EnRevista;
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
    
    private MongoCollection <EnRevista>getColecion(){
        return this.bd.getCollection("revista", EnRevista.class);
    }
    
    @Override
    public boolean agregar(EnRevista revista) {
        MongoCollection <EnRevista> coleccion = this.getColecion();
        coleccion.insertOne(revista);
        return true;
    }

    @Override
    public boolean eliminar(EnRevista revista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(EnRevista revista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnRevista> cosultarTodos() {
         MongoCollection <EnRevista> coleccion = this.getColecion();
        List<EnRevista> lRev = new LinkedList<>();
        coleccion.find().into(lRev);
        return lRev;
    }
    
}
