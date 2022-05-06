/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.EnCongreso;
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
    
    private MongoCollection <EnCongreso>getColecion(){
        return this.bd.getCollection("congreso", EnCongreso.class);
    }
    
    @Override
    public boolean agregar(EnCongreso congreso) {
        MongoCollection <EnCongreso> coleccion = this.getColecion();
        coleccion.insertOne(congreso);
        return true;
    }

    @Override
    public boolean eliminar(EnCongreso congreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(EnCongreso congreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnCongreso> cosultarTodos() {
        MongoCollection <EnCongreso> coleccion = this.getColecion();
        List<EnCongreso> lCongreso = new LinkedList<>();
        coleccion.find().into(lCongreso);
        return lCongreso;
    }
    
}
