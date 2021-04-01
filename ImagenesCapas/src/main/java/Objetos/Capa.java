/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructuras.Cola;
import Estructuras.MatrizDispersa;
import Nodos.NodoLista;

/**
 *
 * @author meza4
 */
public class Capa {
    private int id;
    private MatrizDispersa matriz;
    
    public Capa(int id,MatrizDispersa matriz) {
        this.id = id;
        this.matriz = matriz;
    }
    
    public int getId(){
        return this.id;
    }
    
    public MatrizDispersa getMatriz() {
        return this.matriz;
    }
    
    public Cola getNodos(){
        Cola cola = new Cola();
        for(int y = 1;y<=matriz.totalFilas;y++) {
            for(int x = 1;x<=matriz.totalColumnas;x++) {
                cola.encolar(new NodoLista(cola.size()+1 + "",matriz.triangular(x, y)));
            }
        }
        return cola;
    }
}
