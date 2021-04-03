/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoMatriz;
import java.io.File;
import java.io.IOException;
import Main.Main;

/**
 *
 * @author meza4
 */
public class MatrizDispersa {

    private int totalNodos;
    public int totalFilas;
    public int totalColumnas;
    private NodoMatriz inicio;
    
    public MatrizDispersa() {
        inicio = new NodoMatriz(0,0,null);
        totalNodos = totalFilas = totalColumnas = 0;
    }
    
    public void insertarNodo(NodoMatriz nodo) {
    }
    
    public NodoMatriz crearNodo(int x, int y,String color) {
        return new NodoMatriz(x,y,color);
    }
    
    public NodoMatriz insertarFila(int fila) {
        NodoMatriz cabeza = inicio.getSigFila();
        NodoMatriz nuevo = new NodoMatriz(0,fila,null);
        if(cabeza == null) {
            inicio.setSigFila(nuevo);
            nuevo.setAntColumna(inicio);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicio.setSigFila(nuevo);
                nuevo.setAntFila(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSigFila() != null) {
                    if(aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        totalFilas++;
                        return nuevo;
                    }
                    aux = aux.getSigFila();
                }
                aux.setSigFila(nuevo);
                nuevo.setAntFila(aux);
            }
        }
        
        if(fila > totalFilas) {
            totalFilas = fila;
        }
        return nuevo;
    }
    
    public NodoMatriz insertarColumna(int columna) {
        NodoMatriz cabeza = inicio.getSigColumna();
        NodoMatriz nuevo = new NodoMatriz(columna,0,null);
        if(cabeza == null) {
            inicio.setSigColumna(nuevo);
            nuevo.setAntColumna(inicio);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicio.setSigColumna(nuevo);
                nuevo.setAntColumna(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSigColumna() != null) {
                    if(aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        totalColumnas++;
                        return nuevo;
                    }
                    aux = aux.getSigColumna();
                }
                aux.setSigColumna(nuevo);
                nuevo.setAntColumna(aux);
            }
        }
        if(columna > totalColumnas) {
            totalColumnas = columna;
        }
        return nuevo;
    }
    
    
    public NodoMatriz obtenerFila(int fila,boolean flag) {
        NodoMatriz aux = inicio.getSigFila();
        while(aux != null) {
            if(aux.getY() == fila){
                return aux;
            }
            aux = aux.getSigFila();
        }
        if(flag)
            return insertarFila(fila);
        return null;
    }
    
    public NodoMatriz obtenerColumna(int columna,boolean flag) {
        NodoMatriz aux = inicio.getSigColumna();
        while(aux != null) {
            if(aux.getX() == columna){
                return aux;
            }
            aux = aux.getSigColumna();
        }
        if(flag)
            return insertarColumna(columna);
        return null;
    }
    
    public NodoMatriz triangular(int columna,int fila) {
        NodoMatriz nodoColumna = obtenerColumna(columna,false);
        if(nodoColumna != null){
            NodoMatriz aux = nodoColumna;
            while(aux != null) {
                if(aux.getY() == fila) {
                    return aux;
                }
                aux = aux.getSigFila();
            }
            return null;
        } else {
            return null;
        }
    }
    
    public void insertar(int columna, int fila,String color) {
        NodoMatriz nuevo = new NodoMatriz(columna,fila,color);
        if(color.equals("#ffffff") || color.equals("#FFFFFF") || color.equals("#fFfFfF") || color.equals("#FfFfFf")){}else{
        this.insertar(nuevo);}
    }
    
    public void insertar(NodoMatriz nodo) {
        NodoMatriz nuevo = nodo;
        int fila = nodo.getY();
        int columna = nodo.getX();
        String color = nodo.getHexaColor();
        NodoMatriz inicioFila = obtenerFila(fila,true);
        NodoMatriz inicioColumna = obtenerColumna(columna,true);
    
        ///////////////////// Insercion en columna /////////////////////
        
        NodoMatriz cabeza = inicioColumna.getSigFila();
        if(cabeza == null) {
            inicioColumna.setSigFila(nuevo);
            nuevo.setAntFila(inicioColumna);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicioColumna.setSigFila(nuevo);
                nuevo.setAntFila(inicioColumna);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSigFila() != null) {
                    if(aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSigFila();
                }
                if (!insertado) {
                    aux.setSigFila(nuevo);
                    nuevo.setAntFila(aux);
                }
            }
        }
        ////////////////// insercion en fila /////////////////////
        cabeza = inicioFila.getSigColumna();
        if(cabeza == null) {
            inicioFila.setSigColumna(nuevo);
            nuevo.setAntColumna(inicioFila);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicioFila.setSigColumna(nuevo);
                nuevo.setAntColumna(inicioFila);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSigColumna() != null) {
                    if(aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSigColumna();
                }
                if(!insertado) {
                    aux.setSigColumna(nuevo);
                    nuevo.setAntColumna(aux);
                }
            }
        }
    totalNodos++;
    }
    
    public void graficarMatriz() throws IOException{
        String salida = "digraph dibujo{\nnode [shape=plaintext]\na [label=<<TABLE BORDER=\"1\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n";
        for(int y = 1;y<=this.totalFilas;y++) {
            salida = salida + "<TR>  ";
            for(int x = 1;x<= this.totalColumnas;x++) {
                if(triangular(x,y) != null) {
                    salida = salida + "<TD BGCOLOR=\""+triangular(x,y).getHexaColor()+"\"></TD>  ";
                } else {
                    salida = salida + "<TD BGCOLOR=\"#FFFFFF\"></TD>  ";
                }
            }
            salida = salida + "</TR>\n";
        }
        salida = salida+"</TABLE>>];\n}";
        File imagenSalida = new File("./grafica.dot");
        if(!imagenSalida.exists()){
            imagenSalida.createNewFile();
        } else {
            imagenSalida.delete();
            imagenSalida.createNewFile();
        }
        Main.saveFile(salida, imagenSalida.getAbsolutePath());
        String command = "dot -Tpng grafica.dot -o ImagenGenerada.png"; 
        Runtime.getRuntime().exec(command);
    }         
}
 