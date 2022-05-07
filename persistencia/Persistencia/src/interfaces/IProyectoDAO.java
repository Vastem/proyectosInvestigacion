/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Proyecto;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface IProyectoDAO {
    public boolean agregar(Proyecto proyecto);
    public boolean eliminar(Proyecto proyecto);
    public boolean actualizar(Proyecto proyecto);
    public List<Proyecto> cosultarTodos();
}