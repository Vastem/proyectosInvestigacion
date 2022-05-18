/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;

/**
 *
 * @author Vastem
 */
public class PublicacionRevista extends Publicacion{
    protected String nombreRevista; 
    protected String editorial; 
    protected int volumen;
    protected int numero;
    protected int cantidadPaginas;

    public PublicacionRevista(int numeroSecuencia, String titulo) {
        super(numeroSecuencia, titulo);
    }

    public PublicacionRevista() {
    }
    
    public PublicacionRevista(int numeroSecuencia, String titulo, String nombreRevista, String editorial, int volumen, int numero, int cantidadPaginas) {
        super(numeroSecuencia, titulo);
        this.nombreRevista = nombreRevista;
        this.editorial = editorial;
        this.volumen = volumen;
        this.numero = numero;
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(int numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "EnRevista{" + "nombreRevista=" + nombreRevista + ", editorial=" + editorial + ", volumen=" + volumen + ", numero=" + numero + ", cantidadPaginas=" + cantidadPaginas + '}';
    }
    
    
    
    
}
