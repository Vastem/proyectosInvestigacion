/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Programa;
import daos.DaosFactory;
import daos.PersistenciaFachada;
import interfaces.IPersistenciaFachada;
import interfaces.IProgramaBO;
import interfaces.IProgramaDAO;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ProgramaBO implements IProgramaBO{
    private IPersistenciaFachada perFac;

    
    public ProgramaBO() {
        perFac = new PersistenciaFachada();
    }
    
    
    
    @Override
    public boolean agregar(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Programa consultar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Programa> consultarTodos() {
        return perFac.cosultarTodosPrograma();
    }
    
}
