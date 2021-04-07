/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Estructuras;


import Nodos.NodoListaDoble;

/**
 *
 * @author meza4
 */
public class ListaDoble {
    
    public NodoListaDoble inicio,fin;
    public int size;
    
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean listaVacia(){
        if(inicio == null && fin == null) return true;
        return false;
    }
    
    public void insertar(String id,Object info){
        NodoListaDoble nodo = crearNodo(id,info);
        if(listaVacia()){
            inicio = fin = nodo;
            inicio.setSiguiente(fin);
        } else {
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
        }
        size++;
    }
    
    public void insertar(NodoListaDoble nodito){
        NodoListaDoble nodo = nodito;
        if(listaVacia()){
            inicio = fin = nodo;
            inicio.setSiguiente(fin);
            fin.setAnterior(inicio);
        } else {
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
        }
        size++;
    }

    public NodoListaDoble eliminar(String id){
        if(listaVacia()){
            System.out.println("Lista Vacia");
            return null;
        }
        NodoListaDoble aux = inicio;
        if(id.equals(inicio.getId())) {
            inicio = inicio.getSiguiente();
            return aux;
        } else if(id.equals(fin.getId())) {
            aux= fin;
            fin = fin.getAnterior();
            return aux;
        } else {

            while(aux.getSiguiente() != null) {
                if(aux.getId().equals(id))
                    break;
                aux = aux.getSiguiente();
            }
            if(id.equals(aux.getId())) {
                NodoListaDoble anterior = aux.getAnterior();
                NodoListaDoble siguiente = aux.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
                size--;
                return aux;
            }
            return null;

        }
    }
    
    public NodoListaDoble buscar(String id) {
        if(listaVacia()){
            return null;
        }
        NodoListaDoble aux = inicio;
        if(id.equals(inicio.getId())) {
            return aux;
        } else if(id.equals(fin.getId())) {
            aux= fin;
            return aux;
        } else {
            if(inicio != fin){
                while(aux.getSiguiente() != null) {
                    if(aux.getId().equals(id))
                        return aux;
                    aux = aux.getSiguiente();
                }
                if(id.equals(aux.getId())) {
                    return aux;
                }
            }
            return null;
        }
    }
    public static NodoListaDoble crearNodo(String id,Object info) {
        return new NodoListaDoble(id,info);
    }
}
