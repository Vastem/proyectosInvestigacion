/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import Entidades.Programa;
import daos.DaosFactory2;
import interfaces.IProgramaBO;
import interfaces.IProgramaDAO;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ProgramaBO implements IProgramaBO{

    private IProgramaDAO programa;
    
    public ProgramaBO() {
        DaosFactory2 dF=new DaosFactory2();
        programa=dF.createProgramaDAO();
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
        return programa.cosultarTodos();
    }
    
}
