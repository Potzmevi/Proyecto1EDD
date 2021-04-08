/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructuras.Cola;
import Estructuras.MatrizDispersa;
import Nodos.NodoListaDoble;
import Nodos.NodoMatriz;
import java.io.IOException;

/**
 *
 * @author meza4
 */
public class Imagen {
    private String id;
    private Cola capas;
    private Cola cola;
    private MatrizDispersa imagen;
    
    public Imagen(String id) {
        this.id = id;
        capas = new Cola();
        cola = new Cola();
        imagen = null;
    }
    
    public Imagen(String id,Cola capas) {
        this(id);
        this.capas = capas;
    }
    
    
    public void setCapas(Cola capas) {
        this.capas = capas;
    }
    
    public void graficar() throws IOException {
        //System.out.println("Imagen: " + id + "\n\n");
        if(this.imagen == null) {
            imagen = hacerImagen();
        }   
        imagen.graficarMatriz();
        
    }
    
    public MatrizDispersa hacerImagen(){
        MatrizDispersa imAgen = new MatrizDispersa();
        if(capas.estaVacia()) return null;
        NodoListaDoble aux = capas.descolar();
        MatrizDispersa capa;
        while(aux != null) {
            capa = ((Capa)aux.getContenido()).getMatriz();
            int filas = capa.totalFilas;
            int columnas = capa.totalColumnas;
            for(int y = 1;y <=filas;y++) {
                for (int x = 1;x<=columnas;x++) {
                    NodoMatriz nodo = capa.triangular(x, y);
                    //System.out.println("Coordenada actual ("+x+","+y+")\n");
                    if(nodo != null) {
                        //System.out.println("Insertando en X: " + x + " en Y: " + y + " el color: " + nodo.getHexaColor());
                        imAgen.insertar(nodo.getY(), nodo.getX(), nodo.getHexaColor());
                    }
                }
            }
            aux = capas.descolar();
        }
        return imAgen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public MatrizDispersa getImagen() {
        return imagen;
    }

    public void setImagen(MatrizDispersa imagen) {
        this.imagen = imagen;
    }
    
    
    
    
    
    
    
}
