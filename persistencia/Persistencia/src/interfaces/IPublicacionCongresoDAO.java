/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.EnCongreso;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IPublicacionCongresoDAO {
    public boolean agregar(EnCongreso congreso);
    public boolean eliminar(EnCongreso congreso);
    public boolean actualizar(EnCongreso congreso);
    public List<EnCongreso> cosultarTodos();
}
