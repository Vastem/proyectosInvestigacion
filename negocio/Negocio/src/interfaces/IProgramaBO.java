/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.Programa;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface IProgramaBO {
    public boolean agregar(Programa programa);
    public boolean eliminar(Programa programa);
    public boolean actualizar(Programa programa);
    public Programa consultar(String nombre);
    public List<Programa> consultarTodos();
}
