/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Objetos.Imagen;

/**
 *
 * @author meza4
 */
public class NodoCola {
    private Imagen imagen;
    private NodoCola siguiente;

    public NodoCola(Imagen imagen, NodoCola siguiente) {
        this.imagen = imagen;
        this.siguiente = siguiente;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
