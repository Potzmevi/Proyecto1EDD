/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author meza4
 */
public class NodoCola {
    String id;
    NodoCola siguiente;
    Object info;
    
    public NodoCola(String id,Object info){
        this.id = id;
        this.info = info;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
