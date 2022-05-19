/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Publicacion;
import Entidades.PublicacionRevista;
import daos.PersistenciaFachada;
import interfaces.IPersistenciaFachada;
import interfaces.IPublicacionRevistaBO;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class PublicacionRevistaBO implements IPublicacionRevistaBO{
    private IPersistenciaFachada perFac;

    public PublicacionRevistaBO() {
        perFac = new PersistenciaFachada();
    }
    
    
    @Override
    public boolean agregar(PublicacionRevista revista) {
        return perFac.agregar(revista);
    }

    @Override
    public List<Publicacion> cosultarTodos() {
        return perFac.cosultarTodosPublicacionRevista();
    }
    
    public List<Publicacion> consultarTitulo(String titulo) {
        return perFac.cosultarTituloRevista(titulo);
    }
    
}
