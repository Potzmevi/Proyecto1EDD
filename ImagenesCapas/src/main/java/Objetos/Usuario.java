/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructuras.ListaDoble;
import Nodos.NodoListaDoble;

/**
 *
 * @author meza4
 */
public class Usuario {
    String id;
    ListaDoble imagenes;
    
    public Usuario(String nombre) {
        
        this.id = nombre;
        this.imagenes = new ListaDoble();
    }
    
    public Usuario(String nombre, ListaDoble imagenes) {
        this(nombre);
        this.imagenes = imagenes;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getString(){
        return this.id;
    }
    
    public void agregarImagen(String id,Imagen imagen){
        imagenes.insertar(id,new NodoListaDoble(id,imagen));
    }
    
    public void eliminarImagen(String id){
        imagenes.eliminar(id);
    }
    
    public void limpiarLista(){
        imagenes = new ListaDoble();
    }
    
    public NodoListaDoble buscarImagen(String id) {
        return imagenes.buscar(id);
    }
    
    public void setListaImagenes(ListaDoble imagenes) {
        this.imagenes = imagenes;
    }
    
    public String getImString(){
        String salida = "";
        NodoListaDoble aux = imagenes.inicio;
        NodoListaDoble fin = imagenes.fin;
        if(aux != null){
            salida += aux.getId();
            aux = aux.getSiguiente();
            if(aux != fin){
                while(aux != null) {
                    salida += ",";
                    salida += aux.getId();
                    aux = aux.getSiguiente();
                }
            }
            return salida;
        }
        return null;
    
    }
}
