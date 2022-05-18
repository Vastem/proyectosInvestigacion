/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.LineaInvestigacion;
import daos.DaosFactory;
import daos.PersistenciaFachada;
import interfaces.ILineaInvestigacionBO;
import interfaces.ILineaInvestigacionDAO;
import interfaces.IPersistenciaFachada;
import java.util.List;

/**
 *
 * @author Erick
 */
public class LineaInvestigacionBO implements ILineaInvestigacionBO{
    private IPersistenciaFachada perFac;

    public LineaInvestigacionBO() {
        perFac = new PersistenciaFachada();
    }

    @Override
    public boolean agregar(LineaInvestigacion lineaInv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(LineaInvestigacion lineaInv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(LineaInvestigacion lineaInv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LineaInvestigacion consultar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LineaInvestigacion> consultarTodos() {
        return perFac.cosultarTodosLineaInv();
    }
    
}
