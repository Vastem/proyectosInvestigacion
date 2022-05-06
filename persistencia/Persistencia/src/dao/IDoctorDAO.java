/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.Doctor;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface IDoctorDAO {
    public boolean agregar(Doctor doctor);
    public boolean eliminar(Doctor doctor);
    public boolean actualizar(Doctor doctor);
    public List<Doctor> cosultarTodos();
}
