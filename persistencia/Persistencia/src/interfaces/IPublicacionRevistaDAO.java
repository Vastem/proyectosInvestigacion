/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.PublicacionRevista;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IPublicacionRevistaDAO {
    public boolean agregar(PublicacionRevista revista);
    public boolean eliminar(PublicacionRevista revista);
    public boolean actualizar(PublicacionRevista revista);
    public List<PublicacionRevista> cosultarTodos();
}
