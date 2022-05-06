/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.NoDoctor;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface INoDoctorDAO {
    public boolean agregar(NoDoctor ndoctor);
    public boolean eliminar(NoDoctor ndoctor);
    public boolean actualizar(NoDoctor ndoctor);
    public List<NoDoctor> cosultarTodos();
}
