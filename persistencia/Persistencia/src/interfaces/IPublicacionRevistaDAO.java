/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.EnRevista;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IPublicacionRevistaDAO {
    public boolean agregar(EnRevista revista);
    public boolean eliminar(EnRevista revista);
    public boolean actualizar(EnRevista revista);
    public List<EnRevista> cosultarTodos();
}
