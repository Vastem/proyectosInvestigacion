/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Publicacion;
import Entidades.PublicacionCongreso;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IPublicacionCongresoDAO {
    public boolean agregar(PublicacionCongreso congreso);
    public List<Publicacion> cosultarTodos();
    public List<Publicacion> consultarTitulo(String titulo);
}
