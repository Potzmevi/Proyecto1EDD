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
public class Cola implements Cloneable{
    NodoListaDoble inicio, fin;
    int size;
    
    public Cola(){
        inicio = fin = null;
        size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public void encolar(NodoListaDoble nuevo){
        if(!estaVacia()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            size++;
        } else {
            inicio = fin = nuevo;
        }
    }
    
    public NodoListaDoble descolar() {
        if(!estaVacia()) {
            NodoListaDoble aux = inicio;
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
    
    public void setInicio(NodoListaDoble nodo){
        this.inicio = nodo;
    }
    
    public void setFinal(NodoListaDoble nodo){
        this.fin = nodo;
    }
    
    public NodoListaDoble getInicio(){
        return this.inicio;
    }
    
    public NodoListaDoble getFinal(){
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
