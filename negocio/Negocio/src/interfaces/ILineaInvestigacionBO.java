/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entidades.LineaInvestigacion;
import java.util.List;

/**
 *
 * @author Erick
 */
public interface ILineaInvestigacionBO {
    public boolean agregar(LineaInvestigacion lineaInv);
    public boolean eliminar(LineaInvestigacion lineaInv);
    public boolean actualizar(LineaInvestigacion lineaInv);
    public LineaInvestigacion consultar(String codigo);
    public List<LineaInvestigacion> consultarTodos();
}
