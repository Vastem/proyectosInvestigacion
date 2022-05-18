/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.PublicacionCongreso;
import Entidades.NoDoctor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IPublicacionCongresoDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class PublicacionCongresoDAO implements IPublicacionCongresoDAO{
    private MongoDatabase bd;
    
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
    public boolean eliminar(PublicacionCongreso congreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(PublicacionCongreso congreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PublicacionCongreso> cosultarTodos() {
        MongoCollection <PublicacionCongreso> coleccion = this.getColecion();
        List<PublicacionCongreso> lCongreso = new LinkedList<>();
        coleccion.find().into(lCongreso);
        return lCongreso;
    }
    
}
