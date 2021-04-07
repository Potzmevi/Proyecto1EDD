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
public class NodoListaDoble {
    private String id;
    private Object contenido;
    private NodoListaDoble siguiente;
    private NodoListaDoble anterior;

    public NodoListaDoble(String id,Object contenido) {
        this.id = id;
        this.contenido=contenido;
    }

    public String getId() {
        return id;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }
}
