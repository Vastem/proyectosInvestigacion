/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Doctor;
import Entidades.Profesor;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface IDoctorDAO {
    public boolean agregar(Doctor doctor);
    public boolean eliminar(Doctor doctor);
    public boolean actualizar(Doctor docBuscar, Doctor docActualiza);
    public List<Profesor> cosultarTodos();
}
