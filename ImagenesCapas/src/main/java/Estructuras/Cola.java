/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoLista;

/**
 *
 * @author meza4
 */
public class Cola implements Cloneable {
    NodoLista inicio, fin;
    int size;
    
    public Cola(){
        inicio = fin = null;
        size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public void encolar(NodoLista nuevo){
        if(!estaVacia()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            size++;
        } else {
            inicio = fin = nuevo;
        }
    }
    
    public NodoLista descolar() {
        if(!estaVacia()) {
            NodoLista aux = inicio;
            if(inicio == fin) {
                inicio = fin = null;
                size--;
                return aux;
            }
            
            inicio = inicio.getSiguiente();
            size--;
            return aux;
        }
            System.out.println("Lista Vacia");
            return null;
    }
    
    public boolean estaVacia(){
        if(inicio == fin && inicio == null) return true;
        return false;
    }
    
    public void setInicio(NodoLista nodo){
        this.inicio = nodo;
    }
    
    public void setFinal(NodoLista nodo){
        this.fin = nodo;
    }
    
    public NodoLista getInicio(){
        return this.inicio;
    }
    
    public NodoLista getFinal(){
        return this.fin;
    }
    
    public void setSize(int size){
        this.size = size;
    }

    @Override
    public Cola clone() throws CloneNotSupportedException {
        return (Cola)super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
