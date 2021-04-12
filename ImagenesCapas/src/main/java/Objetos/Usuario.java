/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructuras.ColaImagenes;
import Estructuras.ListaDoble;
import Nodos.NodoCola;
import Nodos.NodoListaDoble;

/**
 *
 * @author meza4
 */
public class Usuario {
    private String id;
    private ColaImagenes imagenes;
    
    public Usuario(String nombre) {
        
        this.id = nombre;
        this.imagenes = new ColaImagenes();
    }
    
    public Usuario(String nombre, ColaImagenes imagenes) {
        this(nombre);
        this.imagenes = imagenes;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getString(){
        return this.id;
    }

    public ColaImagenes getImagenes() {
        return imagenes;
    }

    public void setImagenes(ColaImagenes imagenes) {
        this.imagenes = imagenes;
    }
    
    
    
    
    
    public void limpiarLista(){
        imagenes = new ColaImagenes();
    }
    
    
    
    public void setListaImagenes(ColaImagenes imagenes) {
        this.imagenes = imagenes;
    }
    
    
    
}
