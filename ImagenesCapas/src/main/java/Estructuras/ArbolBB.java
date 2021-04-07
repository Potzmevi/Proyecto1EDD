package Estructuras;

import Nodos.NodoAb;
import Nodos.NodoListaDoble;
import javax.swing.JOptionPane;

public class ArbolBB {

    private NodoAb raiz;
    private String nombre;
    private Cola cola;

    public ArbolBB() {

    }

    public ArbolBB(String nombre) {
        this.nombre = nombre;
        raiz = null;
    }

    public boolean estaVacio() {
        
        if (raiz == null) {
            return true;
        }
        return false;
    }

    public void insertar(int llave, Object dato) {
        if (estaVacio()) {
            raiz = new NodoAb(llave, dato);
        } else {
            raiz.insertar(llave, dato);
        }
    }

    public void insertar(NodoAb nodo) {
        
        if (estaVacio()) {
            raiz = nodo;
        } else {
            raiz.insertar(nodo);
        }
    }

    public NodoAb buscar(int id, NodoAb raiz) {
        
        if (estaVacio()) {
            return null;
        }
        if (id < raiz.llave) {
            if (null == raiz.izq) {
            } else {
                return buscar(id, raiz.izq);
            }
        } else if (id > raiz.llave) {
            if (null == raiz.der) {
            } else {
                return buscar(id, raiz.der);
            }
        } else if (id == raiz.llave) {
            return raiz;
        }
        return null;
    }

    public NodoAb buscar(int id) {
        
        return buscar(id, this.raiz);
    }

    private void inOrden(NodoAb nodo) {
        if (null == nodo) {
            return;
        }
        inOrden(nodo.izq);
        cola.encolar(new NodoListaDoble((cola.size + 1) + "", nodo.dato));
        inOrden(nodo.der);
    }

    private void preOrden(NodoAb nodo) {
        if (null == nodo) {
            return;
        }
        cola.encolar(new NodoListaDoble((cola.size + 1) + "", nodo.dato));
        preOrden(nodo.izq);
        preOrden(nodo.der);
    }

    private void postOrden(NodoAb nodo) {
        if (null == nodo) {
            return;
        }
        postOrden(nodo.izq);
        postOrden(nodo.der);
        cola.encolar(new NodoListaDoble((cola.size + 1) + "", nodo.dato));
    }

    public Cola inOrden() {
        this.cola = new Cola();
        inOrden(this.raiz);
        return cola;

    }

    public Cola preOrden() {
        preOrden(this.raiz);
        return cola;
    }

    public Cola postOrden() {
        postOrden(this.raiz);
        return cola;
    }

    private int profundidad(NodoAb raiz) {
        if (null == raiz) {
            return 0;
        }

        int profundidadI = profundidad(raiz.izq);
        int profundidadD = profundidad(raiz.der);

        return (profundidadI > profundidadD) ? profundidadI + 1 : profundidadD + 1;
    }

    public int profundidad() {
        return profundidad(this.raiz);
    }

    public int totalNodos(NodoAb raiz) {
        if (null == raiz) {
            return 0;
        }

        int a = totalNodos(raiz.izq);
        int b = totalNodos(raiz.der);
        return a + b + 1;
    }

    public int totalNodos() {
        return totalNodos(raiz);
    }

    public int totalHojas() {
        return totalHojas(this.raiz);
    }

    public int totalHojas(NodoAb raiz) {
        int total = 0;
        if (raiz == null) {
            return -1;
        }
        int a = totalHojas(raiz.izq);
        int b = totalHojas(raiz.der);
        if (a == -1 && b == -1) {
            return 1;
        } else {
            if (a == -1) {
                return b;
            } else if (b == -1) {
                return a;
            } else {
                return a + b;
            }
        }
    }
}
