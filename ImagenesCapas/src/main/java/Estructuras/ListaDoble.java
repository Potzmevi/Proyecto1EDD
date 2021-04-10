/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Estructuras;


import Nodos.NodoListaDoble;
import javax.swing.JOptionPane;

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
    
    public void insertar(NodoListaDoble nuevoNodo) {
       
            if (inicio == null)
            {
                inicio = nuevoNodo;
                fin = nuevoNodo;
                size++;
            } else if (nodoNoExiste(nuevoNodo.getId()))
            {
                fin.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(fin);
                fin = nuevoNodo;
                size++;
            } else
            {
                JOptionPane.showMessageDialog(null, "La imagen: " + nuevoNodo.getId() + " ya existe para el usuario");
            }
    }
    
     public boolean nodoNoExiste(String id) {
        NodoListaDoble aux = inicio;
        while (aux != null)
        {
            if (aux.getId().equals(id))
            {
                return false;
            }
            aux = aux.getSiguiente();
        }
        return true;
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
    
   public NodoListaDoble eliminar(String id){
        if(listaVacia()){
            return null;
        }
        NodoListaDoble aux = inicio;
        if(inicio==fin && id.equals(inicio.getId())){
            inicio=null;
            fin=null;
            return aux;
        }
        else if(id.equals(inicio.getId())) {
            inicio = inicio.getSiguiente();
            inicio.setAnterior(null);
            return aux;
        } else if(id.equals(fin.getId())) {
            aux= fin;
            fin = fin.getAnterior();
            fin.setSiguiente(null);
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
