/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoCola;

/**
 *
 * @author meza4
 */
public class Cola  {

    NodoCola inicio;
    NodoCola fin;
    int size;

    public Cola() {
        inicio = fin = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void encolar(NodoCola nuevo) {
        if (!estaVacia()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            size++;
        } else {
            inicio = nuevo;
            fin = nuevo;
        }
    }

    public NodoCola descolar() {
        if (!estaVacia()) {
            NodoCola aux = inicio;
            if (inicio == fin) {
                inicio = null;
                fin = null;
                size--;
                return aux;
            }

            inicio = inicio.getSiguiente();
            size--;
            return aux;
        }
        System.out.println("Cola Vacia");
        return null;
    }

    public boolean estaVacia() {
        if (inicio == fin && inicio == null) {
            return true;
        }
        return false;
    }

    public void setInicio(NodoCola nodo) {
        this.inicio = nodo;
    }

    public void setFinal(NodoCola nodo) {
        this.fin = nodo;
    }

    public NodoCola getInicio() {
        return this.inicio;
    }

    public NodoCola getFinal() {
        return this.fin;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
