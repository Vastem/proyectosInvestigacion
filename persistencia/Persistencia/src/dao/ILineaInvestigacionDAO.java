/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.LineaInvestigacion;
import java.util.List;

/**
 *
 * @author Vastem
 */
public interface ILineaInvestigacionDAO {
    public boolean agregar(LineaInvestigacion lInvestigacion);
    public boolean eliminar(LineaInvestigacion lInvestigacion);
    public boolean actualizar(LineaInvestigacion lInvestigacion);
    public List<LineaInvestigacion> cosultarTodos();
}
