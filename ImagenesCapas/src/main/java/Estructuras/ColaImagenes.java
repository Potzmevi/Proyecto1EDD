/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoCola;
import Nodos.NodoListaDoble;
import Objetos.Imagen;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author meza4
 */
public class ColaImagenes {

    private NodoCola raiz, fondo;
    private int size = 0;

    public ColaImagenes() {
        raiz = null;
        fondo = null;
    }

    boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Imagen imagen) {

        if (imagen != null) {
            NodoCola nuevo = new NodoCola(imagen, raiz);
            if (vacia()) {
                raiz = nuevo;
                fondo = nuevo;
            } else {
                fondo.setSiguiente(nuevo);
                fondo = nuevo;
            }
            size++;
        } else {
            JOptionPane.showMessageDialog(null, "No existe ninguna imagen con ese id");
        }
    }

    public Imagen extraer() {
        if (!vacia()) {
            Imagen informacion = raiz.getImagen();
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.getSiguiente();
            }

            return informacion;
        } else {
            return null;
        }
    }

    public void imprimir() {
        NodoCola imagen = raiz;
        while (imagen != null) {
            System.out.print(imagen.getImagen().getId() + "-");
            imagen = imagen.getSiguiente();
        }
        System.out.println();
    }

    public ArrayList<String> obtenerImagenes() {
        ArrayList<String> lista = new ArrayList<>();
        NodoCola imagen = raiz;
        while (imagen != null) {
            lista.add(imagen.getImagen().getId());
            imagen = imagen.getSiguiente();
            if (imagen == fondo) {
                lista.add(imagen.getImagen().getId());
                break;
            }
        }
        return lista;
    }

    public void eliminar(String id) {
        NodoCola actual = raiz;
        NodoCola anterior=null;
        boolean encontrado = false;
        if(raiz!=null){
             while (actual != null && encontrado!=true) {
                  if (actual.getImagen().getId().equals(id)) {
                      if(actual==raiz){
                          raiz=raiz.getSiguiente();
                      }else if(actual==fondo){
                          anterior.setSiguiente(null);
                          fondo=anterior;
                      }else{
                          anterior.setSiguiente(actual.getSiguiente());
                      }
                      encontrado=true;
                      size--;
                  }
                  anterior=actual;
                  actual=actual.getSiguiente();
             }
        }
        
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
