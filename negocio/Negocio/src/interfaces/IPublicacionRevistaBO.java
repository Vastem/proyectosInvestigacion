/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Publicacion;
import Entidades.PublicacionRevista;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IPublicacionRevistaBO {
    public boolean agregar(PublicacionRevista revista);
    public List<Publicacion> cosultarTodos();
    public List<Publicacion> consultarTitulo(String titulo);
}
