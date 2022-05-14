/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

import Entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vastem
 */
public class Proyectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
            
        Doctor d1 = new Doctor("Isaac","Newton","Física","123456");
        Doctor d2 = new Doctor("Juan","Perez","Física","123456");
        
        
        NoDoctor nD1 = new NoDoctor("Elon","Musk","Empresario","123456");
        NoDoctor nD2 = new NoDoctor("Raul","Hernandez","Físico mátematico","11223344");
        
        List<NoDoctor> supervisados = new ArrayList<>();
        supervisados.add(nD1);
        supervisados.add(nD2);
        
        List<Profesor> profesores = new ArrayList<>();
        profesores.add(d1);
        profesores.add(nD1);
        profesores.add(nD2);
        
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-mm-dd");
        Date f3 = obj.parse("2022-02-27");
        Date f4 = obj.parse("2023-02-27");
        
        PeriodoSup sp1= new PeriodoSup(d1,supervisados,f3,f4);
        
        System.out.println("Periodo de supervision");
        System.out.println("Doctor: "+sp1.getSupervisor().getNombre());
        System.out.println("Supervisado 1: "+sp1.getNoDoctores().get(0).getNombre()+" "+sp1.getNoDoctores().get(0).getApellidos());
        System.out.println("Supervisado 2: "+sp1.getNoDoctores().get(1).getNombre()+" "+sp1.getNoDoctores().get(1).getApellidos());
        System.out.println("Periodo: "+(obj.format(sp1.getFechaInicio()))+" - "+(obj.format(sp1.getFechaFin())));
        System.out.println("");
        
        Date f1 = obj.parse("2022-02-27");
        Date f2 = obj.parse("2023-02-27");
        
        Date f1p2 = obj.parse("2023-02-27");
        Date f2p2 = obj.parse("2024-02-27");
       
        
        EnRevista pu1 = new EnRevista(1,"Ley de Gravedad","RevistaPedro","ITSON",1,37,80);
        EnRevista pu2 = new EnRevista(2,"Ley de Gravedad", "RevistaPedro","ITSON",2,45,76);
        EnCongreso pu3 = new EnCongreso(3,"Ley de Gravedad", "Congreso Gravedad",f1, f2,"Nayarit","canada","san pedro");
       
        
        List<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(pu1);
        publicaciones.add(pu2);
        
    }
    
}
