/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import Entidades.PublicacionRevista;
import daos.PersistenciaFachada;
import interfaces.IPersistenciaFachada;
import interfaces.IPublicacionCongresoBO;
import interfaces.IPublicacionRevistaBO;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class PublicacionCongresoBO implements IPublicacionCongresoBO{
    private IPersistenciaFachada perFac;

    public PublicacionCongresoBO() {
        perFac = new PersistenciaFachada();
    }

    @Override
    public List<Publicacion> cosultarTodos() {
        return perFac.cosultarTodosPublicacionCongreso();
    }

    @Override
    public boolean agregar(PublicacionCongreso congreso) {
        return perFac.agregar(congreso);
    }

    @Override
    public List<Publicacion> consultarTitulo(String titulo) {
        return perFac.cosultarTituloCongreso(titulo);
    }
    
}
